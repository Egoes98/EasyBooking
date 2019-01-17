package server;

import java.io.IOException;
import java.net.ServerSocket;

import remote.IAirlines;
import remote.Iberia;
import remote.Vueling;




public class IberiaServer{

	public static void main(String args[]) {
		if (args.length < 1) {
			System.err.println(" # Usage: TCPSocketSever [PORT]");
			System.exit(1);
		}
		
		//args[1] = Server socket port
		
		int serverPort = Integer.parseInt(args[0]);
		
		
		//Declaration of the ServerSocket (only a port number is needed)
		try (ServerSocket tcpServerSocket = new ServerSocket(serverPort);) {
			System.out.println(" - TCPSocketServer: Waiting for connections '" + tcpServerSocket.getInetAddress().getHostAddress() + ":" + tcpServerSocket.getLocalPort() + "' ...");
			
			//The main thread is always waiting for connections
			while (true) {
				//When a connection from a client is received, a new EchoService is created. The "accept()" method returns the socket to
				//communicate with the client.
				new Iberia(tcpServerSocket.accept());
			}
		} catch (IOException e) {
			System.err.println("# TCPSocketServer: IO error:" + e.getMessage());
		}
	}
}