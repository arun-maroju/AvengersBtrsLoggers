package com.avengers.bus.services.implementation;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
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
import com.avengers.bus.services.implementation.FetchDetailsImpl;

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
        // Add more assertions to validate the JSON response
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

    // Helper methods to create sample data for testing

    private ServiceDetails createSampleServiceDetails(int serviceId) {
        // Create and return sample service details
        // Implement this method based on your requirements
        return new ServiceDetails();
    }

    private List<Stop> createSampleRouteDetails(int routeNum) {
        // Create and return sample route details
        // Implement this method based on your requirements
        return new ArrayList<>();
    }
    
    
}
