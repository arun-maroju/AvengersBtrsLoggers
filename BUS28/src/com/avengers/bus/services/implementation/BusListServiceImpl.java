package com.avengers.bus.services.implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.BusListDAO;
import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.entityModels.Stations;
import com.avengers.bus.models.inputModels.SearchBusInput;
import com.avengers.bus.services.contracts.BusListService;

@Component
public class BusListServiceImpl implements BusListService {
	private static final Logger logger = LoggerFactory.getLogger(BusListServiceImpl.class);

	@Autowired
	private BusListDAO busListDAO;

	@Autowired
	private BusSearchDAO busSearchDAO;

	@Override
	public List<BusSearchListDto> getBusList(SearchBusInput sbi) {
		List<BusSearchListDto> buses;
		logger.info("Fetching all buslist based on TravelClass");
		Stations station = busSearchDAO.getStation(sbi.getFssId());
		String from = station.getStop_name();
		station = busSearchDAO.getStation(sbi.getTssId());
		String to = station.getStop_name();

		if (sbi.getTravelClass() > 0) {
			logger.info("Fetching a buslist based on a  particular TravelClass");

			buses = busListDAO.getBusList(sbi);
			for (BusSearchListDto bus : buses) {
				System.out.println("In for" + from + "  " + to);
				bus.setSource(from);
				bus.setDestination(to);
			}
		}

		else {
			logger.info("Fetching a buslist of any TravelClass");

			buses = busListDAO.getBusListAll(sbi);
			for (BusSearchListDto bus : buses) {
				System.out.println("In for" + from + "  " + to);
				bus.setSource(from);
				bus.setDestination(to);
			}
		}

		return buses;
	}

}
