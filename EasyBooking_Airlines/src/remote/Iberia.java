package remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Iberia extends Thread implements IAirlines{

	private static final long serialVersionUID = 1L;

	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	
	public Iberia(Socket socket) {
		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# EchoService - TCPConnection IO error:" + e.getMessage());
		}
	}
	
	public void run() {
	
			try {
				//Read request from the client
				String data = this.in.readUTF();
				System.out.println("   - EchoService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");							
				
				
				if(data.equals("search")) {
					searchFlight();
				}else {
					bookFlight();
				}
				
				//Send response to the client
				this.out.writeUTF(data.toUpperCase());			
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
	public void searchFlight() throws RemoteException {
		System.out.println("search");
		
	}
	@Override
	public void bookFlight() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("book");
	}
	
}
