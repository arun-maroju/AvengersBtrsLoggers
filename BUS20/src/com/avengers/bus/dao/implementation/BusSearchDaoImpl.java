package com.avengers.bus.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.models.entityModels.BusTypes;
import com.avengers.bus.models.entityModels.SeatsBookedForOneService;
import com.avengers.bus.models.entityModels.Stations;

@Component
public class BusSearchDaoImpl implements BusSearchDAO {
	private static final Logger logger = LoggerFactory.getLogger(BusSearchDaoImpl.class);
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<SeatsBookedForOneService> getBookedSeats(int service_id) {
	    logger.info("Fetching booked seats for service_id: {}", service_id);
		return em.createQuery("Select seats From SeatsBookedForOneService seats where seats.service_id=" + service_id)
				.getResultList();
	}

	@Transactional(readOnly = true)
	public List<BusTypes> getAllBusTypes() {
	    logger.info("Fetching all bus types");
		return em.createQuery("SELECT bt FROM BusTypes bt").getResultList();
	}

	@Transactional(readOnly = true)
	public List<Stations> getAllStations() {
	    logger.info("Fetching all stations");
		return em.createQuery("SELECT e FROM Stations e").getResultList();

	}

}
