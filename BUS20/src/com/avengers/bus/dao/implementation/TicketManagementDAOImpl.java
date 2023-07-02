package com.avengers.bus.dao.implementation;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.TicketManagementDAO;
import com.avengers.bus.models.entityModels.Ticket;

@Component
public class TicketManagementDAOImpl implements TicketManagementDAO {
	private static final Logger logger = LoggerFactory.getLogger(TicketManagementDAOImpl.class);

	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override
	public void saveTicket(Ticket ticket) {
        logger.info("Saving ticket: {}", ticket);
        try {
            em.persist(ticket); // Save the ticket entity along with passengers..
            logger.info("Ticket saved successfully");
        } catch (Exception e) {
            logger.error("Error saving ticket: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }// Save the ticket entity along with passengers..
	}

	@Override
	@Transactional
	public boolean cancelTicket(String bookingId) {
		logger.info("Cancelling ticket with booking ID: {}", bookingId);
		System.out.println("in CancelTicketDaoImpl cancel ticket before try");

		try {
			System.out.println("in CancelTicketDaoImpl cancel ticket in try");

			// Find the ticket entity by ID
			Ticket ticket = em.find(Ticket.class, bookingId);

			System.out.println(ticket);
			if (ticket != null) {

				System.out.println("in CancelTicketDaoImpl cancel ticket in try if");

				// Update the desired column value
				ticket.setStatus("cancelled");

				System.out.println(ticket);
				// Merge the changes into the entity manager
				em.merge(ticket);
                logger.info("Ticket cancelled successfully");
				System.out.println("after merge");

				return true; // Return true if the update was successful
			}
		} catch (Exception e) {
            logger.error("Error cancelling ticket: {}", e.getMessage());
			System.out.println("catch..");
			e.printStackTrace();
		}

		System.out.println("before false return in dao");

		return false;
	}

	@Override
	public int getBookedSeatsCount(int service_no, int[] seat) {
        logger.info("Getting booked seats count for service number: {}", service_no);
		System.out.println("In BookedSeatsCount " + service_no);
		Long count = em.createQuery(
				"SELECT COUNT(sb) FROM SeatsBookedForOneService sb WHERE sb.status = true AND sb.service_id = :serviceId AND sb.seat_id IN :seats",
				Long.class).setParameter("serviceId", service_no)
				.setParameter("seats", Arrays.stream(seat).boxed().collect(Collectors.toList())).getSingleResult();
		System.out.println(count);
        logger.info("Booked seats count: {}", count);
		return count != null ? count.intValue() : 0;
	}
}
