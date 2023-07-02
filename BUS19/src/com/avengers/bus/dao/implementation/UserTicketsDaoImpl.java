package com.avengers.bus.dao.implementation;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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

import com.avengers.bus.dao.contracts.UserTicketsDAO;
import com.avengers.bus.models.entityModels.Ticket;

@Repository
@Transactional
@Component
public class UserTicketsDaoImpl implements UserTicketsDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserTicketsDaoImpl.class);
	@PersistenceContext
	private EntityManager em;

	// public void persist(UserTickets userTickets) {
	// em.persist(userTickets);
	// }

	@Override
	public List<Ticket> ticketList(int userId) {
		logger.info("Getting ticket list for userId: {}", userId);
        try {
            Query query = em.createQuery("SELECT t FROM Ticket t WHERE t.user_id = :userId", Ticket.class);
            query.setParameter("userId", userId);
            List<Ticket> ticketList = query.getResultList();
            logger.info("Total tickets found: {}", ticketList.size());
            return ticketList;
        } catch (Exception e) {
            logger.error("Error getting ticket list: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
        return Collections.emptyList();
	}

	@Override
	public List<Ticket> pastTicketList(int userId) {
		logger.info("Getting past tickets for userId: {}", userId);
        try {
            String status = "confirmed";
            LocalDate currentDate = LocalDate.now();
            Date sqlDate = Date.valueOf(currentDate);
            LocalTime currentTime = LocalTime.now();
            Time sqlTime = Time.valueOf(currentTime);
            Query query = em.createQuery(
                    "select t from Ticket t where t.user_id = :userId AND (t.travel_date < :sqlDate OR (t.travel_date = :sqlDate AND t.departure < :currentTime)) AND t.status = :status",
                    Ticket.class);
            query.setParameter("sqlDate", sqlDate);
            query.setParameter("userId", userId);
            query.setParameter("status", status);
            query.setParameter("currentTime", sqlTime);
            List<Ticket> tickets = query.getResultList();
            logger.info("Total past tickets found: {}", tickets.size());
            return tickets;
        } catch (Exception e) {
            logger.error("Error getting past tickets: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
        return Collections.emptyList();
	}

	@Override
	public List<Ticket> futureTicketList(int userId) {
		logger.info("Getting future tickets for userId: {}", userId);
        try {
            String status = "confirmed";
            LocalDate currentDate = LocalDate.now();
            Date sqlDate = Date.valueOf(currentDate);
            LocalTime currentTime = LocalTime.now();
            Time sqlTime = Time.valueOf(currentTime);
            Query query = em.createQuery(
                    "select t from Ticket t where (t.travel_date > :sqlDate OR (t.travel_date = :sqlDate AND t.departure > :currentTime)) AND t.user_id = :userId AND t.status = :status order by t.travel_date",
                    Ticket.class);
            query.setParameter("sqlDate", sqlDate);
            query.setParameter("userId", userId);
            query.setParameter("status", status);
            query.setParameter("currentTime", sqlTime);
            List<Ticket> tickets = query.getResultList();
            logger.info("Total future tickets found: {}", tickets.size());
            return tickets;
        } catch (Exception e) {
            logger.error("Error getting future tickets: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
        return Collections.emptyList();
	}

	@Override
	public List<Ticket> getAllTickets(int userId) {
		logger.info("Getting all tickets for userId: {}", userId);
        try {
            Query query = em.createQuery("select t from Ticket t where t.user_id = " + userId, Ticket.class);
            List<Ticket> tickets = query.getResultList();
            logger.info("Total tickets found: {}", tickets.size());
            return tickets;
        } catch (Exception e) {
            logger.error("Error getting all tickets: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
        return Collections.emptyList();
	}

	@Override
	public List<Ticket> cancelTicketList(int userId) {
		logger.info("Getting cancel tickets for userId: {}", userId);
        try {
            String status = "cancelled";
            LocalDate currentDate = LocalDate.now();
            Date sqlDate = Date.valueOf(currentDate);
            Query query = em.createQuery(
                    "select t from Ticket t where t.user_id = :userId AND t.status = :status order by t.travel_date",
                    Ticket.class);
            query.setParameter("userId", userId);
            query.setParameter("status", status);
            List<Ticket> tickets = query.getResultList();
            logger.info("Total cancel tickets found: {}", tickets.size());
            return tickets;
        } catch (Exception e) {
            logger.error("Error getting cancel tickets: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
        return Collections.emptyList();

	}

	@Override
	public List<Ticket> ratingTicketList(int userId) {
		logger.info("Getting rating tickets for userId: {}", userId);
        try {
            String status = "confirmed";
            LocalDate currentDate = LocalDate.now();
            Date sqlDate = Date.valueOf(currentDate);
            Query query = em.createQuery(
                    "select t from Ticket t where t.user_id = :userId AND t.travel_date < :sqlDate AND t.status = :status AND t.travel_date >= CURRENT_DATE - :interval AND t.rating = 0",
                    Ticket.class);
            query.setParameter("sqlDate", sqlDate);
            query.setParameter("userId", userId);
            query.setParameter("status", status);
            query.setParameter("interval", 30);
            List<Ticket> tickets = query.getResultList();
            logger.info("Total rating tickets found: {}", tickets.size());
            return tickets;
        } catch (Exception e) {
            logger.error("Error getting rating tickets: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
        return Collections.emptyList();
	}

	@Override
	public void updateRatingTicketList(int userId, Ticket ratingSubmission) {
		logger.info("Updating rating for ticket with bookingId: {}", ratingSubmission.getBooking_id());
        try {
            Ticket entityToUpdate = em.find(Ticket.class, ratingSubmission.getBooking_id());
            entityToUpdate.setRating(ratingSubmission.getRating());
            em.merge(entityToUpdate);
            logger.info("Rating updated successfully");
        } catch (Exception e) {
            logger.error("Error updating rating: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
	}

}
