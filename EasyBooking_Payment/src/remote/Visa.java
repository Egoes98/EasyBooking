package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Visa extends UnicastRemoteObject implements IPayment{

	private static final long serialVersionUID = 1L;
	private String serverName;
	String[] payment = new String[4];
	HashMap<String, String[]> vAccounts = new HashMap<String, String[]>();
	
	public Visa(String serverName) throws RemoteException {
		
		this.serverName = serverName;
		payment[0] = "Visa";
		payment[1] = "Egoitz";
		payment[2] = "12345";
		payment[3] = "123";
		vAccounts.put(payment[1],payment);
		
		payment[0] = "Visa";
		payment[1] = "Alvaro";
		payment[2] = "12345";
		payment[3] = "123";
		vAccounts.put(payment[1],payment);
	}

	@Override
	public boolean makePayment(String[] pData) throws RemoteException {
		if(vAccounts.containsKey(pData[1])) {
			if(vAccounts.get(pData[1])[2].equals(pData[2]) & vAccounts.get(pData[1])[3].equals(pData[3])) {
				System.out.println("Paymend done.");
				return true;
			}
		}
		System.out.println("Incorrect payment.");
		return false;
	}
	
	
	
}
