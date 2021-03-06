package serviceLocator;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import remote.IEasyBookingRemoteFacade;

public class RMIServiceLocator{
	/** 
	 * The Cache - Limitation: one server at a time
	 * Proposed improvement: list of services
	 */
		private IEasyBookingRemoteFacade service;
    /** Creates a new instance of RMIServiceLocator */
    public RMIServiceLocator(){ 
    
    }

    public void setService(String ip, String port, String serviceName) {    
    	// Add your code to get the TARGET reference HERE    
    	String name = "//" + ip + ":" + port + "/" + serviceName;
    	
    	try {
			service = (IEasyBookingRemoteFacade) java.rmi.Naming.lookup(name);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
    	
    }
    
    public IEasyBookingRemoteFacade getService() {    	
    	// Add your code to return the TARGET reference HERE
    	return service;
    }
}