package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.FlightDTO;
import easyBookingData.Flight;
import easyBookingData.User;

public interface IEasyBookingRemoteFacade extends Remote {  
	//Creo que serian el mismo, pero de momento para probar lo dejo separado
    public  List<FlightDTO> searchForFlight(String OriginAirpot, String DestinyAirport, String date, int seats) throws RemoteException;
    //
    public boolean bookFlight(FlightDTO f) throws RemoteException;
    public boolean makePayment() throws RemoteException;
    public void notifyAirline() throws RemoteException;
    public boolean registerUser(String method,String email,String password, String[] payment) throws RemoteException;
	public boolean loginUser(String email, String password) throws RemoteException;
 }