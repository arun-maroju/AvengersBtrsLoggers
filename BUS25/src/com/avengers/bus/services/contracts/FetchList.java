package com.avengers.bus.services.contracts;

public interface FetchList {
	// Retruns services list data
	public String getServiceList(int page, int records);

	// Returns route list data
	public String getRouteList();

	// returns bus list data
	public String getBusList();

	// returns ticket list data
	public String getTicketList();

	// returns ticket passengers list data
	public String getTicketPassengerList(String service_id);

}
