package com.avengers.bus.dao.contracts;

public interface UserCountsDAO {
	// no of tickets booked by one user
	public int bookedCount(int userId);

	// no of times he has travelled
	public int travelCount(int userId);

	// get wallet amount
	public double getWallet(int userId);

	// gets name of the user
	public String getName(int userId);

	// retrieves the future travel count
	int userFutureTravelCount(int userId);

}
