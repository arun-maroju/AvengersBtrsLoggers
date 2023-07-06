package com.avengers.bus.services.contracts;

public interface OrderGenerator {
	// This will generate an order based on ticket no and amount
	public String generateOrder(String ticketNumber, String amount);

	// This will generate a ticket no
	public String generateTicketNo(String ticketNumber);
}
