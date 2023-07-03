package com.avengers.bus.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.models.entityModels.BusTypes;
import com.avengers.bus.models.entityModels.SeatsBookedForOneService;
import com.avengers.bus.models.entityModels.Stations;

@Component
public class BusSearchDaoImpl implements BusSearchDAO {
	@PersistenceContext
	EntityManager em;

	// this will return the seats that are already booked by others for that particular service
	@Override
	@Transactional(readOnly = true)
	public List<SeatsBookedForOneService> getBookedSeats(int service_id) {

		return em.createQuery("Select seats From SeatsBookedForOneService seats where seats.service_id=" + service_id)
				.getResultList();
	}

	// ths will get all the bus types available
	@Transactional(readOnly = true)
	public List<BusTypes> getAllBusTypes() {
		return em.createQuery("SELECT bt FROM BusTypes bt").getResultList();
	}

	// this will get all the stations available
	@Transactional(readOnly = true)
	public List<Stations> getAllStations() {
		return em.createQuery("SELECT e FROM Stations e").getResultList();

	}

}
