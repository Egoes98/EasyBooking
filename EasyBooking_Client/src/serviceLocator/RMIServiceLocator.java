package serviceLocator;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import es.deusto.ingenieria.sd.sms.server.remote.IEasyBookingRemoteFacade;

public class RMIServiceLocator{
	/** 
	 * The Cache - Limitation: one server at a time
	 * Proposed improvement: list of services
	 */
	private HashMap<String, IEasyBookingRemoteFacade> cache = new HashMap<>();
	private IEasyBookingRemoteFacade service;
    /** Creates a new instance of RMIServiceLocator */
    public RMIServiceLocator(){ 
    
    }

    public void setService(String ip, String port, String serviceName) {    
    	// Add your code to get the TARGET reference HERE    
    	String name = "//" + ip + ":" + port + "/" + serviceName;
    	try {
    		if(!cache.containsKey(name)){
    			cache.put(name, service = (IEasyBookingRemoteFacade) java.rmi.Naming.lookup(name));
    		}else {
    			service = cache.get(name);
    		}
			
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