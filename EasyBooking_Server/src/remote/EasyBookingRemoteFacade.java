package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import authorization.FacebookGateway;

public class EasyBookingRemoteFacade extends UnicastRemoteObject implements IEasyBookingRemoteFacade {

	private static final long serialVersionUID = 1L;
	private String ip;
	private String port;
	private String FacebookName;
	private String serverName;
	private FacebookGateway Facebookservice = new FacebookGateway();

	public EasyBookingRemoteFacade(String ip, String port, String serverName, String FacebookName) throws RemoteException {
		super();
		this.serverName = serverName;
		Facebookservice.setService(ip, port, "Facebook");
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
		System.out.println("Login sent");
		IFacebook a = Facebookservice.getService();
		a.loginUser();
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