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
	private List<ServerFlightDTO> sendFlightDTO = new ArrayList<ServerFlightDTO>();
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
		flights.add(new ServerFlightDTO(5, 2, "11:30", "13:00", "bilbao", "madrid", 50, "16/1/2019"));
		flights.add(new ServerFlightDTO(6, 2, "16:30", "19:00", "bilbao", "madrid", 40, "16/1/2019"));
		flights.add(new ServerFlightDTO(7, 2, "10:30", "13:00", "bilbao", "madrid", 1,  "16/1/2019"));
		flights.add(new ServerFlightDTO(8, 2, "17:30", "20:00", "bilbao", "madrid", 50, "16/1/2019"));
	}
	
	public void run() {
	
			try {
				//Read request from the client
				String data = this.in.readUTF();
				System.out.println("Petition recieved from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");							
				
				String[] a = data.split("#");
				String send = "";
				
				if(a[0].equals("search")) {
					
					System.out.println("");
					sendFlightDTO = searchFlight(a[1], a[2], a[3], Integer.parseInt(a[4]));
					
					for(ServerFlightDTO f : sendFlightDTO) {
						System.out.println(f.getFlight_number()+" "+f.getAirline_code()+" "+f.getDepartureTime()+" "+f.getArrivalTime()+" "+f.getOrigin()+" "+f.getDestiny()+" "+f.getSeats()+" "+f.getDate());
						send += f.getFlight_number()+"#"+f.getAirline_code()+"#"+f.getDepartureTime()+"#"+f.getArrivalTime()+"#"+f.getOrigin()+"#"+f.getDestiny()+"#"+f.getSeats()+"#"+f.getDate()+"-" ;
					}
					System.out.println(send);
					
				}else {
					bookFlight();
				}
					
				this.out.writeUTF(send);
				System.out.println("Flights gathered. Flight data sent to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + send + "'");
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
			if(f.getOrigin().equals(OriginAirpot) && f.getDestiny().equals(DestinyAirport) && seats <= f.getSeats() && f.getDate().equals(date)) {
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
