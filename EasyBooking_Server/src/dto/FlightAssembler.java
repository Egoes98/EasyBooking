package dto;

import java.util.*;

import easyBookingData.Flight;
import easyBookingData.Reservation;

public class FlightAssembler {
	
	public List<FlightDTO> assemble(List<ServerFlightDTO> flights) {
		List<FlightDTO> flightsDTO = new ArrayList<>();
		if(flights == null) {
			return null;
		}
		for (ServerFlightDTO f : flights) {
			System.out.println(f.getFlight_number()+"#"+f.getAirline_code()+"#"+f.getDepartureTime()+"#"+f.getArrivalTime()+"#"+f.getOrigin()+"#"+f.getDestiny()+"#"+f.getSeats()+"#"+f.getDate());
			flightsDTO.add(new FlightDTO(f.getFlight_number(), f.getAirline_code(), f.getDepartureTime(), f.getArrivalTime(), f.getOrigin(), f.getDestiny(), f.getSeats(), f.getDate()));
		}
		
		return flightsDTO;
	}
	
	public List<ReservationDTO> assembleR(List<Reservation> r){
		List<ReservationDTO> rDTO = new ArrayList<>();
		if(r == null) {
			return null;
		}
		
		for(Reservation res : r) {
			System.out.println(res.toString());
			rDTO.add(new ReservationDTO(res.getDate(), res.getPrice(), res.getSeats()));
		}
		return rDTO;
	}

}
