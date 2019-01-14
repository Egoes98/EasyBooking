package airlines;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

public class IberiaGateway implements IAirlineService{

	
	public IberiaGateway() {
		
	}
	
	@Override
	public void searchFlight() throws RemoteException{
		
		//args[0] = Server IP
		String serverIP = "0.0.0.0";
		//args[1] = Server socket port
		int serverPort = 35600;
				
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
				 //Streams to send and receive information are created from the Socket
			     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
				 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
				
				//Send request (a String) to the server
			
				//String ftext =  origlan +"#"+newlan+"#"+ text;
			
				out.writeUTF("search");
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

	@Override
	public void bookFlight() throws RemoteException {
		
		//args[0] = Server IP
		String serverIP = "0.0.0.0";
		//args[1] = Server socket port
		int serverPort = 35600;
				
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
				 //Streams to send and receive information are created from the Socket
			     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
				 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
				
				//Send request (a String) to the server
					
				//String ftext =  origlan +"#"+newlan+"#"+ text;
					
				out.writeUTF("search");
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
