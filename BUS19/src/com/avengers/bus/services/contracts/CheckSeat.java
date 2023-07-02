package com.avengers.bus.services.contracts;

import com.avengers.bus.models.dtoModels.Ticket;

public interface CheckSeat {
	boolean checkAvailability(int service_no, int seat[]);

	String checkpersistability(Ticket ticket);
}
