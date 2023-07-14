package com.avengers.bus.dao.implementation;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.models.entityModels.BusTypes;
import com.avengers.bus.models.entityModels.SeatsBookedForOneService;
import com.avengers.bus.models.entityModels.Stations;

public class BusSearchDaoImplTest {

	@Mock
	private EntityManager entityManager;

	@InjectMocks
	private BusSearchDAO busSearchDAO = new BusSearchDaoImpl();

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetBookedSeats() {
		// Mocking the required objects and data
		int serviceId = 1;
		List<SeatsBookedForOneService> seatsBookedList = new ArrayList<>();

		// Mocking the EntityManager behavior
		TypedQuery<SeatsBookedForOneService> query = Mockito.mock(TypedQuery.class);
		when(entityManager.createQuery(anyString(), any(Class.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(seatsBookedList);

		// Calling the method to be tested
		List<SeatsBookedForOneService> result = busSearchDAO.getBookedSeats(serviceId);

		// Verifying the method behavior and assertions
		verify(entityManager).createQuery(anyString(), any(Class.class));
		verify(query).getResultList();

		Assert.assertEquals(result, seatsBookedList);
	}

	@Test
	public void testGetAllBusTypes() {
		// Mocking the required objects and data
		List<BusTypes> busTypesList = new ArrayList<>();

		// Mocking the EntityManager behavior
		TypedQuery<BusTypes> query = Mockito.mock(TypedQuery.class);
		when(entityManager.createQuery(anyString(), any(Class.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(busTypesList);

		// Calling the method to be tested
		List<BusTypes> result = busSearchDAO.getAllBusTypes();

		// Verifying the method behavior and assertions
		verify(entityManager).createQuery(anyString(), any(Class.class));
		verify(query).getResultList();

		Assert.assertEquals(result, busTypesList);
	}

	@Test
	public void testGetAllStations() {
		// Mocking the required objects and data
		List<Stations> stationsList = new ArrayList<>();

		// Mocking the EntityManager behavior
		TypedQuery<Stations> query = Mockito.mock(TypedQuery.class);
		when(entityManager.createQuery(anyString(), any(Class.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(stationsList);

		// Calling the method to be tested
		List<Stations> result = busSearchDAO.getAllStations();

		// Verifying the method behavior and assertions
		verify(entityManager).createQuery(anyString(), any(Class.class));
		verify(query).getResultList();

		Assert.assertEquals(result, stationsList);
	}

	@Test
	public void testGetStation() {
		// Mocking the required objects and data
		String stationCode = "ABC";
		Stations station = new Stations();
		station.setStop_id(stationCode);
		List<Stations> stationsList = new ArrayList<>();
		stationsList.add(station);

		// Mocking the EntityManager behavior
		TypedQuery<Stations> query = Mockito.mock(TypedQuery.class);
		when(entityManager.createQuery(anyString(), any(Class.class))).thenReturn(query);
		when(query.setParameter(anyString(), any())).thenReturn(query);
		when(query.getResultList()).thenReturn(stationsList);

		// Calling the method to be tested
		Stations result = busSearchDAO.getStation(stationCode);

		// Verifying the method behavior and assertions
		verify(entityManager).createQuery(anyString(), any(Class.class));
		verify(query).setParameter(anyString(), any());
		verify(query).getResultList();

		Assert.assertEquals(result, station);
	}
}
