package es.deusto.ingenieria.sd.sms.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEasyBookingRemoteFacade extends Remote {  
    public void searchForFlight() throws RemoteException;
    public void bookFlight() throws RemoteException;
    public void loginUser() throws RemoteException;
    public void makePayment() throws RemoteException;
    public void notifyAirline() throws RemoteException;
    public void registerUser() throws RemoteException;
    
 }