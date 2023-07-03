package com.avengers.bus.services.contracts;

import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.inputModels.UserPasswordChange;

public interface UserService {
	// This will verity user login
	public boolean verifylogin(String email, String password);

	// get user by his email
	User getUser(String email);

	// add a new user
	public void addUser(User user);

	// changes his password
	public void change_Password(UserPasswordChange userPasswordChange);

}
