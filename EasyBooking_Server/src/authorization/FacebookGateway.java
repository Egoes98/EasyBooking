package authorization;

import java.rmi.RemoteException;

import remote.IAuthorization;


public class FacebookGateway implements IAuthorizationService{

	private IAuthorization service;
	
	public FacebookGateway() {
		
	}
	
	public void setService(String ip, String port, String FacebookName) {
		String name = "//" + ip + ":" + port + "/" + FacebookName;
		try {
			service = (IAuthorization) java.rmi.Naming.lookup(name);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public IAuthorization getService() {
		return service;
	}
	
	@Override
	public void registerUser(String method,String email,String password) throws RemoteException{
		// TODO Auto-generated method stub
		service.registerUser(email,password);
	}

	@Override
	public boolean loginUser(String method,String email,String password) throws RemoteException {
		// TODO Auto-generated method stub
		return service.loginUser(email,password);
	}

	
}
