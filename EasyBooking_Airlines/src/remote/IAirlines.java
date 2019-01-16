package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.ServerFlightDTO;

public interface IAirlines extends Remote{

	 public List<ServerFlightDTO> searchFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException;
	 public void bookFlight() throws RemoteException;
	 
}
