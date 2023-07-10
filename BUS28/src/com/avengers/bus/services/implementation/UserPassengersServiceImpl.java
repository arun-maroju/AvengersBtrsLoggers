package com.avengers.bus.services.implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.UserPassengersDAO;
import com.avengers.bus.models.entityModels.UserPassengers;
import com.avengers.bus.services.contracts.UserPassengersService;

@Component
public class UserPassengersServiceImpl implements UserPassengersService {

	private static final Logger logger = LoggerFactory.getLogger(UserPassengersServiceImpl.class);

	@Autowired
	private UserPassengersDAO userPassengersDAO;

	public UserPassengersServiceImpl(UserPassengersDAO userPassengersDAO) {
		this.userPassengersDAO = userPassengersDAO;
	}

	@Override
	public List<UserPassengers> getAllUserPassengers(int userId) {
		logger.info("Fetching all user passengers for user with ID: {}", userId);
		List<UserPassengers> userPassengersList = userPassengersDAO.getAllUserPassengers(userId);
		logger.info("Successfully fetched {} user passengers for user with ID: {}", userPassengersList.size(), userId);
		return userPassengersList;
	}
}
