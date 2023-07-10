package com.avengers.bus.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.UserPassengersDAO;
import com.avengers.bus.models.entityModels.UserPassengers;
import com.avengers.bus.models.entityModels.UserPassengersId;
import com.avengers.bus.services.contracts.FetchUserPassengers;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FetchUserPassengersImpl implements FetchUserPassengers {

	private static final Logger LOGGER = LoggerFactory.getLogger(FetchUserPassengersImpl.class);

	@Autowired
	private UserPassengersDAO userPassengersDAO;

	// Fetch all passengers for a given user
	@Override
	public String getPassengersList(int userId) {
		LOGGER.info("Fetching all passengers for user with ID: {}", userId);

		List<UserPassengers> userPassengers = userPassengersDAO.getAllUserPassengers(userId);
		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(userPassengers);
			LOGGER.debug("JSON response: {}", json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error converting passenger list to JSON: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// Update or Add a passenger for a given user
	@Transactional
	public void addeditedpassengers(UserPassengers userpass) {
		LOGGER.info("Updating or adding passenger for user with ID: {}", userpass.getUser_id());

		UserPassengersId passengerId = new UserPassengersId(); // Create an instance of the composite key class
		passengerId.setUser_id(userpass.getUser_id()); // Set the user ID
		passengerId.setPassenger_name(userpass.getPassenger_name());
		passengerId.setAge(userpass.getAge());
		passengerId.setGender(userpass.getGender());
		userPassengersDAO.updateUserPassengers(passengerId);

		LOGGER.info("Passenger updated/added successfully.");
	}

	// Delete a passenger for a given user
	@Override
	public void deleteUserpassengers(UserPassengers userpass) {
		LOGGER.info("Deleting passenger for user with ID: {}", userpass.getUser_id());

		UserPassengersId passengerId = new UserPassengersId(); // Create an instance of the composite key class
		passengerId.setUser_id(userpass.getUser_id()); // Set the user ID
		passengerId.setPassenger_name(userpass.getPassenger_name());
		passengerId.setAge(userpass.getAge());
		passengerId.setGender(userpass.getGender());
		LOGGER.debug("Deleting passenger: {}", passengerId);
		userPassengersDAO.deleteUserPassengers(passengerId);

		LOGGER.info("Passenger deleted successfully.");
	}

	// Add a new passenger for a given user
	@Override
	public void addUserpassengers(UserPassengers userpass) {
		LOGGER.info("Adding a new passenger for user with ID: {}", userpass.getUser_id());

		userPassengersDAO.persist(userpass);

		LOGGER.info("Passenger added successfully.");
	}
}
