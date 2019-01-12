package controller;

import java.rmi.RemoteException;


import es.deusto.ingenieria.sd.sms.server.remote.IEasyBookingRemoteFacade;
import serviceLocator.RMIServiceLocator;
import GUI.*;

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
	
	
	
    public void newTVProgram(String acronym, String description){
    	try {

    		// Add your code HERE - Related to getting the service and requesting creation of TVProgram	
    		IEasyBookingRemoteFacade a = rsl.getService();
    		a.newTVProgram(acronym, description);
    	} catch (Exception e){
    		System.err.println("$ Error sending new TV program: " + e.getMessage());
    	}
    }
    
    public void sendMessage(String phone, String text){
    	try{
    		
    		// Add your code HERE - Related to getting the service and sending a message	
    		
    		System.out.println(phone.substring(0,3));
    		if(phone.substring(0,3).equals("609")  || phone.substring(0,3).equals("629")) {
    			rsl.setService("127.0.0.1", "1099", "Movistar");
    			
    		}else if(phone.substring(0,3).equals("699")) {
    			rsl.setService("127.0.0.1", "1099", "Vodafone");
    		}
    		IEasyBookingRemoteFacade a = rsl.getService();
    		a.receiveMessage(phone, text);
    	} catch(Exception e){
    		System.out.println("$ Error sending a message: " + e.getMessage());
    	}
    }
  
    public void searchForFlight() throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	a.searchForFlight();
    }
    public void bookFlight() throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	a.bookFlight();
    }
    public void loginUser() throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	a.loginUser();
    }
    public void makePayment() throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	a.makePayment();
    }
    
    public void registerUser() throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	a.registerUser();
    }
    
    public void exit(){
    	System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException {    	
    	new Controller(args);
    	
    }
}