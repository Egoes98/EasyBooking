package server;

import java.rmi.Naming;

import remote.IAirlines;
import remote.Vueling;


public class VuelingServer{

	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IAirlines VuelingServer = new Vueling(args[2]);
			Naming.rebind(name, VuelingServer);
			System.out.println("- EasyBookingServer '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ EasyBookingServer exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
