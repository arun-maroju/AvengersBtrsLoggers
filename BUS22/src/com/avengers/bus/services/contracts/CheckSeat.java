package com.avengers.bus.services.contracts;

import com.avengers.bus.models.dtoModels.Ticket;

public interface CheckSeat {
	// It will check whether the seats are available in the give array of seats
	public boolean checkAvailability(int service_no, int seat[]);

	// It will check whether the ticket is persitable or not based on seats check
	public boolean checkpersistability(Ticket ticket);
}
