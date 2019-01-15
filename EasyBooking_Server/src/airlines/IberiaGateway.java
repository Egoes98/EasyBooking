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

import easyBookingData.Flight;

public class IberiaGateway implements IAirlineService{

	
	public IberiaGateway() {
		
	}
	
	@Override
	public List<Flight> searchFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException{
		
		List<Flight> ret = new ArrayList<Flight>();
		//args[0] = Server IP
		String serverIP = "0.0.0.0";
		//args[1] = Server socket port
		int serverPort = 1100;
				
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
				 //Streams to send and receive information are created from the Socket
			     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
				 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
				
				//Send request (a String) to the server
			
				String ftext =  "search"+"#"+OriginAirpot+"#"+DestinyAirport+"#"+date+"#"+seats;
			
				out.writeUTF(ftext);
				System.out.println(" - TCPSocketClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' ->" + "search" );
				
				//Read response (a String) from the server
				String data = in.readUTF();
				
				String[] lista = data.split("-");
				
				for(int i = 0; i <= lista.length; i++) {
					String[] info = lista[i].split("#");
					ret.add(new Flight(Integer.parseInt(lista[0]), Integer.parseInt(lista[1]), lista[2], lista[3], lista[4], lista[5], Integer.parseInt(lista[6]), lista[7]));
					
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
