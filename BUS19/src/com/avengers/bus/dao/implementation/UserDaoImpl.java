package com.avengers.bus.dao.implementation;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.UserDAO;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.inputModels.UserPasswordChange;

@Component
public class UserDaoImpl implements UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@PersistenceContext
	EntityManager em;

	// public User findByEmail(String email) {
	// boolean e = em.contains(email);
	// return null;
	// }

	@Override
	public User findByEmail(String email) {
		logger.info("Finding user by email: {}", email);

        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            List<User> users = query.getResultList();
            if (!users.isEmpty()) {
                User user = users.get(0);
                logger.info("User found: {}", user);
                return user;
            }
        } catch (Exception e) {
            logger.error("Error finding user by email: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }

        return null;
	}

	public List<User> getAllUsers() {
		logger.info("Getting all users");

        try {
            List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
            logger.info("Total users: {}", users.size());
            return users;
        } catch (Exception e) {
            logger.error("Error getting all users: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
        return Collections.emptyList();

	}

	@Override
	public void persistUser(User user) {
		logger.info("Persisting user: {}", user);

        try {
            em.persist(user);
        } catch (Exception e) {
            logger.error("Error persisting user: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
	}

	@Override
	public void changePassword(UserPasswordChange userPasswordChange) {
		logger.info("Changing password for user with email: {}", userPasswordChange.getEmail());

        try {
            User user = findByEmail(userPasswordChange.getEmail());
            if (user != null) {
                user.setPassword(userPasswordChange.getPassword());
                logger.info("Updated user: {}", user);
                em.persist(user);
            }
        } catch (Exception e) {
            logger.error("Error changing password: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
	}

}
