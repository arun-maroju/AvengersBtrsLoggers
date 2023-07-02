package com.avengers.bus.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(ListsDAOImpl.class);
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Services> serviceList() {
        logger.info("Fetching service list");
		return em.createQuery("SELECT s FROM Services s", Services.class).getResultList();

	}

	@Override
	public List<Routes> routeList() {
        logger.info("Fetching route list");
		return em.createQuery("SELECT r FROM Routes r", Routes.class).getResultList();
	}

	@Override
	public List<Bus> busList() {
        logger.info("Fetching bus list");
		return em.createQuery("SELECT b FROM Bus b", Bus.class).getResultList();
	}

	@Override
	public List<Ticket> ticketList() {
        logger.info("Fetching ticket list");
		return em.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();
	}

	@Override
	public List<ServicePassenger> servicePassengerList(int service_id) {
        logger.info("Fetching service passenger list for service_id: {}", service_id);
		// return em.createQuery("SELECT t1.booking_id, t2.seat_no, t2.passenger_name, t2.age, t2.gender FROM Ticket t1,
		// TicketPassenger t2 where t1.service_id="+service_id+" and t1.booking_id=t2.booking_id order by t2.seat_no",
		// ServicePassenger.class).getResultList();
        try {
            String queryString = "SELECT t1.booking_id, t2.seat_no, t2.passenger_name, t2.age, t2.gender " +
                    "FROM Ticket t1, TicketPassenger t2 " +
                    "WHERE t1.service_id = :serviceId " +
                    "AND t1.booking_id = t2.booking_id " +
                    "ORDER BY t2.seat_no";

            List<Object[]> results = em.createQuery(queryString)
                    .setParameter("serviceId", service_id)
                    .getResultList();

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
        } catch (Exception e) {
            logger.error("Error retrieving service passenger list: {}", e.getMessage());
            // Handle or rethrow the exception as needed
        }
		return null;
	}

}
