package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import easyBookingData.Flight;

public class Vueling extends UnicastRemoteObject implements IAirlines{

	
	
	private static final long serialVersionUID = 1L;
	private String serverName;
	List<Flight> flights;
	
	public Vueling(String serverName) throws RemoteException {
		super();
		this.serverName = serverName;
		
		flights = new ArrayList<>();
		flights.add(new Flight(1, 1, "11:30", "13:00", "bilbao", "madrid", 30, "16/01/2019"));
		flights.add(new Flight(2, 1, "16:30", "19:00", "bilbao", "madrid", 40, "16/01/2019"));
		flights.add(new Flight(3, 1, "10:30", "13:00", "bilbao", "madrid", 2,  "17/01/2019"));
		flights.add(new Flight(1, 1, "17:30", "20:00", "bilbao", "madrid", 50, "18/01/2019"));
	}
	
	@Override
	public List<Flight> searchFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException {
		List<Flight> ret = new ArrayList<>();
		
		for(Flight f : flights) {
			if(f.getOrigin().equals(OriginAirpot) && f.getDestiny().equals(DestinyAirport) && f.getSeats() == seats && f.getDate().equals(date)) {
				ret.add(f);
			}
		}
		return ret;
		
	}
	@Override
	public void bookFlight() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("book");
	}
	

}
