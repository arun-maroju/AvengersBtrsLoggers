package com.avengers.bus.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.UserDAO;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.inputModels.UserPasswordChange;
import com.avengers.bus.security.PasswordEncryptor;
import com.avengers.bus.services.contracts.UserService;

@Component
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public boolean verifylogin(String email, String password) {
		logger.info("Verifying login for user with email: {}", email);
		User user = userDAO.findByEmail(email);
		if (user != null && user.getPassword().equals(PasswordEncryptor.encryptPassword(password))) {
			logger.info("Login verified for user with email: {}", email);
			return true;
		}
		logger.info("Login verification failed for user with email: {}", email);
		return false;
	}

	@Override
	public User getUser(String email) {
		logger.info("Fetching user with email: {}", email);
		User user = userDAO.findByEmail(email);
		logger.info("User found with email: {}", email);
		return user;
	}

	@Transactional
	public List<User> listAll() {
		logger.info("Fetching all users");
		List<User> users = userDAO.getAllUsers();
		logger.info("Successfully fetched {} users", users.size());
		return users;
	}

	@Override
	@Transactional
	public void addUser(User user) {
		String hashedPassword = PasswordEncryptor.encryptPassword(user.getPassword());
		user.setPassword(hashedPassword);
		logger.info("Adding a new user with email: {}", user.getEmail());
		userDAO.persistUser(user);
		logger.info("User added successfully with email: {}", user.getEmail());
	}

	@Override
	@Transactional
	public void change_Password(UserPasswordChange userPasswordChange) {
		logger.info("Changing password for user with email: {}", userPasswordChange.getEmail());
		String hashedPassword = PasswordEncryptor.encryptPassword(userPasswordChange.getPassword());
		userPasswordChange.setPassword(hashedPassword);
		userDAO.changePassword(userPasswordChange);
		logger.info("Password changed successfully for user with email: {}", userPasswordChange.getEmail());
	}
}
