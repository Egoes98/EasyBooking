package airlines;

import java.rmi.RemoteException;

import authorization.FacebookGateway;
import authorization.GoogleGateway;

public class AirlineService implements IAirlineService{
	
	IberiaGateway iberia;
	VuelingGateway vueling;
	
	
	public AirlineService(VuelingGateway vueling, IberiaGateway iberia) {
		// TODO Auto-generated constructor stub
		this.vueling = vueling;
		this.iberia = iberia;
	}
	
	
	@Override
	public void searchFlight() throws RemoteException {
		// TODO Auto-generated method stub
		iberia.searchFlight();
		vueling.searchFlight();
	}
	@Override
	public void bookFlight() throws RemoteException {
		// TODO Auto-generated method stub
		iberia.bookFlight();
		vueling.bookFlight();
	}
	
	

}
