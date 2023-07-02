package com.avengers.bus.services.contracts;

import com.avengers.bus.models.entityModels.User;

public interface FetchUser {
	public String getUserList(int userId);

	public void add(User user);

}
