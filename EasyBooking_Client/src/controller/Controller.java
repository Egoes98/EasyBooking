package controller;

import java.rmi.RemoteException;


import remote.IEasyBookingRemoteFacade;
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
	
  
    public void searchForFlight() throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	a.searchForFlight();
    }
    public void bookFlight() throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	a.bookFlight();
    }
    public boolean loginUser(String method, String email, String password) throws RemoteException{
    	IEasyBookingRemoteFacade a = rsl.getService();
    	return a.loginUser(method,email,password);
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
}