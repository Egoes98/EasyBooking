package server;

import java.rmi.Naming;

import remote.Visa;
import remote.IPayment;


public class VisaServer{

	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IPayment VisaServer = new Visa(args[2]);
			Naming.rebind(name, VisaServer);
			System.out.println("- EasyBookingServer '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ EasyBookingServer exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
