package com.avengers.bus.services.implementation;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.models.entityModels.BusTypes;

public class BusTypeServiceImplTest {
	@Mock
	private BusSearchDAO busSearchDAO;

	@InjectMocks
	private BusTypeServiceImpl busTypeService;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListAll() {
		// Mock the necessary objects
		List<BusTypes> mockBusTypesList = new ArrayList<>();
		// Add some mock BusTypes objects to the list

		when(busSearchDAO.getAllBusTypes()).thenReturn(mockBusTypesList);

		// Call the method to be tested
		List<BusTypes> result = busTypeService.listAll();

		// Verify the interactions and assertions
		// verify(busSearchDAO).getAllBusTypes();
		Assert.assertEquals(result, mockBusTypesList);
	}
}
