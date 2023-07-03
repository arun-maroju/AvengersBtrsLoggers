package com.avengers.bus.services.test;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.models.entityModels.Stations;
import com.avengers.bus.services.implementation.StationServiceImpl;

public class StationServiceImplTest {

    private StationServiceImpl stationService;
    private BusSearchDAO busSearchDAO;

    @BeforeMethod
    public void setUp() {
        // Create a mock for the BusSearchDAO
        busSearchDAO = mock(BusSearchDAO.class);
        stationService = new StationServiceImpl(busSearchDAO);
    }

    @Test
    public void testListAll() {
        // Arrange
        List<Stations> expectedStations = new ArrayList<>();
        Stations station1 = new Stations();
        station1.setStop_id("1");
        station1.setStop_name("Station 1");
        Stations station2 = new Stations();
        station2.setStop_id("2");
        station2.setStop_name("Station 2");
        expectedStations.add(station1);
        expectedStations.add(station2);

        // Mock the behavior of BusSearchDAO.getAllStations()
        when(busSearchDAO.getAllStations()).thenReturn(expectedStations);

        // Act
        List<Stations> result = stationService.listAll();

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), 2);

        Stations resultStation1 = result.get(0);
        Assert.assertEquals(resultStation1.getStop_id(), "1");
        Assert.assertEquals(resultStation1.getStop_name(), "Station 1");

        Stations resultStation2 = result.get(1);
        Assert.assertEquals(resultStation2.getStop_id(), "2");
        Assert.assertEquals(resultStation2.getStop_name(), "Station 2");

        // Verify that BusSearchDAO.getAllStations() was called once
        verify(busSearchDAO, times(1)).getAllStations();
    }
    
    @Test
    public void testListAllWithEmptyStations() {
        // Arrange
        List<Stations> expectedStations = new ArrayList<>();

        // Mock the behavior of BusSearchDAO.getAllStations()
        when(busSearchDAO.getAllStations()).thenReturn(expectedStations);

        // Act
        List<Stations> result = stationService.listAll();

        // Assert
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());

        // Verify that BusSearchDAO.getAllStations() was called once
        verify(busSearchDAO, times(1)).getAllStations();
    }

    

    @Test
    public void testListAllWithMultipleStations() {
        // Arrange
        List<Stations> expectedStations = new ArrayList<>();
        Stations station1 = new Stations();
        station1.setStop_id("1");
        station1.setStop_name("Station 1");
        Stations station2 = new Stations();
        station2.setStop_id("2");
        station2.setStop_name("Station 2");
        Stations station3 = new Stations();
        station3.setStop_id("3");
        station3.setStop_name("Station 3");
        expectedStations.add(station1);
        expectedStations.add(station2);
        expectedStations.add(station3);

        // Mock the behavior of BusSearchDAO.getAllStations()
        when(busSearchDAO.getAllStations()).thenReturn(expectedStations);

        // Act
        List<Stations> result = stationService.listAll();

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), 3);

        // Verify that BusSearchDAO.getAllStations() was called once
        verify(busSearchDAO, times(1)).getAllStations();
    }

    @Test
    public void testListAllWithException() {
        // Arrange
        // Mock the behavior of BusSearchDAO.getAllStations() to throw an exception
        when(busSearchDAO.getAllStations()).thenThrow(new RuntimeException("Error fetching stations."));

        // Act and Assert
        try {
            List<Stations> result = stationService.listAll();
            Assert.fail("Expected exception was not thrown.");
        } catch (RuntimeException e) {
            // Verify that BusSearchDAO.getAllStations() was called once
            verify(busSearchDAO, times(1)).getAllStations();
        }
    }
    
    

    @Test
    public void testListAllWithLargeNumberOfStations() {
        // Arrange
        int numStations = 1000; // Large number of stations
        List<Stations> expectedStations = new ArrayList<>();
        for (int i = 1; i <= numStations; i++) {
            Stations station = new Stations();
            station.setStop_id(String.valueOf(i));
            station.setStop_name("Station " + i);
            expectedStations.add(station);
        }

        // Mock the behavior of BusSearchDAO.getAllStations()
        when(busSearchDAO.getAllStations()).thenReturn(expectedStations);

        // Act
        List<Stations> result = stationService.listAll();

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), numStations);

        // Verify that BusSearchDAO.getAllStations() was called once
        verify(busSearchDAO, times(1)).getAllStations();
    }

    @Test
    public void testListAllWithNoStations() {
        // Arrange
        List<Stations> expectedStations = new ArrayList<>();

        // Mock the behavior of BusSearchDAO.getAllStations()
        when(busSearchDAO.getAllStations()).thenReturn(expectedStations);

        // Act
        List<Stations> result = stationService.listAll();

        // Assert
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());

        // Verify that BusSearchDAO.getAllStations() was called once
        verify(busSearchDAO, times(1)).getAllStations();
    }
}
