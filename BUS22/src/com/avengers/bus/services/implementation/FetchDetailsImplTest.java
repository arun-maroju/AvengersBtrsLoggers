package com.avengers.bus.services.implementation;

import static org.mockito.Mockito.when;

import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.DetailsDAO;
import com.avengers.bus.models.dtoModels.ServiceDetails;
import com.avengers.bus.models.entityModels.Stop;

public class FetchDetailsImplTest {

	@Mock
	private DetailsDAO detailsDAO;

	@InjectMocks
	private FetchDetailsImpl fetchDetailsService;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetServiceDetails() {
		// Arrange
		int serviceId = 1; // Change this to the desired service ID for testing
		ServiceDetails serviceDetails = createSampleServiceDetails(serviceId);

		when(detailsDAO.serviceDetails(serviceId)).thenReturn(serviceDetails);

		// Act
		String serviceDetailsJson = fetchDetailsService.getServiceDetails(String.valueOf(serviceId));

		// Assert
		Assert.assertNotNull(serviceDetailsJson);

	}

	private ServiceDetails createSampleServiceDetails(int serviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testGetRouteDetails() {
		// Arrange
		int routeNum = 1; // Change this to the desired route number for testing
		List<Stop> routeDetails = createSampleRouteDetails(routeNum);
		when(detailsDAO.routeDetails(routeNum)).thenReturn(routeDetails);

		// Act
		String routeDetailsJson = fetchDetailsService.getRouteDetails(String.valueOf(routeNum));

		// Assert
		Assert.assertNotNull(routeDetailsJson);
		// Add more assertions to validate the JSON response
	}

	private List<Stop> createSampleRouteDetails(int routeNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
