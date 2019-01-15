package airlines;

import java.rmi.RemoteException;
import java.util.List;

import easyBookingData.Flight;

public interface IAirlineService {
	
	public List<Flight> searchFlight() throws RemoteException;
	public void bookFlight() throws RemoteException;

}
