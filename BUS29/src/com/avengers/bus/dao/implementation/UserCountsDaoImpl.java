package com.avengers.bus.dao.implementation;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.UserCountsDAO;

@Repository
@Primary
@Component
public class UserCountsDaoImpl implements UserCountsDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int bookedCount(int userId) {
		String jpql = "SELECT COUNT(*) FROM Ticket t WHERE t.user_id = :userId";

		Long bookedCount = em.createQuery(jpql, Long.class).setParameter("userId", userId).getSingleResult();
		return bookedCount.intValue();
	}

	// It will return the no of times a user travelled
	@Override
	public int travelCount(int userId) {
		String status = "confirmed";
		LocalDate currentDate = LocalDate.now();
		Date sqlDate = Date.valueOf(currentDate);
		LocalTime currentTime = LocalTime.now();
		Time sqlTime = Time.valueOf(currentTime);
		String jpql = "SELECT COUNT(*) FROM Ticket t WHERE t.user_id = :userId AND t.status =: status AND (t.travel_date<:today_date  OR (t.travel_date=:today_date AND t.departure<:currentTime))";
		Long travelcount = em.createQuery(jpql, Long.class).setParameter("userId", userId)
				.setParameter("today_date", sqlDate).setParameter("currentTime", sqlTime).setParameter("status", status)
				.getSingleResult();
		return travelcount.intValue();
	}

	// It will return the wallet count
	@Override
	public double getWallet(int userId) {
		String jpql = "SELECT u.wallet FROM User u WHERE u.user_id = :userId";
		Double wallet = em.createQuery(jpql, Double.class).setParameter("userId", userId).getSingleResult();
		return wallet;
	}

	// It will return the name of the user based on user Id
	@Override
	public String getName(int userId) {
		String jpql = "SELECT u.full_name FROM User u WHERE u.user_id = :userId";
		String name = em.createQuery(jpql, String.class).setParameter("userId", userId).getSingleResult();
		return name.toString();
	}

	// It will return the no of future trips for one user
	@Override
	public int userFutureTravelCount(int userId) {
		String status = "confirmed";
		LocalDate currentDate = LocalDate.now();
		Date sqlDate = Date.valueOf(currentDate);
		LocalTime currentTime = LocalTime.now();
		Time sqlTime = Time.valueOf(currentTime);
		String jpql = "SELECT COUNT(*) FROM Ticket t WHERE t.user_id = :userId AND t.status =: status AND (t.travel_date>:today_date  OR (t.travel_date=:today_date AND t.departure>:currentTime))";
		Long travelcount = em.createQuery(jpql, Long.class).setParameter("userId", userId)
				.setParameter("today_date", sqlDate).setParameter("currentTime", sqlTime).setParameter("status", status)
				.getSingleResult();

		System.out.println("Future Travel count is  : " + travelcount);
		return travelcount.intValue();
	}
}
