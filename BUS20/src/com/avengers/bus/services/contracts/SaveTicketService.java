package com.avengers.bus.services.contracts;

import com.avengers.bus.models.dtoModels.Ticket;
import com.avengers.bus.utilities.exceptions.TicketNotPersistedException;

public interface SaveTicketService {

	public void saveTheTicket(Ticket ticket, int userId) throws TicketNotPersistedException;
}
