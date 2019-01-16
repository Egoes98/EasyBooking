package airlines;

import java.rmi.RemoteException;
import java.util.List;

import dto.ServerFlightDTO;
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
	public List<ServerFlightDTO> searchFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException {
		
		return service.searchFlight(OriginAirpot, DestinyAirport, date, seats);
		
	}

	@Override
	public void bookFlight() throws RemoteException {
		service.bookFlight();
		
	}
	
	
	
}
