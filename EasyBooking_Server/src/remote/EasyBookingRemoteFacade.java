package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import airlines.*;
import authorization.*;
import dao.UserDAO;
import dto.FlightAssembler;
import dto.FlightDTO;
import dto.ReservationDTO;
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
	User currentAccount;
	UserDAO uDAO = new UserDAO();

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
		uDAO.createUser(new User("egoitz.a.c@opendeusto.es", "Facebook", payment));
		payment[0] = "Paypal";
		payment[1] = "Egoitz";
		payment[2] = "12345";
		uDAO.createUser(new User("test@test.es", "Facebook", payment));
		//For testing when database not working
		//currentAccount = new User("test@test.es", "Facebook", payment);
		//Google Test Accounts
		
		payment[0] = "Visa";
		payment[1] = "Alvaro";
		payment[2] = "12345";
		payment[3] = "123";
		uDAO.createUser(new User("alvaroh@opendeusto.es", "Google+", payment));
		payment[0] = "Paypal";
		payment[1] = "Alvaro";
		payment[2] = "12345";
		uDAO.createUser(new User("alvaro@test.es", "Google+", payment));
		
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
			Reservation r = new Reservation(f.getDate(), f.getFlight_number(), f.getSeats());
			uDAO.createRes(r);
			return true;
		}else {
			System.out.println("Payment could not be done!");
			return false;
		}
	}

	@Override
	public boolean loginUser(String email,String password) throws RemoteException {
		//For testing when database not working comment the next code
		currentAccount = uDAO.getUser(email);
		if(currentAccount == null) {
			return false;
		}
		if(AuthorizationService.createGateway(currentAccount.getAuthorization(),ip,port).loginUser(email, password)) {
			return true;
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
			User u = new User(email, method, payment);
			uDAO.createUser(u);
			return true;
		}else {
			System.out.println(method + " Account doesnt exist");
			return false;
		}

	}
	
	@Override
	public void cancelFlight(int index) throws RemoteException {
		currentAccount.cancelReservation(index);
		uDAO.updateUser(currentAccount);
	}


	@Override
	public List<ReservationDTO> getReservation() throws RemoteException {
		FlightAssembler fa = new FlightAssembler();
		return fa.assembleR(currentAccount.getReservation());
	}
	
}