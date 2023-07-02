package com.avengers.bus.services.implementation;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.avengers.bus.dao.contracts.UserCountsDAO;
import com.avengers.bus.models.viewModels.UserCounts;
import com.avengers.bus.services.contracts.FetchUserCounts;

@Service
@Transactional
@Component
public class FetchUserCountsImpl implements FetchUserCounts {
	private static final Logger logger = LoggerFactory.getLogger(FetchUserCountsImpl.class);

	@Autowired
	UserCountsDAO userCountsDAO;

	@Override
	public int getUserBookedCount(int userId) {
		logger.info("Fetching User Booked Count for user with ID: {}", userId);
		return userCountsDAO.bookedCount(userId);
	}

	@Override
	public int getUserTravelCount(int userId) {
		logger.info("Fetching User Travel Count for user with ID: {}", userId);
		return userCountsDAO.travelCount(userId);
	}

	@Override
	public double getUserwallet(int userId) {
		logger.info("Fetching User Wallet for user with ID: {}", userId);
		return userCountsDAO.getWallet(userId);
	}

	@Override
	public String getUsername(int userId) {
		logger.info("Fetching Username for user with ID: {}", userId);
		return userCountsDAO.getName(userId);
	}

	@Override
	public UserCounts getUserCounts(int userId) {
		logger.info("Fetching User Counts for user with ID: {}", userId);

		int bookedCount = getUserBookedCount(userId);
		int travelCount = getUserTravelCount(userId);
		double wallet = getUserwallet(userId);
		String username = getUsername(userId);
		int futureTravelCount = getUserFutureTravelCount(userId);

		UserCounts uc = new UserCounts(bookedCount, travelCount, wallet, username, futureTravelCount);
		return uc;
	}

	@Override
	public int getUserFutureTravelCount(int userId) {
		logger.info("Fetching User Future Travel Count for user with ID: {}", userId);
		return userCountsDAO.userFutureTravelCount(userId);
	}
}
