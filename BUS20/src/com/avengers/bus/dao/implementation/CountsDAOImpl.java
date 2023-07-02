package com.avengers.bus.dao.implementation;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.CountsDAO;

@Repository
@Primary
@Component
public class CountsDAOImpl implements CountsDAO {
	private static final Logger logger = LoggerFactory.getLogger(CountsDAOImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public int busCount() {
        logger.info("Fetching bus count");

        try {
            Long count = em.createQuery("SELECT COUNT(*) FROM Bus b", Long.class).getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            logger.error("Error retrieving bus count: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
		return 0;
        
	}

	@Override
	public int serviceCount() {

		logger.info("Fetching service count");

        try {
            Long count = em.createQuery("SELECT COUNT(*) FROM Services s", Long.class).getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            logger.error("Error retrieving service count: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
		return 0;
	}

	@Override
	public int totalPayments() {
		logger.info("Calculating total payments");

        try {
            Long sum = em.createQuery("SELECT SUM(sc.collection) FROM Services sc", Long.class).getSingleResult();
            return sum != null ? sum.intValue() : 0;
        } catch (Exception e) {
            logger.error("Error calculating total payments: {}", e.getMessage());
            // Handle or rethrow the exception as needed
            return 0; // Add a default return value
        }
	}

	@Override
	public int userCount() {
		logger.info("Fetching user count");

        try {
            Long count = em.createQuery("SELECT COUNT(*) FROM User u", Long.class).getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            logger.error("Error retrieving user count: {}", e.getMessage());
            // Handle or rethrow the exception as needed
            return 0; // Add a default return value
        }

	}

	@Override
	public int routeCount() {
		logger.info("Fetching route count");

        try {
            Long count = em.createQuery("SELECT COUNT(*) FROM Routes r", Long.class).getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            logger.error("Error retrieving route count: {}", e.getMessage());
            // Handle or rethrow the exception as needed
            return 0; // Add a default return value
        }
	}

	@Override
	public int tripCount() {
		logger.info("Fetching trip count");

        try {
            Long count = em.createQuery("SELECT COUNT(*) FROM Trips t", Long.class).getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            logger.error("Error retrieving trip count: {}", e.getMessage());
            // Handle or rethrow the exception as needed
            return 0; // Add a default return value
        }
	}

	@Override
	public int pastTicketCollection() {
		 logger.info("Calculating past ticket collection");

	        LocalDate currentDate = LocalDate.now();
	        java.sql.Date sqlCurrentDate = java.sql.Date.valueOf(currentDate);

	        try {
	            Long sum = em.createQuery("SELECT SUM(sc.collection) FROM Services sc WHERE sc.trip_date < :currentDate", Long.class)
	                    .setParameter("currentDate", sqlCurrentDate, TemporalType.DATE)
	                    .getSingleResult();
	            return sum != null ? sum.intValue() : 0;
	        } catch (Exception e) {
	            logger.error("Error calculating past ticket collection: {}", e.getMessage());
	            // Handle or rethrow the exception as needed
	            return 0; // Add a default return value
	        }
	}

	@Override
	public int futureTicketCollection() {
		logger.info("Calculating future ticket collection");

        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlCurrentDate = java.sql.Date.valueOf(currentDate);

        try {
            Long sum = em.createQuery("SELECT SUM(sc.collection) FROM Services sc WHERE sc.trip_date >= :currentDate", Long.class)
                    .setParameter("currentDate", sqlCurrentDate, TemporalType.DATE)
                    .getSingleResult();
            return sum != null ? sum.intValue() : 0;
        } catch (Exception e) {
            logger.error("Error calculating future ticket collection: {}", e.getMessage());
            // Handle or rethrow the exception as needed
            return 0; // Add a default return value
        }
	}

}
