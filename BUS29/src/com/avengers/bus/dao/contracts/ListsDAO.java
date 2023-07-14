package com.avengers.bus.dao.contracts;

import java.util.List;

import com.avengers.bus.models.dtoModels.ServicePassenger;
import com.avengers.bus.models.entityModels.Bus;
import com.avengers.bus.models.entityModels.Routes;
import com.avengers.bus.models.entityModels.Services;
import com.avengers.bus.models.entityModels.Ticket;

public interface ListsDAO {
	// list all the services list
	public List<Services> serviceList(int start, int end);

	// list all the routes list
	public List<Routes> routeList();

	// lists all the busList available
	public List<Bus> busList();

	// lists all the tikets booked
	public List<Ticket> ticketList();

	// lists all the passengers travelling in one particular service..
	public List<ServicePassenger> servicePassengerList(int service_id);

	public List<Services> allServiceList();

	public List<Ticket> refundList();

}
