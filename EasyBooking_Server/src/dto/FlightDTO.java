package dto;

import java.io.Serializable;

public class FlightDTO implements Serializable{

	int flight_number;
	int airline_code;
	String departureTime;
	String arrivalTime;
	int seats;
	
	public FlightDTO(int flight_number, int airline_code, String departureTime, String arrivalTime, int seats) {
		this.flight_number = flight_number;
		this.airline_code = airline_code;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seats = seats;
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
