package dto;

import java.util.*;

import easyBookingData.Flight;

public class FlightAssembler {
	
	public List<FlightDTO> assemble(List<Flight> flights) {
		List<FlightDTO> flightsDTO = new ArrayList<>();

		for (Flight f : flights) {
			System.out.println(f.getFlight_number()+"#"+f.getAirline_code()+"#"+f.getDepartureTime()+"#"+f.getArrivalTime()+"#"+f.getOrigin()+"#"+f.getDestiny()+"#"+f.getSeats()+"#"+f.getDate());
			
			flightsDTO.add(new FlightDTO(f.getFlight_number(), f.getAirline_code(), f.getDepartureTime(), f.getArrivalTime(), f.getOrigin(), f.getDestiny(), f.getSeats(), f.getDate()));
		}
		
		return flightsDTO;
	}

}
