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
import com.avengers.bus.utilities.exceptions.TicketNotPersistedException;

@Component
public class TicketManagementDAOImpl implements TicketManagementDAO {

	private static final Logger logger = LoggerFactory.getLogger(TicketManagementDAOImpl.class);

	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override
	public void saveTicket(Ticket ticket) throws TicketNotPersistedException {
		logger.info("Attempting to save ticket: {}", ticket);

		try {
			em.persist(ticket); // Save the ticket entity along with passengers..

		} catch (Exception e) {
			logger.error("Error occurred while saving ticket: {}", e.getMessage());
			throw new TicketNotPersistedException("Ticket Not Booked", ticket);
		}
	}

	// It will cancel the ticket upon user request
	@Override
	@Transactional
	public boolean cancelTicket(String bookingId, String refund_id) {
		logger.info("Attempting to cancel ticket with bookingId: {}", bookingId);

		try {
			// Find the ticket entity by ID
			Ticket ticket = em.find(Ticket.class, bookingId);

			if (ticket != null) {
				logger.info("Ticket found: {}", ticket);

				// Update the desired column value
				ticket.setStatus("cancelled");
				ticket.setRefund_id(refund_id);

				// Merge the changes into the entity manager
				em.merge(ticket);
				

				logger.info("Ticket cancelled successfully");
				return true; // Return true if the update was successful
			}
		} catch (Exception e) {
			logger.error("Error occurred while canceling ticket: {}", e.getMessage());
			e.printStackTrace();
		}

		logger.info("Failed to cancel ticket with bookingId: {}", bookingId);
		return false;
	}

	// This will return how many seats have already been booked in the array of seats passed
	@Override
	public int getBookedSeatsCount(int service_no, int[] seat) {
		logger.info("Getting booked seats count for service_no: {}", service_no);

		Long count = em.createQuery(
				"SELECT COUNT(sb) FROM SeatsBookedForOneService sb WHERE sb.status = true AND sb.service_id = :serviceId AND sb.seat_id IN :seats",
				Long.class).setParameter("serviceId", service_no)
				.setParameter("seats", Arrays.stream(seat).boxed().collect(Collectors.toList())).getSingleResult();

		logger.info("Booked seats count: {}", count);
		return count != null ? count.intValue() : 0;
	}
}
