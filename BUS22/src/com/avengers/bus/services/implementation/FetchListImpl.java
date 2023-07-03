package com.avengers.bus.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.ListsDAO;
import com.avengers.bus.models.dtoModels.AdminTicket;
import com.avengers.bus.models.dtoModels.ServicePassenger;
import com.avengers.bus.models.entityModels.Bus;
import com.avengers.bus.models.entityModels.Routes;
import com.avengers.bus.models.entityModels.Services;
import com.avengers.bus.models.entityModels.Ticket;
import com.avengers.bus.services.contracts.FetchList;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FetchListImpl implements FetchList {

	private static final Logger LOGGER = LoggerFactory.getLogger(FetchListImpl.class);

	private ListsDAO ldao;

	public FetchListImpl(ListsDAO ldao) {
		super();
		this.ldao = ldao;
	}

	@Override
	public String getServiceList(int page, int records) {
		int start = (records * page) - 99;
		int end = records * page;
		List<Services> services;
		LOGGER.info("Fetching service list");
		if (page == 0) {
			services = ldao.allServiceList();
		} else {
			services = ldao.serviceList(start, end);
		}
		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(services);
			LOGGER.debug(json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error fetching service list: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String getRouteList() {
		LOGGER.info("Fetching route list");
		List<Routes> routes = ldao.routeList();
		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(routes);
			LOGGER.debug(json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error fetching route list: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String getBusList() {
		LOGGER.info("Fetching bus list");
		List<Bus> buses = ldao.busList();
		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(buses);
			LOGGER.debug(json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error fetching bus list: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getTicketList() {
		LOGGER.info("Fetching ticket list");
		List<Ticket> tickets = ldao.ticketList();

		List<AdminTicket> adl = new ArrayList<>();

		for (Ticket t : tickets) {
			AdminTicket at = new AdminTicket(t.getBooking_id(), t.getPayment_id(), t.getUser_id(), t.getBooking_date(),
					t.getBooking_time(), t.getTrip_id(), t.getService_id(), t.getPayment_mode(), t.getTotal_fare(),
					t.getStatus(), t.getNo_of_seats_booked(), t.getSource(), t.getDestination(), t.getOrder_id(),
					t.getTravel_date(), t.getDeparture());
			adl.add(at);

		}

		LOGGER.debug("Tickets: {}", tickets);
		LOGGER.debug("AdminTickets: {}", adl);

		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(adl);
			LOGGER.debug(json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error fetching ticket list: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String getTicketPassengerList(String service_id) {
		LOGGER.info("Fetching ticket passenger list for service id: {}", service_id);
		System.out.println("In fetch Ticket Passenger method");
		List<ServicePassenger> passengers = ldao.servicePassengerList(Integer.parseInt(service_id));
		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(passengers);
			LOGGER.debug(json);
			return json;
		} catch (Exception e) {
			LOGGER.error("Error fetching ticket passenger list: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

}
