package com.avengers.bus.services.contracts;

import java.util.List;

import com.avengers.bus.models.entityModels.UserPassengers;

public interface UserPassengersService {

	public List<UserPassengers> getAllUserPassengers(int userId);

}
