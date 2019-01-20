package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dto.ServerFlightDTO;

public class Vueling extends UnicastRemoteObject implements IAirlines{
	
	private static final long serialVersionUID = 1L;
	private String serverName;
	List<ServerFlightDTO> flights;
	
	public Vueling(String serverName) throws RemoteException {
		super();
		this.serverName = serverName;
		
		flights = new ArrayList<>();
		flights.add(new ServerFlightDTO(1, 1, "11:30", "13:00", "bilbao", "madrid", 30, "16/1/2019"));
		flights.add(new ServerFlightDTO(2, 1, "16:30", "19:00", "bilbao", "madrid", 40, "16/1/2019"));
		flights.add(new ServerFlightDTO(3, 1, "10:30", "13:00", "bilbao", "madrid", 2,  "17/1/2019"));
		flights.add(new ServerFlightDTO(4, 1, "17:30", "20:00", "bilbao", "madrid", 50, "18/1/2019"));
		
	}

	@Override
	public List<ServerFlightDTO> searchFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException {
		
		List<ServerFlightDTO> ret = new ArrayList<>();
		System.out.println(OriginAirpot + " " + DestinyAirport +" "+ date + " " + seats);
		
		for(ServerFlightDTO f : flights) {
			if(f.getOrigin().equals(OriginAirpot) && f.getDestiny().equals(DestinyAirport) && seats <= f.getSeats() && f.getDate().equals(date)) {
				System.out.println(f.getFlight_number()+"#"+f.getAirline_code()+"#"+f.getDepartureTime()+"#"+f.getArrivalTime()+"#"+f.getOrigin()+"#"+f.getDestiny()+"#"+f.getSeats()+"#"+f.getDate());
				ret.add(f);
			}
		}
		if(ret.size() == 0) ret.add(new ServerFlightDTO(10, 1, "No results.", "", "", "", 0, ""));
		return ret;
		
	}
	@Override
	public void bookFlight() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("book");
	}
	

}
