package airlines;

import java.rmi.RemoteException;

import authorization.FacebookGateway;
import authorization.GoogleGateway;

public enum AirlineService{
	INSTANCE;
	public static IAirlineService createGateway(String airline,String ip, String port) {
		if(airline.equals("Vueling")) {
			VuelingGateway v = new VuelingGateway();
			v.setService(ip, port, "Vueling");
			return v;
		}else{
			IberiaGateway i = new IberiaGateway();
			return i;
		}
	}
}
