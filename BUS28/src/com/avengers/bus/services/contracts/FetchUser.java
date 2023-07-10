package com.avengers.bus.services.contracts;

import com.avengers.bus.models.entityModels.User;

public interface FetchUser {
	// will return user data
	public String getUserList(int userId);

	// This will add a new user
	public void add(User user);

}
