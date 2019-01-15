package easyBookingData;

import java.util.ArrayList;
import java.util.List;

public class User {

	
	private String email;
	private String authorization_sys;
	private List<Reservation> reservation;
	
	private String payment_method;
	private String[] payData;
	
	private List<Reservation> res = new ArrayList<>();

	public User(String email, String authorization_sys, String[] payment) {
		this.email = email;
		this.authorization_sys = authorization_sys;
		this.payment_method = payment[0];
		payData = payment;
		
	}
	
	public void makeReservation(Reservation reservation) {
		res.add(reservation);
	}
	
	public void cancelReservation(Reservation reservation) {
		res.remove(reservation);
	}
	
	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
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
	public String[] getPData() {
		return payData;
	}
	
}
