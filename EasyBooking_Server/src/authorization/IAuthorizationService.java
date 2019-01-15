package authorization;

import java.rmi.RemoteException;

public interface IAuthorizationService {
	public boolean loginUser(String email,String password) throws RemoteException;
	
}
