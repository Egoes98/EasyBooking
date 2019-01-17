package airlines;

import java.rmi.RemoteException;

import authorization.FacebookGateway;
import authorization.GoogleGateway;
import easyBookingData.Airport;

public enum AirlineService{
	INSTANCE;
	public static IAirlineService createGateway(String airline,String ip, String port) {
		if(airline.equals("Vueling")) {
			System.out.println("Vueling Connecion" + airline + ip + port);
			VuelingGateway v = new VuelingGateway();
			v.setService(ip, port, airline);
			return v;
		}else{
			IberiaGateway i = new IberiaGateway(ip, port);
			return i;
		}
	}
}
