package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import easyBookingData.Flight;

public interface IAirlines extends Remote{

	 public List<Flight> searchFlight() throws RemoteException;
	 public void bookFlight() throws RemoteException;
	 
}
