package es.deusto.ingenieria.sd.sms.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.sms.server.remote.EasyBookingRemoteFacade;
import es.deusto.ingenieria.sd.sms.server.remote.IEasyBookingRemoteFacade;



public class EasyBookingServer{

	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IEasyBookingRemoteFacade TVServer = new EasyBookingRemoteFacade(args[2]);
			Naming.rebind(name, TVServer);
			System.out.println("- EasyBookingServer '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ EasyBookingServer exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}