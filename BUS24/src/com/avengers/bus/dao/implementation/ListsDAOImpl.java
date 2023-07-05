package com.avengers.bus.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.avengers.bus.dao.contracts.ListsDAO;
import com.avengers.bus.models.dtoModels.ServicePassenger;
import com.avengers.bus.models.entityModels.Bus;
import com.avengers.bus.models.entityModels.Routes;
import com.avengers.bus.models.entityModels.Services;
import com.avengers.bus.models.entityModels.Ticket;

@Repository
@Primary
@Component
public class ListsDAOImpl implements ListsDAO {

	@PersistenceContext
	private EntityManager em;

	// It will get the all services list
	@Override
	public List<Services> serviceList(int start, int end) {
		return em.createQuery("SELECT s FROM Services s", Services.class).setFirstResult(start)
				.setMaxResults(end + 1 - start).getResultList();

	}

	// It will get all the route list
	@Override
	public List<Routes> routeList() {
		return em.createQuery("SELECT r FROM Routes r", Routes.class).getResultList();
	}

	// It will list all the bus list
	@Override
	public List<Bus> busList() {
		return em.createQuery("SELECT b FROM Bus b", Bus.class).getResultList();
	}

	// It will list all the tickets list
	@Override
	public List<Ticket> ticketList() {
		return em.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();
	}

	// It will return all the passengers travelling in one particular service
	@Override
	public List<ServicePassenger> servicePassengerList(int service_id) {
		String queryString = "SELECT t1.booking_id, t2.seat_no, t2.passenger_name, t2.age, t2.gender "
				+ "FROM Ticket t1, TicketPassenger t2 " + "WHERE t1.service_id = :serviceId "
				+ "AND t1.booking_id = t2.booking_id " + "ORDER BY t2.seat_no";

		List<Object[]> results = em.createQuery(queryString).setParameter("serviceId", service_id).getResultList();

		List<ServicePassenger> passengers = new ArrayList<>();
		for (Object[] row : results) {
			ServicePassenger passenger = new ServicePassenger();
			passenger.setService_id(service_id);
			passenger.setBooking_id((String) row[0]);
			passenger.setSeat_no((int) row[1]);
			passenger.setPassenger_name((String) row[2]);
			passenger.setAge((int) row[3]);
			passenger.setGender((String) row[4]);
			passengers.add(passenger);
		}
		return passengers;
	}

	@Override
	public List<Services> allServiceList() {
		return em.createQuery("SELECT s FROM Services s", Services.class).getResultList();

	}

}
