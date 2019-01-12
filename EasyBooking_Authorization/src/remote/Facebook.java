package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Facebook extends UnicastRemoteObject implements IFacebook{

	
	private static final long serialVersionUID = 1L;
	private String serverName;

	public Facebook(String serverName) throws RemoteException {
		this.serverName = serverName;
	}
	
	@Override
	public void loginUser() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Hithere");
	}

	@Override
	public void registerUser() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Hi");
	}

}
