package com.avengers.bus.services.contracts;

import com.avengers.bus.models.viewModels.UserCounts;

public interface FetchUserCounts {
	// return the number of bookings by that user
	public int getUserBookedCount(int userId);

	// returns no of times user travelled
	public int getUserTravelCount(int userId);

	// returns no of future boookings
	public int getUserFutureTravelCount(int userId);

	// retrun the wallet amount
	public double getUserwallet(int userId);

	// return the user name
	public String getUsername(int userId);

	// will return user imp coounts
	public UserCounts getUserCounts(int userId);

}
