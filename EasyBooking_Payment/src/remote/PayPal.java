package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class PayPal extends UnicastRemoteObject implements IPayment{

	
	private static final long serialVersionUID = 1L;
	private String serverName;
	

	public PayPal(String serverName) throws RemoteException {
		this.serverName = serverName;
		
	}


	@Override
	public void makePayment() throws RemoteException {
		System.out.println("payment");	
	}

}
