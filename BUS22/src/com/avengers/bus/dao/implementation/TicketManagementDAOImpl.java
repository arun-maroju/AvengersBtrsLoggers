package com.avengers.bus.dao.implementation;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.TicketManagementDAO;
import com.avengers.bus.models.entityModels.Ticket;
import com.avengers.bus.utilities.exceptions.TicketNotPersistedException;

@Component
public class TicketManagementDAOImpl implements TicketManagementDAO {

	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override
	public void saveTicket(Ticket ticket) throws TicketNotPersistedException {
		throw new TicketNotPersistedException("Ticket Not Booked", ticket);
		// em.persist(ticket); // Save the ticket entity along with passengers..

	}

	// It will cancel the ticket upon user request
	@Override
	@Transactional
	public boolean cancelTicket(String bookingId) {

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
				System.out.println("after merge");

				return true; // Return true if the update was successful
			}
		} catch (Exception e) {

			System.out.println("catch..");

			e.printStackTrace();
		}

		System.out.println("before false return in dao");

		return false;
	}

	// this will return how many seats have already booked in the array of seats passed
	@Override
	public int getBookedSeatsCount(int service_no, int[] seat) {
		System.out.println("In BookedSeatsCount " + service_no);
		Long count = em.createQuery(
				"SELECT COUNT(sb) FROM SeatsBookedForOneService sb WHERE sb.status = true AND sb.service_id = :serviceId AND sb.seat_id IN :seats",
				Long.class).setParameter("serviceId", service_no)
				.setParameter("seats", Arrays.stream(seat).boxed().collect(Collectors.toList())).getSingleResult();
		System.out.println(count);
		return count != null ? count.intValue() : 0;
	}
}
