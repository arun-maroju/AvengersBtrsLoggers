package com.avengers.bus.dao.implementation;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.UserPassengersDAO;
import com.avengers.bus.models.entityModels.UserPassengers;
import com.avengers.bus.models.entityModels.UserPassengersId;

@Repository
@Transactional
@Component
public class UserPassengersDaoImpl implements UserPassengersDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserPassengersDaoImpl.class);
	@PersistenceContext
	EntityManager em;

	public void persist(UserPassengers userpass) {
		logger.info("Persisting user passengers: {}", userpass);

        try {
            em.persist(userpass);
        } catch (Exception e) {
            logger.error("Error persisting user passengers: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
	}

	@Override
	public List<UserPassengers> getAllUserPassengers(int userId) {
		logger.info("Getting all user passengers for userId: {}", userId);

        try {
            List<UserPassengers> userPassengersList = em.createQuery("SELECT up FROM UserPassengers up WHERE up.user_id = :userId", UserPassengers.class)
                    .setParameter("userId", userId)
                    .getResultList();

            logger.info("Total user passengers found: {}", userPassengersList.size());
            return userPassengersList;
        } catch (Exception e) {
            logger.error("Error getting all user passengers: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }

        return Collections.emptyList();
	}

	@Transactional
	public void updateUserPassengers(UserPassengersId userpass) {
		logger.info("Updating user passengers: {}", userpass);

        try {
            em.merge(userpass);
        } catch (Exception e) {
            logger.error("Error updating user passengers: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }

	}

	@Transactional
	public void deleteUserPassengers(UserPassengersId userpass) {
		logger.info("Deleting user passengers: {}", userpass);

        try {
            UserPassengers pass1 = em.find(UserPassengers.class, userpass);
            logger.info("User passengers found: {}", pass1);
            if (pass1 != null) {
                em.remove(pass1);
            }
        } catch (Exception e) {
            logger.error("Error deleting user passengers: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
	}
}
