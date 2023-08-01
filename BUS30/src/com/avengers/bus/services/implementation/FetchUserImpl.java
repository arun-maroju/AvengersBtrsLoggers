package com.avengers.bus.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.UserListDAO;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.services.contracts.FetchUser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FetchUserImpl implements FetchUser {

	private static final Logger LOGGER = LoggerFactory.getLogger(FetchUserImpl.class);

	@Autowired
	private UserListDAO userListDAO;

	// Fetch user details for a given user ID
	@Override
	public String getUserList(int userId) {
		LOGGER.info("Fetching user details for user with ID: {}", userId);

		List<User> users = userListDAO.UserList(userId);
		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(users);
			LOGGER.debug("JSON response: {}", json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error converting user list to JSON: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// Add or Update user details
	@Transactional
	public void add(User user) {
		LOGGER.info("Adding or updating user with ID: {}", user.getUser_id());

		userListDAO.updateUser(user);

		LOGGER.info("User details added/updated successfully.");
	}
}
