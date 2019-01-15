package payment;

import java.rmi.RemoteException;

import remote.IPayment;


public class VisaGateway implements IPaymentService{

	private IPayment service;
	
	public VisaGateway() {
		
	}
	
	public void setService(String ip, String port, String FacebookName) {
		String name = "//" + ip + ":" + port + "/" + FacebookName;
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
	public boolean makePayment() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
}
