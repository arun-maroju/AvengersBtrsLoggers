package com.avengers.bus.services.contracts;

import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.inputModels.PassengerList;

public interface TicketDetails {

	public com.avengers.bus.models.dtoModels.Ticket generateTicketDetails(PassengerList passengers, BusSearchListDto bus);

}
