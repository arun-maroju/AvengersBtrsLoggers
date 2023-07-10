package com.avengers.bus.services.contracts;

import java.util.List;

import com.avengers.bus.models.entityModels.UserPassengers;

public interface UserPassengersService {
	// This will return all teh userPassengers of one user
	public List<UserPassengers> getAllUserPassengers(int userId);

}
