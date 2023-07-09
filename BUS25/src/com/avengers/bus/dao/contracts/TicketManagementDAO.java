package com.avengers.bus.dao.contracts;

import com.avengers.bus.models.entityModels.Ticket;
import com.avengers.bus.utilities.exceptions.TicketNotPersistedException;

public interface TicketManagementDAO {

	// saves the ticket
	public void saveTicket(Ticket ticket) throws TicketNotPersistedException;

	// cancel the ticket
	public boolean cancelTicket(String bookingId, String refund_id);

	// it will fetch the number of seats for one service
	public int getBookedSeatsCount(int service_no, int seat[]);

}
