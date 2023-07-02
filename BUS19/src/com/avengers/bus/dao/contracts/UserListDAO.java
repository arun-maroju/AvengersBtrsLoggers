package com.avengers.bus.dao.contracts;

import java.util.List;

import com.avengers.bus.models.entityModels.User;

public interface UserListDAO {
	// It will list all the users
	public List<User> UserList(int userId);

	// It will update one particular user details
	public void updateUser(User user);

}
