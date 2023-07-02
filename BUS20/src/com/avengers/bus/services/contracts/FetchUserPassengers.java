package com.avengers.bus.services.contracts;

import com.avengers.bus.models.entityModels.UserPassengers;

public interface FetchUserPassengers {
	public String getPassengersList(int userId);

	public void addeditedpassengers(UserPassengers userpass);

	public void deleteUserpassengers(UserPassengers userpass);

	public void addUserpassengers(UserPassengers userpass);

}
