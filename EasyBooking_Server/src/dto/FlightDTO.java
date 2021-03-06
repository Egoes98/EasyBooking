package dto;

import java.io.Serializable;

public class FlightDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return flight_number + " " + departureTime + " " + arrivalTime + " " + origin + " " + destiny + " " + seats + " " + date;
	}

	int flight_number;
	int airline_code;
	String departureTime;
	String arrivalTime;
	String origin;
	String destiny;
	int seats;
	String date;
	
	public FlightDTO(int flight_number, int airline_code, String departureTime, String arrivalTime, String origin, String destiny, int seats, String date) {
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
	
	public String getOrigin() {
		return this.origin;
	}
	
	public String getDestiny() {
		return this.destiny;
	}
}
