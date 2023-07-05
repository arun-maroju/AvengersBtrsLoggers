package com.avengers.bus.services.implementation;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.ListsDAO;
import com.avengers.bus.models.dtoModels.AdminTicket;
import com.avengers.bus.models.dtoModels.ServicePassenger;
import com.avengers.bus.models.entityModels.Bus;
import com.avengers.bus.models.entityModels.Routes;
import com.avengers.bus.models.entityModels.Services;
import com.avengers.bus.models.entityModels.Ticket;

public class FetchListImplTest {
	@Mock
	private ListsDAO ldao;

	@InjectMocks
	private FetchListImpl fetchListImpl;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetServiceList() {
		int page = 1;
		int records = 10;
		int start = (records * page) - 99;
		int end = records * page;

		List<Services> expectedServices = new ArrayList<>();
		expectedServices.add(new Services());
		expectedServices.add(new Services());

		try {
			when(ldao.allServiceList()).thenReturn(expectedServices);

			String expectedJson = "[{}, {}]";

			String actualJson = fetchListImpl.getServiceList(page, records);

			assertEquals(actualJson, expectedJson);
			verify(ldao).allServiceList();
		} catch (Exception e) {
			fail("Exception should not be thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetServiceList_WhenExceptionThrown() {
		int page = 2;
		int records = 10;
		int start = (records * page) - 99;
		int end = records * page;

		when(ldao.serviceList(start, end)).thenThrow(new RuntimeException("Simulated exception"));

		try {
			String actualJson = fetchListImpl.getServiceList(page, records);

			assertNull(actualJson);
			verify(ldao).serviceList(start, end);
		} catch (Exception e) {
			fail("Exception should not be thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetRouteList() {
		List<Routes> expectedRoutes = new ArrayList<>();
		expectedRoutes.add(new Routes());
		expectedRoutes.add(new Routes());

		try {
			when(ldao.routeList()).thenReturn(expectedRoutes);

			String expectedJson = "[{}, {}]";

			String actualJson = fetchListImpl.getRouteList();

			assertEquals(actualJson, expectedJson);
			verify(ldao).routeList();
		} catch (Exception e) {
			fail("Exception should not be thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetRouteList_WhenExceptionThrown() {
		when(ldao.routeList()).thenThrow(new RuntimeException("Simulated exception"));

		try {
			String actualJson = fetchListImpl.getRouteList();

			assertNull(actualJson);
			verify(ldao).routeList();
		} catch (Exception e) {
			fail("Exception should not be thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetBusList() {
		List<Bus> expectedBuses = new ArrayList<>();
		expectedBuses.add(new Bus());
		expectedBuses.add(new Bus());

		try {
			when(ldao.busList()).thenReturn(expectedBuses);

			String expectedJson = "[{}, {}]";

			String actualJson = fetchListImpl.getBusList();

			assertEquals(actualJson, expectedJson);
			verify(ldao).busList();
		} catch (Exception e) {
			fail("Exception should not be thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetBusList_WhenExceptionThrown() {
		when(ldao.busList()).thenThrow(new RuntimeException("Simulated exception"));

		try {
			String actualJson = fetchListImpl.getBusList();

			assertNull(actualJson);
			verify(ldao).busList();
		} catch (Exception e) {
			fail("Exception should not be thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetTicketList() {
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(new Ticket());
		tickets.add(new Ticket());

		List<AdminTicket> expectedAdminTickets = new ArrayList<>();
		// expectedAdminTickets.add(new AdminTicket(null, null, 0,"2023-06-07", null, 0, 0, null, 0, null, 0, null,
		// null, null, null, null));
		expectedAdminTickets
				.add(new AdminTicket(null, null, 0, null, null, 0, 0, null, 0, null, 0, null, null, null, null, null));

		try {
			when(ldao.ticketList()).thenReturn(tickets);

			String expectedJson = "[{}, {}]";

			String actualJson = fetchListImpl.getTicketList();

			assertEquals(actualJson, expectedJson);
			verify(ldao).ticketList();
		} catch (Exception e) {
			fail("Exception should not be thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetTicketList_WhenExceptionThrown() {
		when(ldao.ticketList()).thenThrow(new RuntimeException("Simulated exception"));

		try {
			String actualJson = fetchListImpl.getTicketList();

			assertNull(actualJson);
			verify(ldao).ticketList();
		} catch (Exception e) {
			fail("Exception should not be thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetTicketPassengerList() {
		int serviceId = 123;
		List<ServicePassenger> expectedPassengers = new ArrayList<>();
		expectedPassengers.add(new ServicePassenger());
		expectedPassengers.add(new ServicePassenger());

		try {
			when(ldao.servicePassengerList(serviceId)).thenReturn(expectedPassengers);

			String expectedJson = "[{}, {}]";

			String actualJson = fetchListImpl.getTicketPassengerList(String.valueOf(serviceId));

			assertEquals(actualJson, expectedJson);
			verify(ldao).servicePassengerList(serviceId);
		} catch (Exception e) {
			fail("Exception should not be thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetTicketPassengerList_WhenExceptionThrown() {
		int serviceId = 123;
		when(ldao.servicePassengerList(serviceId)).thenThrow(new RuntimeException("Simulated exception"));

		try {
			String actualJson = fetchListImpl.getTicketPassengerList(String.valueOf(serviceId));

			assertNull(actualJson);
			verify(ldao).servicePassengerList(serviceId);
		} catch (Exception e) {
			fail("Exception should not be thrown: " + e.getMessage());
		}
	}
}
