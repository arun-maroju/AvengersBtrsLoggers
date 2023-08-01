package com.avengers.bus.dao.contracts;

public interface CountsDAO {
	// return no of buses available
	public int busCount();

	// return no of services available
	public int serviceCount();

	// returns no of users available
	public int userCount();

	// returns total collection of all payments
	public int totalPayments();

	// retruns all the routs count
	public int routeCount();

	// returns all the trip counts
	public int tripCount();

	// returns all the past services colletions
	public int pastTicketCollection();

	// returns all the future services collection
	public int futureTicketCollection();
}
