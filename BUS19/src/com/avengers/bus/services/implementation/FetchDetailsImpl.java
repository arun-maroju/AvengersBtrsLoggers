package com.avengers.bus.services.implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avengers.bus.dao.contracts.DetailsDAO;
import com.avengers.bus.models.dtoModels.ServiceDetails;
import com.avengers.bus.models.entityModels.Stop;
import com.avengers.bus.services.contracts.FetchDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
@Component
public class FetchDetailsImpl implements FetchDetails {
	private static final Logger logger = LoggerFactory.getLogger(FetchDetailsImpl.class);

	private DetailsDAO ddao;

	public FetchDetailsImpl(DetailsDAO ddao) {
		this.ddao = ddao;
	}

	@Override
	public String getServiceDetails(String service) {

		int service_id = Integer.parseInt(service);
		ServiceDetails sd = ddao.serviceDetails(service_id);
		logger.info("Fetching service details:{}", sd);

		System.out.println(sd);
		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(sd);
			System.out.println(json);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error retrieving service details: {}", e.getMessage());
			return null;
		}
	}

	@Override
	public String getRouteDetails(String route) {
		int routeNum = Integer.parseInt(route);
		List<Stop> sd = ddao.routeDetails(routeNum);
		logger.info("Fetching Route details:{}", sd);
		System.out.println(sd);
		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(sd);
			System.out.println(json);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error retrieving Route details: {}", e.getMessage());
			return null;
		}
	}

}
