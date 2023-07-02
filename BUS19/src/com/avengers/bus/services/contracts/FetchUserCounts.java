package com.avengers.bus.services.contracts;

import com.avengers.bus.models.viewModels.UserCounts;

public interface FetchUserCounts {

	public int getUserBookedCount(int userId);

	public int getUserTravelCount(int userId);

	public int getUserFutureTravelCount(int userId);

	public double getUserwallet(int userId);

	public String getUsername(int userId);

	public UserCounts getUserCounts(int userId);

}
