package com.avengers.bus.dao.implementation;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.UserCountsDAO;

@Repository
@Primary
@Component
public class UserCountsDaoImpl implements UserCountsDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserCountsDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public int bookedCount(int userId) {
		logger.info("Getting booked count for user ID: {}", userId);

        try {
            String jpql = "SELECT COUNT(*) FROM Ticket t WHERE t.user_id = :userId";
            Long bookedCount = em.createQuery(jpql, Long.class).setParameter("userId", userId).getSingleResult();
            logger.info("Booked count: {}", bookedCount);
            return bookedCount.intValue();
        } catch (Exception e) {
            logger.error("Error getting booked count: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }

        return 0;
	}

	@Override
	public int travelCount(int userId) {
		logger.info("Getting travel count for user ID: {}", userId);

        try {
            String status = "confirmed";
            LocalDate currentDate = LocalDate.now();
            Date sqlDate = Date.valueOf(currentDate);
            LocalTime currentTime = LocalTime.now();
            Time sqlTime = Time.valueOf(currentTime);
            String jpql = "SELECT COUNT(*) FROM Ticket t WHERE t.user_id = :userId AND t.status =: status AND (t.travel_date<:today_date  OR (t.travel_date=:today_date AND t.departure<:currentTime))";
            Long travelCount = em.createQuery(jpql, Long.class)
                    .setParameter("userId", userId)
                    .setParameter("today_date", sqlDate)
                    .setParameter("currentTime", sqlTime)
                    .setParameter("status", status)
                    .getSingleResult();
            logger.info("Travel count: {}", travelCount);
            return travelCount.intValue();
        } catch (Exception e) {
            logger.error("Error getting travel count: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
        return 0;
	}

	@Override
	public double getWallet(int userId) {
		logger.info("Getting wallet for user ID: {}", userId);

        try {
            String jpql = "SELECT u.wallet FROM User u WHERE u.user_id = :userId";
            Double wallet = em.createQuery(jpql, Double.class).setParameter("userId", userId).getSingleResult();
            logger.info("Wallet: {}", wallet);
            return wallet;
        } catch (Exception e) {
            logger.error("Error getting wallet: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }

        return 0.0;
	}

	@Override
	public String getName(int userId) {
		logger.info("Getting name for user ID: {}", userId);

        try {
            String jpql = "SELECT u.full_name FROM User u WHERE u.user_id = :userId";
            String name = em.createQuery(jpql, String.class).setParameter("userId", userId).getSingleResult();
            logger.info("Name: {}", name);
            return name;
        } catch (Exception e) {
            logger.error("Error getting name: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }

        return "";
	}

	@Override
	public int userFutureTravelCount(int userId) {
		logger.info("Getting future travel count for user ID: {}", userId);

        try {
            String status = "confirmed";
            LocalDate currentDate = LocalDate.now();
            Date sqlDate = Date.valueOf(currentDate);
            LocalTime currentTime = LocalTime.now();
            Time sqlTime = Time.valueOf(currentTime);
            String jpql = "SELECT COUNT(*) FROM Ticket t WHERE t.user_id = :userId AND t.status =: status AND (t.travel_date>:today_date  OR (t.travel_date=:today_date AND t.departure>:currentTime))";
            Long travelCount = em.createQuery(jpql, Long.class)
                    .setParameter("userId", userId)
                    .setParameter("today_date", sqlDate)
                    .setParameter("currentTime", sqlTime)
                    .setParameter("status", status)
                    .getSingleResult();
            logger.info("Future travel count: {}", travelCount);
            return travelCount.intValue();
        } catch (Exception e) {
            logger.error("Error getting future travel count: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }

        return 0;
	}
}
