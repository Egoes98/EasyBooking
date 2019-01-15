package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class PayPal extends UnicastRemoteObject implements IPayment{

	
	private static final long serialVersionUID = 1L;
	private String serverName;
	
	String[] payment = new String[4];
	HashMap<String, String[]> pAccounts = new HashMap<String, String[]>();

	public PayPal(String serverName) throws RemoteException {
		this.serverName = serverName;
		
		payment[0] = "Paypal";
		payment[1] = "Egoitz";
		payment[2] = "12345";
		pAccounts.put(payment[1], payment);
		
		payment[0] = "Paypal";
		payment[1] = "Alvaro";
		payment[2] = "12345";
		pAccounts.put(payment[1], payment);
	}


	@Override
	public boolean makePayment(String[] pData) throws RemoteException {
		if(pAccounts.containsKey(pData[1])) {
			if(pAccounts.get(pData[1])[2].equals(pData[2])) {
				return true;
			}
		}
		return false;
	}
}
