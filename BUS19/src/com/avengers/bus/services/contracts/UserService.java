package com.avengers.bus.services.contracts;

import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.inputModels.UserPasswordChange;

public interface UserService {

	public boolean verifylogin(String email, String password);

	User getUser(String email);
	
	public void addUser(User user);
	
	public void change_Password(UserPasswordChange userPasswordChange);


}
