package easyBookingData;

import java.util.ArrayList;
import java.util.List;

import dto.FlightDTO;

public class User {

	
	private String email;
	private String authorization_sys;
	
	private String payment_method;
	private String[] payData;
	
	private List<FlightDTO> res = new ArrayList<>();

	public User(String email, String authorization_sys, String[] payment) {
		this.email = email;
		this.authorization_sys = authorization_sys;
		this.payment_method = payment[0];
		payData = payment;
		
	}
	
	public void makeReservation(FlightDTO reservation) {
		res.add(reservation);
	}
	
	public void cancelReservation(FlightDTO f) {
		this.res.remove(f);
	}
	
	public List<FlightDTO> getReservation() {
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
		return payData;
	}
	
}
