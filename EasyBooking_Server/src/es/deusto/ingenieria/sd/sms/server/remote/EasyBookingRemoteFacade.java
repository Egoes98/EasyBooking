package es.deusto.ingenieria.sd.sms.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EasyBookingRemoteFacade extends UnicastRemoteObject implements IEasyBookingRemoteFacade {

	private static final long serialVersionUID = 1L;
	private String serverName;

	public EasyBookingRemoteFacade(String serverName) throws RemoteException {
		super();
		this.serverName = serverName;
	}

	
	//--------------------------------------------
	
	@Override
	public void searchForFlight() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("TODO-searchForFlight");
	}

	@Override
	public void bookFlight() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("TODO-bookFlight");
	}

	@Override
	public void loginUser() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("TODO-loginUser");
	}

	@Override
	public void makePayment() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("TODO-makePayment");
	}

	@Override
	public void notifyAirline() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerUser() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("TODO-registerUser");
	}
}