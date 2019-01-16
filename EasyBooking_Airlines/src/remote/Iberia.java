package remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dto.ServerFlightDTO;

public class Iberia extends Thread implements IAirlines{

	private static final long serialVersionUID = 1L;

	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	private List<ServerFlightDTO> sendFlight = new ArrayList<ServerFlightDTO>();
	private List<ServerFlightDTO> flights = new ArrayList<ServerFlightDTO>();
	
	public Iberia(Socket socket) {
		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# EchoService - TCPConnection IO error:" + e.getMessage());
		}
		
		flights = new ArrayList<>();
		flights.add(new ServerFlightDTO(1, 2, "11:30", "13:00", "bilbao", "madrid", 30, "16/01/2019"));
		flights.add(new ServerFlightDTO(2, 2, "16:30", "19:00", "bilbao", "madrid", 40, "16/01/2019"));
		flights.add(new ServerFlightDTO(3, 2, "10:30", "13:00", "bilbao", "madrid", 2,  "17/01/2019"));
		flights.add(new ServerFlightDTO(1, 2, "17:30", "20:00", "bilbao", "madrid", 50, "18/01/2019"));
	}
	
	public void run() {
	
			try {
				//Read request from the client
				String data = this.in.readUTF();
				System.out.println("   - EchoService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");							
				
				String[] a = data.split("#");
				if(a[0].equals("search")) {
					
					sendFlight = searchFlight(a[1], a[2], a[3],Integer.parseInt(a[4]));
					String send = "";
					for(ServerFlightDTO f : sendFlight) {
						send += f.getFlight_number()+"#"+f.getAirline_code()+"#"+f.getDepartureTime()+"#"+f.getArrivalTime()+"#"+f.getOrigin()+"#"+f.getDestiny()+"#"+f.getSeats()+"#"+f.getDate()+"-" ;
					}
					this.out.writeUTF(send);
				}else {
					bookFlight();
				}
					
				System.out.println("   - EchoService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
			} catch (EOFException e) {
				System.err.println("   # EchoService - TCPConnection EOF error" + e.getMessage());
			} catch (IOException e) {
				System.err.println("   # EchoService - TCPConnection IO error:" + e.getMessage());
			} finally {
				try {
					tcpSocket.close();
				} catch (IOException e) {
					System.err.println("   # EchoService - TCPConnection IO error:" + e.getMessage());
				}
			}
	}
	
	@Override
	public List<ServerFlightDTO> searchFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException {
		
		List<ServerFlightDTO> ret = new ArrayList<>();
		
		for(ServerFlightDTO f : flights) {
			if(f.getOrigin().equals(OriginAirpot) && f.getDestiny().equals(DestinyAirport) && f.getSeats() <= seats && f.getDate().equals(date)) {
				ret.add(f);
			}
		}
		return ret;
	}
	
	@Override
	public void bookFlight() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("book");
	}
	
}
