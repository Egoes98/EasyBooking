package payment;

import java.rmi.RemoteException;

import remote.IAuthorization;

public enum PaymentService{
	INSTANCE;
	
	public static IPaymentService createGateway(String method, String ip, String port) {
		if(method.equals("Visa")) {
			VisaGateway v = new VisaGateway();
			v.setService(ip, port, "Visa");
			return v;
		}else {
			PayPalGateway p = new PayPalGateway();
			p.setService(ip, port, "Paypal");
			return p;
		}
	}
}
