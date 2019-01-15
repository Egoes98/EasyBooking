package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPayment extends Remote{

	//Estos luego devuelven bool
	
	 public boolean makePayment(String[] pData) throws RemoteException;
	
	 
}
