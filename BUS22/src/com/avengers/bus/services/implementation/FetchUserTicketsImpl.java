package com.avengers.bus.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.UserTicketsDAO;
import com.avengers.bus.models.dtoModels.UserTickets;
import com.avengers.bus.models.entityModels.Ticket;
import com.avengers.bus.models.entityModels.TicketPassenger;
import com.avengers.bus.models.viewModels.Passenger;
import com.avengers.bus.services.contracts.FetchUserTickets;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FetchUserTicketsImpl implements FetchUserTickets {

	private static final Logger LOGGER = LoggerFactory.getLogger(FetchUserTicketsImpl.class);

	@Autowired
	private UserTicketsDAO userTicketsDAO;

	// Fetch all tickets for a given user
	public String getticketList(int userId) {
		LOGGER.info("Fetching all tickets for user with ID: {}", userId);

		List<Ticket> tickets = userTicketsDAO.ticketList(userId);
		LOGGER.debug("Tickets: {}", tickets);

		List<UserTickets> ut = new ArrayList<>();
		for (Ticket t : tickets) {
			List<Passenger> outPasList = new ArrayList<>();
			for (TicketPassenger tp : t.getPassengerList()) {
				Passenger pass = new Passenger(tp.getBooking_id(), tp.getPassenger_name(), tp.getGender(), tp.getAge(),
						tp.getSeat_no(), tp.getP_fare());
				outPasList.add(pass);
			}

			UserTickets ut1 = new UserTickets(t.getBooking_id(), t.getPayment_id(), t.getUser_id(), t.getBooking_date(),
					t.getBooking_time(), t.getTrip_id(), t.getService_id(), t.getPayment_mode(), t.getTotal_fare(),
					t.getStatus(), t.getNo_of_seats_booked(), t.getTravel_date(), t.getSource(), t.getDestination(),
					t.getDeparture(), outPasList);
			ut.add(ut1);
		}

		ObjectMapper om = new ObjectMapper();
		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(ut);
			LOGGER.debug("JSON response: {}", json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error converting ticket list to JSON: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// Fetch past tickets for a given user
	@Override
	public String getPastTicketList(int userId) {
		LOGGER.info("Fetching past tickets for user with ID: {}", userId);

		List<Ticket> tickets = userTicketsDAO.pastTicketList(userId);

		List<UserTickets> ut = new ArrayList<>();
		for (Ticket t : tickets) {
			List<Passenger> outPasList = new ArrayList<>();
			for (TicketPassenger tp : t.getPassengerList()) {
				Passenger pass = new Passenger(tp.getBooking_id(), tp.getPassenger_name(), tp.getGender(), tp.getAge(),
						tp.getSeat_no(), tp.getP_fare());
				outPasList.add(pass);
			}

			UserTickets ut1 = new UserTickets(t.getBooking_id(), t.getPayment_id(), t.getUser_id(), t.getBooking_date(),
					t.getBooking_time(), t.getTrip_id(), t.getService_id(), t.getPayment_mode(), t.getTotal_fare(),
					t.getStatus(), t.getNo_of_seats_booked(), t.getTravel_date(), t.getSource(), t.getDestination(),
					t.getDeparture(), outPasList);
			ut.add(ut1);
		}

		ObjectMapper om = new ObjectMapper();
		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(ut);
			LOGGER.debug("JSON response: {}", json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error converting past ticket list to JSON: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// Fetch future tickets for a given user
	@Override
	public String getFutureTicketList(int userId) {
		LOGGER.info("Fetching future tickets for user with ID: {}", userId);

		List<Ticket> tickets = userTicketsDAO.futureTicketList(userId);

		List<UserTickets> ut = new ArrayList<>();
		for (Ticket t : tickets) {
			List<Passenger> outPasList = new ArrayList<>();
			for (TicketPassenger tp : t.getPassengerList()) {
				Passenger pass = new Passenger(tp.getBooking_id(), tp.getPassenger_name(), tp.getGender(), tp.getAge(),
						tp.getSeat_no(), tp.getP_fare());
				outPasList.add(pass);
			}

			UserTickets ut1 = new UserTickets(t.getBooking_id(), t.getPayment_id(), t.getUser_id(), t.getBooking_date(),
					t.getBooking_time(), t.getTrip_id(), t.getService_id(), t.getPayment_mode(), t.getTotal_fare(),
					t.getStatus(), t.getNo_of_seats_booked(), t.getTravel_date(), t.getSource(), t.getDestination(),
					t.getDeparture(), outPasList);
			ut.add(ut1);
		}

		ObjectMapper om = new ObjectMapper();
		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(ut);
			LOGGER.debug("JSON response: {}", json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error converting future ticket list to JSON: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// Fetch canceled tickets for a given user
	@Override
	public String getCancelTicketList(int userId) {
		LOGGER.info("Fetching canceled tickets for user with ID: {}", userId);

		List<Ticket> tickets = userTicketsDAO.cancelTicketList(userId);

		List<UserTickets> ut = new ArrayList<>();
		for (Ticket t : tickets) {
			List<Passenger> outPasList = new ArrayList<>();
			for (TicketPassenger tp : t.getPassengerList()) {
				Passenger pass = new Passenger(tp.getBooking_id(), tp.getPassenger_name(), tp.getGender(), tp.getAge(),
						tp.getSeat_no(), tp.getP_fare());
				outPasList.add(pass);
			}

			UserTickets ut1 = new UserTickets(t.getBooking_id(), t.getPayment_id(), t.getUser_id(), t.getBooking_date(),
					t.getBooking_time(), t.getTrip_id(), t.getService_id(), t.getPayment_mode(), t.getTotal_fare(),
					t.getStatus(), t.getNo_of_seats_booked(), t.getTravel_date(), t.getSource(), t.getDestination(),
					t.getDeparture(), outPasList);
			ut.add(ut1);
		}

		ObjectMapper om = new ObjectMapper();
		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(ut);
			LOGGER.debug("JSON response: {}", json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error converting canceled ticket list to JSON: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// Fetch rated tickets for a given user
	@Override
	public String getratingTicketList(int userId) {
		LOGGER.info("Fetching rated tickets for user with ID: {}", userId);

		List<Ticket> tickets = userTicketsDAO.ratingTicketList(userId);

		List<UserTickets> ut = new ArrayList<>();
		for (Ticket t : tickets) {
			List<Passenger> outPasList = new ArrayList<>();
			for (TicketPassenger tp : t.getPassengerList()) {
				Passenger pass = new Passenger(tp.getBooking_id(), tp.getPassenger_name(), tp.getGender(), tp.getAge(),
						tp.getSeat_no(), tp.getP_fare());
				outPasList.add(pass);
			}

			UserTickets ut1 = new UserTickets(t.getBooking_id(), t.getPayment_id(), t.getUser_id(), t.getBooking_date(),
					t.getBooking_time(), t.getTrip_id(), t.getService_id(), t.getPayment_mode(), t.getTotal_fare(),
					t.getStatus(), t.getNo_of_seats_booked(), t.getTravel_date(), t.getSource(), t.getDestination(),
					t.getDeparture(), outPasList);
			ut.add(ut1);
		}

		ObjectMapper om = new ObjectMapper();
		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(ut);
			LOGGER.debug("JSON response: {}", json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error converting rated ticket list to JSON: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// Update rating for a specific ticket
	@Override
	public void updateRatingTicketList(int userId, Ticket ratingSubmission) {
		LOGGER.info("Updating rating for ticket with ID: {} for user with ID: {}", ratingSubmission.getBooking_id(),
				userId);

		// TODO: Implement the logic to update the rating for the specified ticket
		userTicketsDAO.updateRatingTicketList(userId, ratingSubmission);
	}
}
