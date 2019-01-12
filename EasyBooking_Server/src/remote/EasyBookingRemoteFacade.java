package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import authorization.AuthorizationServce;
import authorization.FacebookGateway;
import authorization.GoogleGateway;

import easyBookingData.*;

public class EasyBookingRemoteFacade extends UnicastRemoteObject implements IEasyBookingRemoteFacade {

	private static final long serialVersionUID = 1L;
	private String ip;
	private String port;
	private String FacebookName;
	private String serverName;
	private FacebookGateway Facebookservice = new FacebookGateway();
	private GoogleGateway GoogleService = new GoogleGateway();
	AuthorizationServce aS;
	HashMap<String, User> account = new HashMap<String, User>();

	public EasyBookingRemoteFacade(String ip, String port, String serverName, String FacebookName) throws RemoteException {
		super();
		this.serverName = serverName;
		Facebookservice.setService(ip, port, "Facebook");
		aS = new AuthorizationServce(Facebookservice, GoogleService);
		String[] payment = new String[4];
		payment[0] = "Visa";
		payment[1] = "Egoitz";
		payment[2] = "12345";
		payment[3] = "123";
		account.put("egoitz.a.c@opendeusto.es", new User("egoitz.a.c@opendeusto.es", "Facebook", payment));
		payment[0] = "Visa";
		payment[1] = "Egoitz";
		payment[2] = "12345";
		account.put("test@opendeusto.es", new User("test@opendeusto.es", "Facebook", payment));
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
	public boolean loginUser(String method,String email,String password) throws RemoteException {
		// TODO Auto-generated method stub
		return aS.loginUser(method, email, password);
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
	public void registerUser(String method,String email,String password, String[] payment) throws RemoteException {
		// TODO Auto-generated method stub
		account.put(email, new User(email, method, payment));
		aS.registerUser(method, email, password);
	}
}