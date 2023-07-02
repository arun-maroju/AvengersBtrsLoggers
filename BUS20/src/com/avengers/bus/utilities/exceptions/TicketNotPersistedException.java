package com.avengers.bus.utilities.exceptions;

import com.avengers.bus.models.entityModels.Ticket;

public class TicketNotPersistedException extends Exception {

	private Ticket ticket;

	public TicketNotPersistedException(String message, Ticket ticket) {
		super(message);
		this.ticket = ticket;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}