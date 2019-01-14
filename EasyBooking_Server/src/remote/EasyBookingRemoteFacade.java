package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import airlines.*;
import authorization.*;

import easyBookingData.*;

public class EasyBookingRemoteFacade extends UnicastRemoteObject implements IEasyBookingRemoteFacade {

	private static final long serialVersionUID = 1L;
	private String ip;
	private String port;
	private String AuthorizationName;
	private String serverName;
	private FacebookGateway Facebookservice = new FacebookGateway();
	private GoogleGateway GoogleService = new GoogleGateway();
	private VuelingGateway VuelingService = new VuelingGateway();
	private IberiaGateway IberiaService = new IberiaGateway();
	AuthorizationService aS;
	AirlineService aiS;
	HashMap<String, User> account = new HashMap<String, User>();

	public EasyBookingRemoteFacade(String ip, String port, String serverName, String AuthorizationName) throws RemoteException {
		super();
		this.serverName = serverName;
		
		//Authorization
		
		Facebookservice.setService(ip, port, "Facebook");
		GoogleService.setService(ip, port, "Google");
		
		aS = new AuthorizationService(Facebookservice, GoogleService);
		
		//Airlines
		
		VuelingService.setService(ip, port, "Vueling");
		
		aiS = new AirlineService(VuelingService, IberiaService);
		
		//Facebook Test Accounts
		
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
		
		//Google Test Accounts
		
		payment[0] = "Visa";
		payment[1] = "Alvaro";
		payment[2] = "12345";
		payment[3] = "123";
		account.put("alvaroh@opendeusto.es", new User("alvaroh@opendeusto.es", "Google+", payment));
		payment[0] = "Visa";
		payment[1] = "Egoitz";
		payment[2] = "12345";
		account.put("alvarotest@opendeusto.es", new User("test@opendeusto.es", "Google+", payment));
		
		
	}

	
	//--------------------------------------------


	@Override
	public void searchForFlight() throws RemoteException {
		
		aiS.searchFlight();
	}

	@Override
	public void bookFlight() throws RemoteException {
		
		aiS.bookFlight();
	}

	@Override
	public boolean loginUser(String method,String email,String password) throws RemoteException {

		return aS.loginUser(method, email, password);
	}

	@Override
	public void makePayment() throws RemoteException {
		System.out.println("TODO-makePayment");
	}

	@Override
	public void notifyAirline() throws RemoteException {
		
		
	}

	@Override
	public void registerUser(String method,String email,String password, String[] payment) throws RemoteException {
		
		account.put(email, new User(email, method, payment));
		aS.registerUser(method, email, password);
	}
}