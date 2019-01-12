package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacebook extends Remote{

	 public void loginUser() throws RemoteException;
	 public void registerUser() throws RemoteException;
	 
}
