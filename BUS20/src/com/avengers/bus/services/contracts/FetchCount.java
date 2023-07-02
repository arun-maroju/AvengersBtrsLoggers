package com.avengers.bus.services.contracts;

public interface FetchCount {

	public int getBusCount();

	public int getServiceCount();

	public int getCollection();

	public int getUserCount();

	public int getRouteCount();

	public int getTripCount();

	int getPastTicketCollection();

	int getFutureTicketCollection();

}
