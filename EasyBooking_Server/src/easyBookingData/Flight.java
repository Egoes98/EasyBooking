package easyBookingData;

public class Flight {
	
	int flight_number;
	int airline_code;
	String departureTime;
	String arrivalTime;
	int seats;
	String origin;
	String destiny;
	String date;
	
	public Flight(int flight_number, int airline_code, String departureTime, String arrivalTime, String origin, String destiny, int seats, String date) {
		this.flight_number = flight_number;
		this.airline_code = airline_code;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seats = seats;
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
