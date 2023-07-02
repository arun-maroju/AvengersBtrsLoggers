package com.avengers.bus.dao.implementation;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.UserListDAO;
import com.avengers.bus.models.entityModels.User;

@Repository
@Transactional
@Component
public class UserListDaoImpl implements UserListDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@PersistenceContext
	private EntityManager em;

	public void persist(User user) {
		logger.info("Persisting user: {}", user);

        try {
            em.persist(user);
        } catch (Exception e) {
            logger.error("Error persisting user: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
	}

	@Override
	public List<User> UserList(int userId) {
		// TODO Auto-generated method stub
		 logger.info("Getting user list for userId: {}", userId);

	        try {
	            Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :userId", User.class);
	            query.setParameter("userId", userId);
	            List<User> userList = query.getResultList();
	            logger.info("Total users found: {}", userList.size());
	            return userList;
	        } catch (Exception e) {
	            logger.error("Error getting user list: {}", e.getMessage());
	            // Handle or rethrow the exception as needed
	        }

	        return Collections.emptyList();
	}

	public User findById(long id) {
		 logger.info("Finding user by ID: {}", id);

	        try {
	            User user = em.find(User.class, id);
	            logger.info("User found: {}", user);
	            return user;
	        } catch (Exception e) {
	            logger.error("Error finding user by ID: {}", e.getMessage());
	            // Handle or rethrow the exception as needed
	        }

	        return null;
	}

	@Transactional
	public void updateUser(User user) {
		logger.info("Updating user: {}", user);

        try {
            em.merge(user);
        } catch (Exception e) {
            logger.error("Error updating user: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
	}

}
