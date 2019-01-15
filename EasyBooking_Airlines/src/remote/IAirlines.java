package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAirlines extends Remote{

	 public void searchFlight() throws RemoteException;
	 public void bookFlight() throws RemoteException;
	 
}
