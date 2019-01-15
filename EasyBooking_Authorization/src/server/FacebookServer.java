package server;

import java.rmi.Naming;

import remote.Facebook;
import remote.IAuthorization;

public class FacebookServer{

	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IAuthorization FacebookServer = new Facebook(args[2]);
			Naming.rebind(name, FacebookServer);
			System.out.println("- EasyBookingServer '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ EasyBookingServer exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}