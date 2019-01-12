package authorization;

import java.rmi.RemoteException;

public class GoogleGateway implements IAuthorizationService{

	@Override
	public void registerUser(String method, String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loginUser(String method, String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
}
