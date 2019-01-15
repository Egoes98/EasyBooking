package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.FlightDTO;

public interface IEasyBookingRemoteFacade extends Remote {  
	//Creo que serian el mismo, pero de momento para probar lo dejo separado
    public void searchForFlight() throws RemoteException;
    public List<FlightDTO> getFlights() throws RemoteException;
    //
    public void bookFlight() throws RemoteException;
    public boolean loginUser(String method,String email,String password) throws RemoteException;
    public void makePayment() throws RemoteException;
    public void notifyAirline() throws RemoteException;
    public void registerUser(String method,String email,String password, String[] payment) throws RemoteException;
    
 }