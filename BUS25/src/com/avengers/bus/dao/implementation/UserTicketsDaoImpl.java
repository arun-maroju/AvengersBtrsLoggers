package com.avengers.bus.dao.implementation;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.UserTicketsDAO;
import com.avengers.bus.models.entityModels.Ticket;

@Repository
@Transactional
@Component
public class UserTicketsDaoImpl implements UserTicketsDAO {

	@PersistenceContext
	private EntityManager em;

	// This will list all the tickets of one user
	@Override
	public List<Ticket> ticketList(int userId) {
		System.out.println("this is tickets");
		Query query = em.createQuery("select t from Ticket t where t.user_id=" + userId, Ticket.class);
		return query.getResultList();
	}

	// This will list all the past tickets booked by one user
	@Override
	public List<Ticket> pastTicketList(int userId) {
		System.out.println("this is pasttickets");
		String status = "confirmed";
		LocalDate currentDate = LocalDate.now();
		Date sqlDate = Date.valueOf(currentDate);
		LocalTime currentTime = LocalTime.now();
		Time sqlTime = Time.valueOf(currentTime);
		Query query = em.createQuery(
				"select t from Ticket t where  t.user_id =: userId  AND  (t.travel_date < :sqlDate OR (t.travel_date = :sqlDate AND  t.departure<:currentTime)) AND t.status =: status",
				Ticket.class);
		query.setParameter("sqlDate", sqlDate);
		query.setParameter("userId", userId);
		query.setParameter("status", status);
		query.setParameter("currentTime", sqlTime);
		return query.getResultList();
	}

	// This will return all the future tickets booked by one user
	@Override
	public List<Ticket> futureTicketList(int userId) {
		System.out.println("this is tickets");
		String status = "confirmed";
		LocalDate currentDate = LocalDate.now();
		Date sqlDate1 = Date.valueOf(currentDate);
		LocalTime currentTime = LocalTime.now();
		Time sqlTime = Time.valueOf(currentTime);
		Query query = em.createQuery(
				"select t from Ticket t where (t.travel_date > :sqlDate OR (t.travel_date = :sqlDate AND  t.departure>:currentTime))  AND t.user_id=:userId  AND t.status =: status order By t.travel_date ",
				Ticket.class);
		query.setParameter("sqlDate", sqlDate1);
		query.setParameter("userId", userId);
		query.setParameter("status", status);
		query.setParameter("currentTime", sqlTime);
		return query.getResultList();
	}

	// This will list all the tickets
	@Override
	public List<Ticket> getAllTickets(int userId) {
		System.out.println("this is tickets");
		Query query = em.createQuery("select t from Ticket t where t.user_id=" + userId, Ticket.class);
		return query.getResultList();
	}

	// This will list all the cancelled TicketsList
	@Override
	public List<Ticket> cancelTicketList(int userId) {
		System.out.println("this is tickets");
		String status = "cancelled";
		LocalDate currentDate = LocalDate.now();
		Date sqlDate1 = Date.valueOf(currentDate);
		Query query = em.createQuery(
				"select t from Ticket t where  t.user_id=:userId  AND t.status =: status order By t.travel_date ",
				Ticket.class);
		query.setParameter("userId", userId);
		query.setParameter("status", status);
		return query.getResultList();

	}

	// This will return all the tickets qualified for rating
	@Override
	public List<Ticket> ratingTicketList(int userId) {
		String status = "confirmed";
		LocalDate currentDate = LocalDate.now();
		Date sqlDate = Date.valueOf(currentDate);
		Query query = em.createQuery(
				"select t from Ticket t where  t.user_id =: userId  AND  t.travel_date < :sqlDate  AND t.status =: status AND t.travel_date >= CURRENT_DATE - :interval AND t.rating=0",
				Ticket.class);
		query.setParameter("sqlDate", sqlDate);
		query.setParameter("userId", userId);
		query.setParameter("status", status);
		query.setParameter("interval", 30);
		return query.getResultList();
	}

	// We can give rating
	@Override
	public void updateRatingTicketList(int userId, Ticket ratingSubmission) {
		Ticket entityToUpdate = em.find(Ticket.class, ratingSubmission.getBooking_id());
		entityToUpdate.setRating(ratingSubmission.getRating());
		em.merge(entityToUpdate);
	}

}
