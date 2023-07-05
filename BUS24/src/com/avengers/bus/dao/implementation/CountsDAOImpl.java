package com.avengers.bus.dao.implementation;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.CountsDAO;

@Repository
@Primary
@Component
public class CountsDAOImpl implements CountsDAO {

	@PersistenceContext
	private EntityManager em;

	// this will get the number of buses for that travel company
	@Override
	public int busCount() {
		Long count = em.createQuery("SELECT COUNT(*) FROM Bus b", Long.class).getSingleResult();
		return count.intValue();
	}

	// this will get the number of services for that travel company
	@Override
	public int serviceCount() {

		Long count = em.createQuery("SELECT COUNT(*) FROM Services s", Long.class).getSingleResult();
		return count.intValue();
	}

	// this will get the total payments summation for that travel agency
	@Override
	public int totalPayments() {

		Long sum = em.createQuery("SELECT SUM(sc.collection) FROM Services sc", Long.class).getSingleResult();
		return sum != null ? sum.intValue() : 0;
	}

	// this will get the total number of users
	@Override
	public int userCount() {
		Long count = em.createQuery("SELECT COUNT(*) FROM User u", Long.class).getSingleResult();
		return count.intValue();

	}

	// this will get the no of routes availble
	@Override
	public int routeCount() {
		Long count = em.createQuery("SELECT COUNT(*) FROM Routes r", Long.class).getSingleResult();
		return count.intValue();
	}

	// this will get the trip count
	@Override
	public int tripCount() {
		Long count = em.createQuery("SELECT COUNT(*) FROM Trips t", Long.class).getSingleResult();
		return count.intValue();
	}

	// this will get the collections collected in past bookings
	@Override
	public int pastTicketCollection() {
		LocalDate currentDate = LocalDate.now();
		java.sql.Date sqlCurrentDate = java.sql.Date.valueOf(currentDate);
		Long sum = em
				.createQuery("SELECT SUM(sc.collection) FROM Services sc WHERE sc.trip_date < :currentDate", Long.class)
				.setParameter("currentDate", sqlCurrentDate, TemporalType.DATE).getSingleResult();
		return sum != null ? sum.intValue() : 0;
	}

	// this will get the collections collected from future boolings
	@Override
	public int futureTicketCollection() {
		LocalDate currentDate = LocalDate.now();
		java.sql.Date sqlCurrentDate = java.sql.Date.valueOf(currentDate);
		Long sum = em.createQuery("SELECT SUM(sc.collection) FROM Services sc WHERE sc.trip_date >= :currentDate",
				Long.class).setParameter("currentDate", sqlCurrentDate, TemporalType.DATE).getSingleResult();
		return sum != null ? sum.intValue() : 0;
	}

}
