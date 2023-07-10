package com.avengers.bus.services.contracts;

import com.avengers.bus.models.entityModels.UserPassengers;

public interface FetchUserPassengers {

	// this will return all the passengers data of a user
	public String getPassengersList(int userId);

	// This will edit the passengers data
	public void addeditedpassengers(UserPassengers userpass);

	// This will delete the passengers
	public void deleteUserpassengers(UserPassengers userpass);

	// This will add new passengers for suggestions
	public void addUserpassengers(UserPassengers userpass);

}
