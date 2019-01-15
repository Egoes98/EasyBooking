package airlines;

import java.rmi.RemoteException;
import java.util.List;

import easyBookingData.Flight;
import remote.IAirlines;


public class VuelingGateway implements IAirlineService{

private IAirlines service;
	
	public VuelingGateway() {
		
	}
	
	public void setService(String ip, String port, String AirlineName) {
		String name = "//" + ip + ":" + port + "/" + AirlineName;
		try {
			service = (IAirlines) java.rmi.Naming.lookup(name);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public IAirlines getService() {
		return service;
	}

	@Override
	public List<Flight> searchFlight() throws RemoteException {
		
		
		return service.searchFlight();
		
	}

	@Override
	public void bookFlight() throws RemoteException {
		service.bookFlight();
		
	}
	
	
	
}
