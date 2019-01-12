package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacebook extends Remote{

	 public boolean loginUser(String email,String password) throws RemoteException;
	 public void registerUser(String email,String password) throws RemoteException;
	 
}
