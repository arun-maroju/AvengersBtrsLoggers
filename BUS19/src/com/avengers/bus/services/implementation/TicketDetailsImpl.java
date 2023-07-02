package com.avengers.bus.services.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.dtoModels.Ticket;
import com.avengers.bus.models.inputModels.PassengerList;
import com.avengers.bus.models.inputModels.Passengers;
import com.avengers.bus.services.contracts.TicketDetails;

@Component
public class TicketDetailsImpl implements TicketDetails {

	private static final Logger logger = LoggerFactory.getLogger(TicketDetailsImpl.class);

	@Override
	public Ticket generateTicketDetails(PassengerList passengers, BusSearchListDto bus) {
		logger.info("Generating ticket details for the passengers.");

		// Extract passenger information from the PassengerList object
		String[] passengerIds = passengers.getPassenger_id();
		int[] passengerSeatNos = passengers.getSeat_number();
		String[] passengerNames = passengers.getPassenger_name();
		int[] passengerAges = passengers.getPassenger_age();
		String[] passengerGenders = passengers.getPassenger_gender();

		// Log the passenger information
		logger.info("Total passengers: {}", passengerIds.length);
		logger.info("Total passenger seat numbers: {}", passengerSeatNos.length);
		logger.info("Total passenger names: {}", passengerNames.length);
		logger.info("Total passenger ages: {}", passengerAges.length);
		logger.info("Total passenger genders: {}", passengerGenders.length);

		for (int i = 0; i < passengerIds.length; i++) {
			logger.info("Passenger ID: {}", passengerIds[i]);
			logger.info("Seat ID: {}", passengerSeatNos[i]);
			logger.info("Passenger Name: {}", passengerNames[i]);
			logger.info("Passenger Age: {}", passengerAges[i]);
			logger.info("Passenger Gender: {}", passengerGenders[i]);
			logger.info("-------------------------");
		}

		// Create a list to store passenger details
		List<Passengers> passengersList = new ArrayList<Passengers>();
		double totalFare = 0;

		// Loop through passenger information and add it to the list
		for (int i = 0; i < passengerIds.length; i++) {
			Passengers p = new Passengers();
			p.setPassenger_id(passengerIds[i]);
			p.setSeat_id(passengerSeatNos[i]);
			p.setPassenger_name(passengerNames[i]);
			p.setPassenger_age(passengerAges[i]);
			p.setPassenger_gender(passengerGenders[i]);
			// Determine seat fare based on seat number
			if (passengerSeatNos[i] <= 16)
				p.setSeat_fare(bus.getSeat_fare());
			else
				p.setSeat_fare(bus.getBerth_fare());
			passengersList.add(p);
			totalFare += p.getSeat_fare();
			logger.info("-------------------------");
		}

		// Log the passenger details
		for (Passengers p : passengersList) {
			logger.info("Passenger Details: {}", p);
		}

		// Create a new ticket object and set the details
		Ticket ticket = new Ticket();
		ticket.setTo(bus.getDestination());
		ticket.setFrom(bus.getSource());
		ticket.setBus_type(bus.getBsty_title());
		ticket.setJourney_date(bus.getTrip_date());
		ticket.setDeparture_time(bus.getDepature());
		ticket.setArrival_time(bus.getArrival());
		ticket.setService_no(bus.getService_id());
		ticket.setTrip_no(bus.getTrip_id());
		ticket.setPassengers(passengersList);
		ticket.setTotalFare(totalFare);

		// Generate a ticket number based on the current date and bus details
		LocalDate currentDate = LocalDate.now();
		int year = currentDate.getYear();
		int month = currentDate.getMonthValue();
		int day = currentDate.getDayOfMonth();
		String ticketNo = bus.getService_id() + "" + bus.getTrip_id() + "" + year + "" + month + "" + day + "";
		ticket.setTicketNo(ticketNo);
		ticket.setNumberOfPassengers(passengersList.size());

		return ticket;
	}
}
