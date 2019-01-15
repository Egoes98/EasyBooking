package payment;

import java.rmi.RemoteException;

import remote.IAuthorization;

public class PaymentService implements IPaymentService{

	VisaGateway visa;
	PayPalGateway payPal;
	
	public PaymentService(VisaGateway visa, PayPalGateway payPal) {
		// TODO Auto-generated constructor stub
		this.visa = visa;
		this.payPal = payPal;
	}
	


	@Override
	public void makePayment() throws RemoteException {
		visa.getService().makePayment();
		payPal.getService().makePayment();
		
	}


}
