package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import airlines.*;
import authorization.*;
import dto.FlightAssembler;
import dto.FlightDTO;
import easyBookingData.*;
import payment.PayPalGateway;
import payment.PaymentService;
import payment.VisaGateway;

public class EasyBookingRemoteFacade extends UnicastRemoteObject implements IEasyBookingRemoteFacade {

	private static final long serialVersionUID = 1L;
	
	private String ip;
	private String port;
	private String AuthorizationName;;
	private String Iport;
	private String Iip;
	private String serverName;
	
	private FacebookGateway Facebookservice = new FacebookGateway();
	private GoogleGateway GoogleService = new GoogleGateway();
	private VuelingGateway VuelingService = new VuelingGateway();
	private IberiaGateway IberiaService = new IberiaGateway();
	private VisaGateway VisaService = new VisaGateway();
	private PayPalGateway PayPalService = new PayPalGateway();
	AuthorizationService aS;
	AirlineService aiS;
	PaymentService pS;
	HashMap<String, User> account = new HashMap<String, User>();
	User currentAccount;

	public EasyBookingRemoteFacade(String ip, String port, String serverName, String AuthorizationName, String Iip, String Iport) throws RemoteException {
		super();
		this.serverName = serverName;
		this.ip = ip;
		this.port = port;
		this.Iip = Iip;
		this.Iport = Iport;		
		
		//Facebook Test Accounts
		
		String[] payment = new String[4];
		payment[0] = "Visa";
		payment[1] = "Egoitz";
		payment[2] = "12345";
		payment[3] = "123";
		account.put("egoitz.a.c@opendeusto.es", new User("egoitz.a.c@opendeusto.es", "Facebook", payment));
		payment[0] = "Paypal";
		payment[1] = "Egoitz";
		payment[2] = "12345";
		account.put("test@test.es", new User("test@opendeusto.es", "Facebook", payment));
		
		//Google Test Accounts
		
		payment[0] = "Visa";
		payment[1] = "Alvaro";
		payment[2] = "12345";
		payment[3] = "123";
		account.put("alvaroh@opendeusto.es", new User("alvaroh@opendeusto.es", "Google+", payment));
		payment[0] = "Paypal";
		payment[1] = "Alvaro";
		payment[2] = "12345";
		account.put("alvarotest@opendeusto.es", new User("test@opendeusto.es", "Google+", payment));
		
		
	}

	
	//--------------------------------------------


	@Override
	public List<FlightDTO> searchForFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException {
		List<FlightDTO> flights = new ArrayList<>();
		List<FlightDTO> flightsb = new ArrayList<>();
		
		System.out.println("Flights asked");
		
		FlightAssembler a = new FlightAssembler();
		
		flights = a.assemble(AirlineService.createGateway("Iberia",Iip,Iport).searchFlight(OriginAirpot, DestinyAirport, date, seats));
		flightsb = a.assemble( AirlineService.createGateway("Vueling",ip,port).searchFlight(OriginAirpot, DestinyAirport, date, seats));
		
		
		
		flights.addAll(flightsb);
		return  flights;
	}
	
	//--------------------------------------------

	@Override
	public boolean bookFlight(FlightDTO f) throws RemoteException {
		if(makePayment()) {
			notifyAirline();
			currentAccount.makeReservation(f);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean loginUser(String email,String password) throws RemoteException {
		if(account.containsKey(email)) {
			if(AuthorizationService.createGateway(account.get(email).getAuthorization(),ip,port).loginUser(email, password)) {
				currentAccount = account.get(email);
				return true;
			}
		}
		System.out.println("Incorrect login.");
		return false;
	}

	@Override
	public boolean makePayment() throws RemoteException {
		String method = currentAccount.getPaymentMethod();
		return PaymentService.createGateway(method, ip, port).makePayment(currentAccount.getPData());
	}

	@Override
	public void notifyAirline() throws RemoteException {
		
		
	}

	@Override
	public boolean registerUser(String method,String email,String password, String[] payment) throws RemoteException {
		if(AuthorizationService.createGateway(method,ip,port).loginUser(email, password)) {
			account.put(email, new User(email, method, payment));
			return true;
		}else {
			System.out.println(method + " Account doesnt exist");
			return false;
		}

	}
	
	@Override
	public void cancelFlight(int index) throws RemoteException {
		currentAccount.cancelReservation(index);
	}


	@Override
	public List<FlightDTO> getReservation() throws RemoteException {
		return currentAccount.getReservation();
	}
	
}