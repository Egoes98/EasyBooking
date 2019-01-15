package airlines;

import java.rmi.RemoteException;

public interface IAirlineService {
	
	public void searchFlight() throws RemoteException;
	public void bookFlight() throws RemoteException;

}
