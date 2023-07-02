package com.avengers.bus.services.implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.BusListDAO;
import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.inputModels.SearchBusInput;
import com.avengers.bus.services.contracts.BusListService;

@Component
public class BusListServiceImpl implements BusListService {
	private static final Logger logger = LoggerFactory.getLogger(BusListServiceImpl.class);

	@Autowired
	private BusListDAO busListDAO;

	@Override
	public List<BusSearchListDto> getBusList(SearchBusInput sbi) {
		List<BusSearchListDto> buses;
		logger.info("Fetching all buslist based on TravelClass");

		if (sbi.getTravelClass() > 0) {
			logger.info("Fetching a buslist based on a  particular TravelClass");

			buses = busListDAO.getBusList(sbi);
		}

		else {
			logger.info("Fetching a buslist of any TravelClass");

			buses = busListDAO.getBusListAll(sbi);
		}

		return buses;
	}

}
