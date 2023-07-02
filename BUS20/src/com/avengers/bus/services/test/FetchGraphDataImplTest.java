package com.avengers.bus.services.test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.GraphDAO;
import com.avengers.bus.models.dtoModels.MonthlyCollection;
import com.avengers.bus.models.dtoModels.RouteCollection;
import com.avengers.bus.models.dtoModels.TripCollection;
import com.avengers.bus.services.implementation.FetchGraphDataImpl;

public class FetchGraphDataImplTest {

    @Mock
    private GraphDAO graphDAO;

    @InjectMocks
    private FetchGraphDataImpl fetchGraphDataService;

    @BeforeClass
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetRouteCollection() {
        // Arrange
        List<RouteCollection> routeCollection = createSampleRouteCollection();
        when(graphDAO.routeCollection()).thenReturn(routeCollection);

        // Act
        String routeCollectionJson = fetchGraphDataService.getRouteCollection();

        // Assert
        Assert.assertNotNull(routeCollectionJson);
        // Add more assertions to validate the JSON response
    }

    @Test
    public void testGetTripCollection() {
        // Arrange
        List<TripCollection> tripCollection = createSampleTripCollection();
        when(graphDAO.tripCollection()).thenReturn(tripCollection);

        // Act
        String tripCollectionJson = fetchGraphDataService.getTripCollection();

        // Assert
        Assert.assertNotNull(tripCollectionJson);
        // Add more assertions to validate the JSON response
    }

    @Test
    public void testGetMonthlyCollection() {
        // Arrange
        List<MonthlyCollection> monthlyCollection = createSampleMonthlyCollection();
        when(graphDAO.monthlyCollection()).thenReturn(monthlyCollection);

        // Act
        String monthlyCollectionJson = fetchGraphDataService.getMonthlyCollection();

        // Assert
        Assert.assertNotNull(monthlyCollectionJson);
        // Add more assertions to validate the JSON response
    }

    // Helper methods to create sample data for testing

    private List<RouteCollection> createSampleRouteCollection() {
        // Create and return a list of sample route collection
        // Implement this method based on your requirements
        return new ArrayList<>();
    }

    private List<TripCollection> createSampleTripCollection() {
        // Create and return a list of sample trip collection
        // Implement this method based on your requirements
        return new ArrayList<>();
    }

    private List<MonthlyCollection> createSampleMonthlyCollection() {
        // Create and return a list of sample monthly collection
        // Implement this method based on your requirements
        return new ArrayList<>();
    }
}

