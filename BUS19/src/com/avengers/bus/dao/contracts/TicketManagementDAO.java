package com.avengers.bus.dao.contracts;

import com.avengers.bus.models.entityModels.Ticket;

public interface TicketManagementDAO {

	// saves the ticket
	public void saveTicket(Ticket ticket);

	// cancel the ticket
	public boolean cancelTicket(String bookingId);

	// it will fetch the number of seats for one service
	public int getBookedSeatsCount(int service_no, int seat[]);

}
