package com.avengers.bus.services.implementation;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.TicketManagementDAO;
import com.avengers.bus.models.dtoModels.Ticket;
import com.avengers.bus.models.inputModels.Passengers;
import com.avengers.bus.services.contracts.SaveTicketService;
import com.avengers.bus.utilities.exceptions.TicketNotPersistedException;

@Component
public class SaveTicketServiceImpl implements SaveTicketService {
	private static final Logger logger = LoggerFactory.getLogger(SaveTicketServiceImpl.class);

	@Autowired
	private TicketManagementDAO ticketManagementDAO;
	// This will persist the ticket into the db

	@Override
	public void saveTheTicket(Ticket ticket, int userId) throws TicketNotPersistedException {

		logger.info("Saving Ticket for User with ID: {}", userId);

		java.util.Date currentDate = new java.util.Date();

		// Convert java.util.Date to java.sql.Date
		Date sqlDate = new Date(currentDate.getTime());

		java.util.Date currentTime = new java.util.Date();
		Time sqlTime = new Time(currentTime.getTime());

		com.avengers.bus.models.entityModels.Ticket ticketToSave = new com.avengers.bus.models.entityModels.Ticket();
		ticketToSave.setBooking_date(sqlDate);
		ticketToSave.setBooking_id(ticket.getTicketNo());
		ticketToSave.setBooking_time(sqlTime);
		ticketToSave.setNo_of_seats_booked(ticket.getNumberOfPassengers());
		ticketToSave.setPayment_id(ticket.getPayment_id());
		ticketToSave.setPayment_mode("Online");
		ticketToSave.setService_id(ticket.getService_no());
		ticketToSave.setStatus("confirmed");
		ticketToSave.setTotal_fare(ticket.getTotalFare());
		ticketToSave.setTrip_id(ticket.getTrip_no());
		ticketToSave.setSource(ticket.getFrom());
		ticketToSave.setDestination(ticket.getTo());
		ticketToSave.setTravel_date(ticket.getJourney_date());
		ticketToSave.setOrder_id(ticket.getOrder_id());
		ticketToSave.setDeparture(ticket.getDeparture_time());
		ticketToSave.setUser_id(userId);

		List<Passengers> p1 = ticket.getPassengers();

		Comparator<Passengers> genderComparator = new Comparator<Passengers>() {
			@Override
			public int compare(Passengers p1, Passengers p2) {
				List<String> genderOrder = List.of("Male", "Other", "Female");
				int index1 = genderOrder.indexOf(p1.getPassenger_gender());
				int index2 = genderOrder.indexOf(p2.getPassenger_gender());
				return Integer.compare(index1, index2);
			}
		};

		Collections.sort(p1, genderComparator);

		List<com.avengers.bus.models.entityModels.TicketPassenger> ticketPassengers = new ArrayList<com.avengers.bus.models.entityModels.TicketPassenger>();
		int count = 1;
		for (Passengers p : p1) {
			com.avengers.bus.models.entityModels.TicketPassenger ticPas = new com.avengers.bus.models.entityModels.TicketPassenger();
			ticPas.setAge(p.getPassenger_age());
			ticPas.setBooking_id(ticket.getTicketNo());
			ticPas.setGender(p.getPassenger_gender());
			ticPas.setP_fare(p.getSeat_fare());
			ticPas.setPassenger_index(count);
			ticPas.setPassenger_name(p.getPassenger_name());
			ticPas.setSeat_no(p.getSeat_id());
			// ticPas.setTicket(ticketToSave); // Set the ticket for the passenger
			ticketPassengers.add(ticPas);
			count++;
		}

		ticketToSave.setPassengerList(ticketPassengers);

		// ticketToSave.setTicketPassengers(ticketPassengers);

		logger.info("Saving the ticket to the database");
		ticketManagementDAO.saveTicket(ticketToSave);

	}

}