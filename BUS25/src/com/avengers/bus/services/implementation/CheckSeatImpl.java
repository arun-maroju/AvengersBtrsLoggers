package com.avengers.bus.services.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.TicketManagementDAO;
import com.avengers.bus.models.dtoModels.Ticket;
import com.avengers.bus.models.inputModels.Passengers;
import com.avengers.bus.services.contracts.CancelTicketService;
import com.avengers.bus.services.contracts.CheckSeat;

@Component
public class CheckSeatImpl implements CheckSeat {

	private static final Logger logger = LoggerFactory.getLogger(CheckSeatImpl.class);

	@Autowired
	private TicketManagementDAO ticketManagementDAO;

	@Autowired
	private CancelTicketService cancelTicketService;

	// It will check whether the seats are available in the given array of seats
	@Transactional
	@Override
	public boolean checkAvailability(int service_no, int[] seat) {
		int count = ticketManagementDAO.getBookedSeatsCount(service_no, seat);
		if (count > 0) {
			logger.info("Seats are not available.");
			return false;
		} else {
			logger.info("Seats are available.");
			return true;
		}
	}

	// It will check whether the ticket is persistable or not based on seats check
	@Override
	public boolean checkpersistability(Ticket ticket) {
		List<Passengers> passengers = ticket.getPassengers();
		List<Integer> seats = new ArrayList<>();
		for (Passengers p : passengers) {
			seats.add(p.getSeat_id());
		}

		int[] seat = seats.stream().mapToInt(Integer::intValue).toArray();

		boolean seatAvailable = checkAvailability(ticket.getService_no(), seat);

		if (seatAvailable) {
			logger.info("Ticket is persistable. Seats are available.");
		} else {
			logger.info("Ticket is not persistable. Seats are not available.");
		}

		return seatAvailable;
	}
}
