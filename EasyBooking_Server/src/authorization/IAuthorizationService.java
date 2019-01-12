package authorization;

import java.rmi.RemoteException;

public interface IAuthorizationService {
	
	public void registerUser() throws RemoteException;
	public void loginUser() throws RemoteException;
	
}
