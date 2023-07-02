package com.avengers.bus.dao.contracts;

import java.util.List;

import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.inputModels.UserPasswordChange;

public interface UserDAO {
	// find one user using his email
	public User findByEmail(String email);

	// it will list all the users
	public List<User> getAllUsers();

	// it will persist a user
	void persistUser(User user);

	// It will change the user password
	public void changePassword(UserPasswordChange userPasswordChange);

}
