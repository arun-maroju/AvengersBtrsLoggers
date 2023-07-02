package com.avengers.bus.services.implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.models.entityModels.Stations;
import com.avengers.bus.services.contracts.StationService;

@Component
public class StationServiceImpl implements StationService {

	private static final Logger logger = LoggerFactory.getLogger(StationServiceImpl.class);

	private BusSearchDAO busSearchDAO;

	@Autowired
	public StationServiceImpl(BusSearchDAO busSearchDAO) {
		this.busSearchDAO = busSearchDAO;
	}

	@Transactional(readOnly = true)
	public List<Stations> listAll() {
		logger.info("Fetching all stations.");
		return busSearchDAO.getAllStations();
	}
}
