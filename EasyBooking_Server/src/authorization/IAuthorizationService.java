package authorization;

import java.rmi.RemoteException;

public interface IAuthorizationService {
	
	public void registerUser(String method,String email,String password) throws RemoteException;
	public boolean loginUser(String method,String email,String password) throws RemoteException;
	
}
