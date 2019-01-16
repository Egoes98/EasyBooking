package airlines;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dto.FlightDTO;
import dto.ServerFlightDTO;
import easyBookingData.Flight;

public class IberiaGateway implements IAirlineService{

	
	public IberiaGateway() {
		
	}
	
	@Override
	public List<ServerFlightDTO> searchFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException{
		
		List<ServerFlightDTO> ret = new ArrayList<ServerFlightDTO>();
		//args[0] = Server IP
		String serverIP = "0.0.0.0";
		//args[1] = Server socket port
		int serverPort = 1100;
				
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
				 //Streams to send and receive information are created from the Socket
			     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
				 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
				
				//Send request (a String) to the server
			
				String ftext =  OriginAirpot +"#"+ DestinyAirport + "#" + date + "#" + seats;
			
				out.writeUTF("search#"+ftext);
				System.out.println(" - TCPSocketClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort());
				
				//Read response (a String) from the server
				String data = in.readUTF();
				System.out.println(data);
				String[] lista = data.split("-");
				
				for(int i = 0; i <= lista.length-1; i++) {
					String[] info = lista[i].split("#");
					ret.add(new ServerFlightDTO(Integer.parseInt(info[0]), Integer.parseInt(info[1]), info[2], info[3], info[4], info[5], Integer.parseInt(info[6]), info [7]));
					
				}
				
				System.out.println(" - TCPSocketClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
				//return data;
			} catch (UnknownHostException e) {
				System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
			} catch (EOFException e) {
				System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
			} catch (IOException e) {
				System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
			}
		
		return ret;		

	}

	@Override
	public void bookFlight() throws RemoteException {
		
		//args[0] = Server IP
		String serverIP = "0.0.0.0";
		//args[1] = Server socket port
		int serverPort = 1100;
				
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
				 //Streams to send and receive information are created from the Socket
			     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
				 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
				
				//Send request (a String) to the server
					
				//String ftext =  origlan +"#"+newlan+"#"+ text;
					
				out.writeUTF("book");
				System.out.println(" - TCPSocketClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' ->" + "search" );
						
				//Read response (a String) from the server
				String data = in.readUTF();
				/*
				 * Transformar este data en vuelos
				 */
						
				System.out.println(" - TCPSocketClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
				//return data;
			} catch (UnknownHostException e) {
				System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
			} catch (EOFException e) {
				System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
			} catch (IOException e) {
				System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
			}
		
	}

}
