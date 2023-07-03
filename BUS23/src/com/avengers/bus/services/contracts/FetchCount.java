package com.avengers.bus.services.contracts;

public interface FetchCount {
	// This will return all the bus count
	public int getBusCount();

	// This will return all the services count
	public int getServiceCount();

	// This will get total collection
	public int getCollection();

	// This will return all the user count
	public int getUserCount();

	// This will return no of routes available
	public int getRouteCount();

	// This will return the trips available
	public int getTripCount();

	// This will return all the past ticket collection
	int getPastTicketCollection();

	// This will return all the future ticket collection
	int getFutureTicketCollection();

}
