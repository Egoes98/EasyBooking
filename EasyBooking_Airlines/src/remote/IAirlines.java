package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import data.Flight;

public interface IAirlines extends Remote{

	 public List<Flight> searchFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException;
	 public void bookFlight() throws RemoteException;
	 
}
