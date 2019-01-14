package airlines;

import java.rmi.RemoteException;

import remote.IAirlines;


public class VuelingGateway implements IAirlineService{

private IAirlines service;
	
	public VuelingGateway() {
		
	}
	
	public void setService(String ip, String port, String FacebookName) {
		String name = "//" + ip + ":" + port + "/" + FacebookName;
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
	public void searchFlight() throws RemoteException {
		service.searchFlight();
		
	}

	@Override
	public void bookFlight() throws RemoteException {
		service.bookFlight();
		
	}
	
	
	
}
