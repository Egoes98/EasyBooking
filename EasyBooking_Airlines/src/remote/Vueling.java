package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

import easyBookingData.Flight;

public class Vueling extends UnicastRemoteObject implements IAirlines{

	
	
	private static final long serialVersionUID = 1L;
	private String serverName;
	
	public Vueling(String serverName) throws RemoteException {
		super();
		this.serverName = serverName;
	}
	
	@Override
	public List<Flight> searchFlight() throws RemoteException {
		System.out.println("search");
		return null;
		
	}
	@Override
	public void bookFlight() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("book");
	}
	

}
