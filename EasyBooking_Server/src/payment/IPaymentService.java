package payment;

import java.rmi.RemoteException;

public interface IPaymentService {
	
	public void makePayment() throws RemoteException;
	
	
}
