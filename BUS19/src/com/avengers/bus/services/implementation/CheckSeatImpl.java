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
import com.razorpay.RazorpayException;

@Component
public class CheckSeatImpl implements CheckSeat {
	private static final Logger logger = LoggerFactory.getLogger(CheckSeatImpl.class);

	@Autowired
	private TicketManagementDAO ticketManagementDAO;

	@Autowired
	private CancelTicketService cancelTicketService;

	@Transactional
	@Override
	public boolean checkAvailability(int service_no, int[] seat) {
		int count = ticketManagementDAO.getBookedSeatsCount(service_no, seat);
		logger.info("Checking Seat Availability:");

		if (count > 0) {
			logger.info("Seat Availability count:{}", count);
			System.out.println("in if block");
			return false;
		} else
			logger.info("Not Booked yet");

		return true;
	}

	@Override
	public String checkpersistability(Ticket ticket) {
		List<Passengers> passengers = ticket.getPassengers();
		List<Integer> seats = new ArrayList<>();
		for (Passengers p : passengers) {
			seats.add(p.getSeat_id());
		}

		int[] seat = seats.stream().mapToInt(Integer::intValue).toArray();

		boolean seatAvailable = checkAvailability(ticket.getService_no(), seat);

		if (seatAvailable = false) {
			String json = null;
			String refund_id = null;
			try {
				refund_id = cancelTicketService.refund(ticket.getTicketNo(), ticket.getPayment_id(),
						ticket.getTotalFare());

				logger.info("Fetching Refund id of Cancelled Ticket", refund_id);

				return refund_id;
			} catch (RazorpayException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				logger.info("Refund Failed");

				return "Refund Failed";
			}
		}
		return "persistable";
	}

}
