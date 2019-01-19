package dto;

import java.io.Serializable;

import easyBookingData.Flight;
import easyBookingData.User;

public class ReservationDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return date + " " + price + " " + seats;
	}
		
	private int id;
	private String date;
	private int price;
	private int seats;
	private User user;
	private Flight flight;
		
	public ReservationDTO(String date, int price, int seats) {
		super();
		this.date = date;
		this.price = price;
		this.seats = seats;
	}
		
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
}
