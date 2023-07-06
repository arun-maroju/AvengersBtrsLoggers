package com.avengers.bus.services.implementation;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.ListsDAO;
import com.avengers.bus.models.dtoModels.ServicePassenger;
import com.avengers.bus.models.entityModels.Bus;
import com.avengers.bus.models.entityModels.Routes;
import com.avengers.bus.models.entityModels.Services;
import com.avengers.bus.models.entityModels.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchListImplTest {

	@Mock
	private ListsDAO listsDAO;

	@InjectMocks
	private FetchListImpl fetchListService;

	private ObjectMapper objectMapper;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		objectMapper = new ObjectMapper();

	}

	@Test
	void testGetServiceList() throws Exception {
		// Arrange
		int page = 1;
		int records = 100;
		int start = (records * page) - 99;
		int end = records * page;

		List<Services> services = new ArrayList<>();
		// Add services to the list

		when(listsDAO.serviceList(start, end)).thenReturn(services);

		// Act
		String result = fetchListService.getServiceList(page, records);

		// Assert
		verify(listsDAO, times(1)).serviceList(start, end);
		// Replace "Expected JSON string" with the actual expected JSON string
		String expectedJson = "[]";
		assertEquals(expectedJson, result);
	}

	@Test
	void testGetServiceListFirstPage() throws Exception {
		// Arrange
		int page = 0;

		List<Services> services = new ArrayList<>();
		// Add services to the list

		when(listsDAO.allServiceList()).thenReturn(services);

		// Act
		String result = fetchListService.getServiceList(page, 0);

		// Assert
		verify(listsDAO, times(1)).allServiceList();
		String expectedJson = "[]";
		assertEquals(expectedJson, result);
	}

	@Test
	public void testGetRouteList() {
		// Arrange
		List<Routes> routes = createSampleRoutes();
		when(listsDAO.routeList()).thenReturn(routes);

		// Act
		String routeListJson = fetchListService.getRouteList();

		// Assert
		Assert.assertNotNull(routeListJson);
		// Add more assertions to validate the JSON response
	}

	@Test
	public void testGetBusList() {
		// Arrange
		List<Bus> buses = createSampleBuses();
		when(listsDAO.busList()).thenReturn(buses);

		// Act
		String busListJson = fetchListService.getBusList();

		// Assert
		Assert.assertNotNull(busListJson);
		// Add more assertions to validate the JSON response
	}

	@Test
	void testGetTicketList() throws Exception {
		// Arrange
		Ticket ticket1 = new Ticket();
		ticket1.setBooking_id("1");
		ticket1.setPayment_id("123");
		ticket1.setUser_id(9);
		ticket1.setBooking_date(Date.valueOf("2023-07-06"));
		ticket1.setBooking_time(Time.valueOf("09:30:00"));
		ticket1.setTrip_id(10);
		ticket1.setPayment_mode("online");
		ticket1.setTotal_fare(1000);
		ticket1.setStatus("confirmed");
		ticket1.setNo_of_seats_booked(2);
		ticket1.setSource("VSK");
		ticket1.setDestination("");
		ticket1.setOrder_id("abc1234");
		ticket1.setTravel_date(Date.valueOf("2023-07-06"));
		ticket1.setDeparture(Time.valueOf("12:30:00"));

		Ticket ticket2 = new Ticket();
		ticket2.setBooking_id("1");
		ticket2.setPayment_id("123");
		ticket2.setUser_id(9);
		ticket2.setBooking_date(Date.valueOf("2023-07-06"));
		ticket2.setBooking_time(Time.valueOf("09:30:00"));
		ticket2.setTrip_id(10);
		ticket2.setPayment_mode("online");
		ticket2.setTotal_fare(1000);
		ticket2.setStatus("confirmed");
		ticket2.setNo_of_seats_booked(2);
		ticket2.setSource("VSK");
		ticket2.setDestination("");
		ticket2.setOrder_id("abc1234");
		ticket2.setTravel_date(Date.valueOf("2023-07-06"));
		ticket2.setDeparture(Time.valueOf("12:30:00"));

		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket1);
		tickets.add(ticket2);

		when(listsDAO.ticketList()).thenReturn(tickets);

		// Act
		String result = fetchListService.getTicketList();

		verify(listsDAO, times(1)).ticketList();
		String expectedJson = "[{\"booking_id\":\"1\",\"payment_id\":\"123\",\"user_id\":9,\"booking_date\":\"2023-07-06\",\"booking_time\":\"09:30:00\",\"trip_id\":10,\"service_id\":0,\"payment_mode\":\"online\",\"total_fare\":1000.0,\"status\":\"confirmed\",\"no_of_seats_booked\":2,\"source\":\"VSK\",\"destination\":\"\",\"order_id\":\"abc1234\",\"travel_date\":\"2023-07-06\",\"departure\":\"12:30:00\"},{\"booking_id\":\"1\",\"payment_id\":\"123\",\"user_id\":9,\"booking_date\":\"2023-07-06\",\"booking_time\":\"09:30:00\",\"trip_id\":10,\"service_id\":0,\"payment_mode\":\"online\",\"total_fare\":1000.0,\"status\":\"confirmed\",\"no_of_seats_booked\":2,\"source\":\"VSK\",\"destination\":\"\",\"order_id\":\"abc1234\",\"travel_date\":\"2023-07-06\",\"departure\":\"12:30:00\"}]";
		List<Ticket> expectedTickets = objectMapper.readValue(expectedJson,
				objectMapper.getTypeFactory().constructCollectionType(List.class, Ticket.class));
		List<Ticket> actualTickets = objectMapper.readValue(result,
				objectMapper.getTypeFactory().constructCollectionType(List.class, Ticket.class));

		assertEquals(actualTickets, expectedTickets);

	}

	@Test
	public void testGetTicketPassengerList() {
		// Arrange
		List<ServicePassenger> passengers = createSampleServicePassengers();
		int serviceId = 123;
		when(listsDAO.servicePassengerList(serviceId)).thenReturn(passengers);

		// Act
		String passengerListJson = fetchListService.getTicketPassengerList(Integer.toString(serviceId));

		// Assert
		Assert.assertNotNull(passengerListJson);
		// Add more assertions to validate the JSON response
	}

	// Helper methods to create sample data for testing

	private List<Services> createSampleServices() {
		// Create and return a list of sample services
		// Implement this method based on your requirements
		return new ArrayList<>();
	}

	private List<Routes> createSampleRoutes() {
		// Create and return a list of sample routes
		// Implement this method based on your requirements
		return new ArrayList<>();
	}

	private List<Bus> createSampleBuses() {
		// Create and return a list of sample buses
		// Implement this method based on your requirements
		return new ArrayList<>();
	}

	private List<ServicePassenger> createSampleServicePassengers() {
		// Create and return a list of sample service passengers
		// Implement this method based on your requirements
		return new ArrayList<>();
	}
}
