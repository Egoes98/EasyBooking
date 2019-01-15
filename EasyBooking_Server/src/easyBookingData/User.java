package easyBookingData;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String email;
	private String authorization_sys;
	private Reservation reservation;
	
	private String payment_method;
	//Visa
	private String name;
	private String cardNumber;
	private String cvv;
	//Paypal
	private String username;
	private String password;
	
	private List<Reservation> res = new ArrayList<>();

	public User(String email, String authorization_sys, String[] payment) {
		this.email = email;
		this.authorization_sys = authorization_sys;
		this.payment_method = payment[0];
		if(payment_method.equals("Visa")) {
			name = payment[1];
			cardNumber = payment[2];
			cvv = payment[3];
		}else {
			username = payment[1];
			password = payment[2];
		}
		
	}
	
	public void makeReservation(Reservation reservation) {
		res.add(reservation);
	}
	
	public void cancelReservation(Reservation reservation) {
		res.remove(reservation);
	}
	
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
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
	
	
}
