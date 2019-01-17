package server;

import java.rmi.Naming;

import remote.EasyBookingRemoteFacade;
import remote.IEasyBookingRemoteFacade;



public class EasyBookingServer{

	public static void main(String[] args) {
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
	
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IEasyBookingRemoteFacade TVServer = new EasyBookingRemoteFacade(args[0] , args[1], args[2], args[3], args[4], args[5]);
			Naming.rebind(name, TVServer);
			System.out.println("- EasyBookingServer '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ EasyBookingServer exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}