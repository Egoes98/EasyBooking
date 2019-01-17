package easyBookingData;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Reservation {
	
	@Override
	public String toString() {
		return date + " " + price + " " + seats;
	}
	@PrimaryKey
	private int id;
	
	private String date;
	private int price;
	private int seats;
	private User user;
	private Flight flight;
	
	public Reservation(String date, int price, int seats) {
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
