package authorization;

import java.rmi.RemoteException;

public class AuthorizationServce implements IAuthorizationService{

	FacebookGateway facebook;
	GoogleGateway google;
	
	public AuthorizationServce(FacebookGateway facebook, GoogleGateway google) {
		// TODO Auto-generated constructor stub
		this.facebook = facebook;
		this.google = google;
	}
	
	@Override
	public void registerUser(String method, String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		if(method.equals("Google+")){
			google.registerUser(method,email,password);
		}else{
			facebook.registerUser(method, email, password);
		}
	}

	@Override
	public boolean loginUser(String method, String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		if(method.equals("Google+")){
			return google.loginUser(method, email, password);
		}else{
			return facebook.loginUser(method, email, password);
		}
	}



}
