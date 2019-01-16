package controller;

import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;


import remote.IEasyBookingRemoteFacade;
import serviceLocator.RMIServiceLocator;
import GUI.*;
import dto.FlightDTO;


public class Controller {
	private RMIServiceLocator rsl;
	
	public Controller(String[] args) throws RemoteException {
		// Add your code HERE - Related to the Service Locator
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
		
		//Inicializar GUI - Esto lo hay que rehacer
		
		new Login(this);
		
		// Para comprobar que la conexion se realizaba sin problemas
		/* 
		 * searchForFlight();
		 * bookFlight();
		 * loginUser();
		 * registerUser();
		 * makePayment();
		 * 
		 */
	}
	
	public List<FlightDTO> searchForFlight(String OriginAirpot, String DestinyAirport, String date, int seats){ 
		List<FlightDTO> flights = new ArrayList<>();
		
		try {
			flights = rsl.getService().searchForFlight(OriginAirpot, DestinyAirport, date, seats);
			for(FlightDTO f : flights) {
				System.out.println(f.getFlight_number()+"#"+f.getAirline_code()+"#"+f.getDepartureTime()+"#"+f.getArrivalTime()+"#"+f.getOrigin()+"#"+f.getDestiny()+"#"+f.getSeats()+"#"+f.getDate());
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return flights;
	}
	
  
    public boolean bookFlight(FlightDTO f) throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	return a.bookFlight(f);
    }
    public boolean loginUser(String email, String password) throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	return a.loginUser(email, password);
    }
    public void makePayment() throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	a.makePayment();
    }
    
    public void registerUser(String method, String email, String password, String[] payment) throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	a.registerUser(method,email,password,payment);
    }
    
    
    public void exit(){
    	System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException {    	
    	new Controller(args);
    }

    public void cancelFlight(FlightDTO f) throws RemoteException {
	IEasyBookingRemoteFacade a = rsl.getService();
    	a.cancelFlight(f);
    }
	
    public List<FlightDTO> getReservation() throws RemoteException {
	IEasyBookingRemoteFacade a = rsl.getService();
    	return a.getReservation();
    }
    
}
