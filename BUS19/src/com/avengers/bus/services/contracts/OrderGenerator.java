package com.avengers.bus.services.contracts;

public interface OrderGenerator {
	public String generateOrder(String ticketNumber, String amount);

	public String generateTicketNo(String ticketNumber);
}
