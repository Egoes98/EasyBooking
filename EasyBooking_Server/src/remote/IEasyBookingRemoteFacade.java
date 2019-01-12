package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEasyBookingRemoteFacade extends Remote {  
    public void searchForFlight() throws RemoteException;
    public void bookFlight() throws RemoteException;
    public boolean loginUser(String method,String email,String password) throws RemoteException;
    public void makePayment() throws RemoteException;
    public void notifyAirline() throws RemoteException;
    public void registerUser(String method,String email,String password, String[] payment) throws RemoteException;
    
 }