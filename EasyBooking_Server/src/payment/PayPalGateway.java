package payment;

import java.rmi.RemoteException;

import remote.IPayment;

public class PayPalGateway implements IPaymentService{

	private IPayment service;
	
	public PayPalGateway() {
		
	}
	
	public void setService(String ip, String port, String GoogleName) {
		String name = "//" + ip + ":" + port + "/" + GoogleName;
		try {
			service = (IPayment) java.rmi.Naming.lookup(name);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public IPayment getService() {
		return service;
	}

	@Override
	public boolean makePayment(String[] pData) throws RemoteException {	
		return service.makePayment(pData);;
	}
	
	
	

	
}
