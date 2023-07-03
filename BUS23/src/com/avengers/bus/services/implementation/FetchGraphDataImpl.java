package com.avengers.bus.services.implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.GraphDAO;
import com.avengers.bus.models.dtoModels.MonthlyCollection;
import com.avengers.bus.models.dtoModels.RouteCollection;
import com.avengers.bus.models.dtoModels.TripCollection;
import com.avengers.bus.services.contracts.FetchGraphData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FetchGraphDataImpl implements FetchGraphData {
	private static final Logger logger = LoggerFactory.getLogger(FetchGraphDataImpl.class);
	private GraphDAO graphdao;

	public FetchGraphDataImpl(GraphDAO graphdao) {
		this.graphdao = graphdao;
	}

	@Override
	public String getRouteCollection() {
		List<RouteCollection> routeCollection = graphdao.routeCollection();
		ObjectMapper om = new ObjectMapper();
		logger.info("Fetching Route Collection");

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(routeCollection);
			System.out.println(json);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error retrieving RouteCollection: {}", e.getMessage());

			return null;
		}

	}

	@Override
	public String getTripCollection() {
		List<TripCollection> tripCollection = graphdao.tripCollection();
		ObjectMapper om = new ObjectMapper();
		logger.info("Fetching Trip Collection");

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(tripCollection);
			System.out.println(json);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error retrieving Trip Collection: {}", e.getMessage());

			return null;
		}
	}

	@Override
	public String getMonthlyCollection() {
		logger.info("Fetching monthly collection");
		List<MonthlyCollection> monthlyCollection = graphdao.monthlyCollection();
		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(monthlyCollection);
			System.out.println(json);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error retrieving Monthly Collection: {}", e.getMessage());
			return null;
		}
	}
}
