package easyBookingData;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Persistent;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import javax.jdo.annotations.Join;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class User {

	@PrimaryKey
	private String email;
	private String authorization_sys;
	
	private String payment_method;
	
	//Visa
	private String name;
	private String cardNumber;
	private String cvv;
	
	//Paypal
	private String username;
	private String password;
	
	@Persistent(defaultFetchGroup="true", mappedBy="user", dependentElement = "true")
    @Join
	private List<Reservation> res = new ArrayList<>();

	public User(String email, String authorization_sys, String[] p) {
		
		this.email = email;
		this.authorization_sys = authorization_sys;
		this.payment_method = p[0];
		if(payment_method.equals("Paypal")) {
			this.username=p[1];
			this.password=p[2];
		}else {
			this.name=p[1];
			this.cardNumber=p[2];
			this.cvv=p[3];
		}
		
	}
	
	public void makeReservation(Reservation r) {
		res.add(r);
	}
	
	public void cancelReservation(int index) {
		this.res.remove(index);
	}
	
	public List<Reservation> getReservation() {
		return res;
	}

	public String getAuthorization() {
		return authorization_sys;
	}
	
	public void setAuthorization(String authorization_sys) {
		this.authorization_sys = authorization_sys;
	}
	
	public String getUserEmail() {
		return email;
	}
	
	public String getPaymentMethod() {
		return this.payment_method;
	}	
	public void setPaymentMethod(String payment_method) {
		this.payment_method = payment_method;
	}
	public String[] getPData() {
		String[] p = new String[4];
		p[0] = payment_method;
		if(payment_method.equals("Paypal")) {
			p[1] = username;
			p[2] = password;
		}else {
			p[1] = name;
			p[2] = cardNumber;
			p[3] = cvv;
		}
		return p;
	}
	
}
