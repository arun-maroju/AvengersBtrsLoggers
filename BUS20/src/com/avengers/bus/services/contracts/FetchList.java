package com.avengers.bus.services.contracts;

public interface FetchList {

	public String getServiceList();

	public String getRouteList();

	public String getBusList();

	public String getTicketList();

	public String getTicketPassengerList(String service_id);

}
