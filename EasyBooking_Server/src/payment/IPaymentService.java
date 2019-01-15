package payment;

import java.rmi.RemoteException;

public interface IPaymentService {
	
	public boolean makePayment(String[] pData) throws RemoteException;
	
	
}
