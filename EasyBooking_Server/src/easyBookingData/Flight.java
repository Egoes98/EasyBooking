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
public class Flight {

	@PrimaryKey
	int flight_number;
	int airline_code;
	String departureTime;
	String arrivalTime;
	int seats;
	String origin;
	String destiny;
	String date;
	
	@Persistent(defaultFetchGroup="true", mappedBy="flight", dependentElement = "true")
    @Join
	private List<Reservation> flightReservations = new ArrayList<>();
	
	public Flight(int flight_number, int airline_code, String departureTime, String arrivalTime, String origin, String destiny, int seats, String date) {
		this.flight_number = flight_number;
		this.airline_code = airline_code;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seats = seats;
		this.origin = origin;
		this.destiny = destiny;
		this.seats = seats;
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public int getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}

	public int getAirline_code() {
		return airline_code;
	}

	public void setAirline_code(int airline_code) {
		this.airline_code = airline_code;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}
