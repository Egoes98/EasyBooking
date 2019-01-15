package authorization;

import java.rmi.RemoteException;

import remote.IAuthorization;

public enum AuthorizationService{
	INSTANCE;
	
	public static IAuthorizationService createGateway(String method, String ip, String port) {
		if(method.equals("Facebook")) {
			FacebookGateway f = new FacebookGateway();
			f.setService(ip, port, "Facebook");
			return f; 
		}else {
			GoogleGateway g = new GoogleGateway();
			g.setService(ip, port, "Google");
			return g;
		}
	}
}
