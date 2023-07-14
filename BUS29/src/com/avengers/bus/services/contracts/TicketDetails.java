package com.avengers.bus.services.contracts;

import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.inputModels.PassengerList;

public interface TicketDetails {
	// This will generate all the ticketDetails
	public com.avengers.bus.models.dtoModels.Ticket generateTicketDetails(PassengerList passengers,
			BusSearchListDto bus);

}
