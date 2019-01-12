package authorization;

import java.rmi.RemoteException;

import remote.IFacebook;


public class FacebookGateway implements IAuthorizationService{

	private IFacebook service;
	
	public FacebookGateway() {
		
	}
	
	public void setService(String ip, String port, String FacebookName) {
		String name = "//" + ip + ":" + port + "/" + FacebookName;
		try {
			service = (IFacebook) java.rmi.Naming.lookup(name);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public IFacebook getService() {
		return service;
	}
	
	@Override
	public void registerUser() throws RemoteException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loginUser() throws RemoteException {
		// TODO Auto-generated method stub
		service.loginUser();
	}

	
}
