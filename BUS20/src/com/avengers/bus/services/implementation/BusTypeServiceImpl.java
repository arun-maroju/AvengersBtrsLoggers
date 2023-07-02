package com.avengers.bus.services.implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.models.entityModels.BusTypes;
import com.avengers.bus.services.contracts.BusTypeService;

@Component
public class BusTypeServiceImpl implements BusTypeService {
	private static final Logger logger = LoggerFactory.getLogger(BusListServiceImpl.class);

	private BusSearchDAO busSearchDAO;

	@Autowired
	public BusTypeServiceImpl(BusSearchDAO busSearchDAO) {
		this.busSearchDAO = busSearchDAO;
	}

	@Transactional(readOnly = true)
	public List<BusTypes> listAll() {
		logger.info("Listing all BusTypes");

		return busSearchDAO.getAllBusTypes();
	}

}
