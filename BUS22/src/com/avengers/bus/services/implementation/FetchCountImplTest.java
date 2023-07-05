package com.avengers.bus.services.implementation;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.CountsDAO;

public class FetchCountImplTest {
	@Mock
	private CountsDAO cdao;

	@InjectMocks
	private FetchCountImpl fetchCountImpl;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetBusCount() {
		int expectedCount = 10;
		when(cdao.busCount()).thenReturn(expectedCount);

		int actualCount = fetchCountImpl.getBusCount();

		assertEquals(actualCount, expectedCount);

	}

	@Test
	public void testGetServiceCount() {
		int expectedCount = 5;
		when(cdao.serviceCount()).thenReturn(expectedCount);

		int actualCount = fetchCountImpl.getServiceCount();

		assertEquals(actualCount, expectedCount);

	}

	@Test
	public void testGetCollection() {
		int expectedCollection = 1000;
		when(cdao.totalPayments()).thenReturn(expectedCollection);

		int actualCollection = fetchCountImpl.getCollection();

		assertEquals(actualCollection, expectedCollection);

	}

	@Test
	public void testGetUserCount() {
		int expectedCount = 50;
		when(cdao.userCount()).thenReturn(expectedCount);

		int actualCount = fetchCountImpl.getUserCount();

		assertEquals(actualCount, expectedCount);

	}

	@Test
	public void testGetRouteCount() {
		int expectedCount = 20;
		when(cdao.routeCount()).thenReturn(expectedCount);

		int actualCount = fetchCountImpl.getRouteCount();

		assertEquals(actualCount, expectedCount);

	}

	@Test
	public void testGetTripCount() {
		int expectedCount = 15;
		when(cdao.tripCount()).thenReturn(expectedCount);

		int actualCount = fetchCountImpl.getTripCount();

		assertEquals(actualCount, expectedCount);

	}

	@Test
	public void testGetPastTicketCollection() {
		int expectedCollection = 500;
		when(cdao.pastTicketCollection()).thenReturn(expectedCollection);

		int actualCollection = fetchCountImpl.getPastTicketCollection();

		assertEquals(actualCollection, expectedCollection);

	}

	@Test
	public void testGetFutureTicketCollection() {
		int expectedCollection = 700;
		when(cdao.futureTicketCollection()).thenReturn(expectedCollection);

		int actualCollection = fetchCountImpl.getFutureTicketCollection();

		assertEquals(actualCollection, expectedCollection);

	}
}
