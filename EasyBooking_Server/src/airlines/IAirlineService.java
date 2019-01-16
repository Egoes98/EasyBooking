package airlines;

import java.rmi.RemoteException;
import java.util.List;

import dto.ServerFlightDTO;


public interface IAirlineService {
	
	public List<ServerFlightDTO> searchFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException;
	public void bookFlight() throws RemoteException;

}
