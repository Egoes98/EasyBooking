package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Google extends UnicastRemoteObject implements IAuthorization{

	private static final long serialVersionUID = 1L;
	private String serverName;
	private HashMap<String, String> account = new HashMap<String, String>();

	public Google(String serverName) throws RemoteException {
		
		this.serverName = serverName;
		account.put("alvaroh@opendeusto.es", "123");
		account.put("alvaro@test.es", "test");
	}
	
	public boolean loginUser(String email,String password) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(email + " " + password);
		if(account.containsKey(email)) {
			if(account.get(email).equals(password)) {
				return true;
			}else {
				return false;
			}
		}else{
			return false;
		}
	}
	
}
