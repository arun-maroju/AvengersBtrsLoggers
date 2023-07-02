package com.avengers.bus.services.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.TicketManagementDAO;
import com.avengers.bus.models.dtoModels.Ticket;
import com.avengers.bus.models.inputModels.Passengers;
import com.avengers.bus.services.contracts.CancelTicketService;
import com.avengers.bus.services.contracts.CheckSeat;

@Component
public class CheckSeatImpl implements CheckSeat {

	@Autowired
	private TicketManagementDAO ticketManagementDAO;

	@Autowired
	private CancelTicketService cancelTicketService;

	// It will check whether the seats are available in the give array of seats
	@Transactional
	@Override
	public boolean checkAvailability(int service_no, int[] seat) {
		int count = ticketManagementDAO.getBookedSeatsCount(service_no, seat);
		if (count > 0) {
			System.out.println("in if block");
			return false;
		} else
			return true;
	}

	// It will check whether the ticket is persitable or not based on seats check
	@Override
	public boolean checkpersistability(Ticket ticket) {
		List<Passengers> passengers = ticket.getPassengers();
		List<Integer> seats = new ArrayList<>();
		for (Passengers p : passengers) {
			seats.add(p.getSeat_id());
		}

		int[] seat = seats.stream().mapToInt(Integer::intValue).toArray();

		boolean seatAvailable = checkAvailability(ticket.getService_no(), seat);

		return seatAvailable;
	}

}