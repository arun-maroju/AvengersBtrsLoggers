package com.avengers.bus.dao.contracts;

import java.util.List;

import com.avengers.bus.models.entityModels.UserPassengers;
import com.avengers.bus.models.entityModels.UserPassengersId;

public interface UserPassengersDAO {
	// all the user passengers for one particular user
	public List<UserPassengers> getAllUserPassengers(int userId);

	// user can update the existing passenger details
	public void updateUserPassengers(UserPassengersId userpass);

	// user can delete the existing passenger
	public void deleteUserPassengers(UserPassengersId userpass);

	// user can add another passenger
	public void persist(UserPassengers userpass);
}
