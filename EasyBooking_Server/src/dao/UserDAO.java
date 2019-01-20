package dao;

import java.util.List;

import easyBookingData.Reservation;
import easyBookingData.User;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class UserDAO implements IUserDAO{
	
	private PersistenceManagerFactory pmf;
	
	public UserDAO() {
		// TODO Auto-generated constructor stub
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	@Override
	public User getUser(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		
		Transaction tx = pm.currentTransaction();
		User user = null;
		
		try {
			System.out.println(" * Querying a User: " + email);
			
			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE name== '" + email + "'");
			query.setUnique(true);
			user = (User)query.execute();
			tx.commit();
		}catch(Exception ex) {
			System.out.println("Error storing object:" + ex.getMessage());
		}finally {
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
		return null;
	}

	@Override
	public void createUser(User u) {
		this.storeObject(u);
	}

	private void storeObject(Object o) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			System.out.println(" * Storing an object: " + o);
			pm.makePersistent(o);
			tx.commit();
		}catch(Exception ex) {
			System.out.println("Error storing object:" + ex.getMessage());
		}finally {
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public void updateUser(User u) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();
            pm.makePersistent(u);
            tx.commit();
         } catch (Exception ex) {
               System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
         } finally {
               if (tx != null && tx.isActive()) {
                   tx.rollback();
               }

               pm.close();
         }
    }
}
