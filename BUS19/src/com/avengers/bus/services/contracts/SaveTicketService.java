package com.avengers.bus.services.contracts;

import com.avengers.bus.models.dtoModels.Ticket;

public interface SaveTicketService {

	public void saveTheTicket(Ticket ticket, int userId);
}
