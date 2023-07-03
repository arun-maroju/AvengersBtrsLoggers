package com.avengers.bus.services.test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.BusListDAO;
import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.inputModels.SearchBusInput;
import com.avengers.bus.services.implementation.BusListServiceImpl;

public class BusListServiceImplTest {
    @Mock
    private BusListDAO busListDAOMock;

    @InjectMocks
    private BusListServiceImpl busListService;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBusList_WithTravelClass() {
        // Arrange
        SearchBusInput input = new SearchBusInput();
        input.setFssId("VSKP");
        input.setTravelClass(0);
        input.setTssId("HYD");
        input.setDate(null);
        List<BusSearchListDto> expectedBuses = new ArrayList<>();
        when(busListDAOMock.getBusList(input)).thenReturn(expectedBuses);

        // Act
        List<BusSearchListDto> result = busListService.getBusList(input);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(result, expectedBuses);
        verify(busListDAOMock,times(1)).getBusList(input);
    }

    @Test
    public void testGetBusList_WithoutTravelClass() {
        // Arrange
        SearchBusInput input = new SearchBusInput();
        List<BusSearchListDto> expectedBuses = new ArrayList<>();
        when(busListDAOMock.getBusListAll(input)).thenReturn(expectedBuses);

        // Act
        List<BusSearchListDto> result = busListService.getBusList(input);

        // Assert
        assertNotNull(result);
        assertEquals(result, expectedBuses);
//        verify(loggerMock).info("Fetching all buslist based on TravelClass");
//        verify(loggerMock).info("Fetching a buslist of any TravelClass");
        verify(busListDAOMock,times(1)).getBusListAll(input);
    }
    
    @Test
    public void testGetBusList_WithNullInput() {
        // Arrange
        SearchBusInput input = null;

        // Act and Assert
        NullPointerException exception = Assert.expectThrows(NullPointerException.class,
                () -> busListService.getBusList(input));
        Assert.assertEquals(exception.getMessage(), "Cannot invoke \"com.avengers.bus.models.inputModels.SearchBusInput.getTravelClass()\" because \"sbi\" is null");
        verifyZeroInteractions(busListDAOMock);
    }


    
    
    @Test
    public void testGetBusList_EmptyResult() {
        // Arrange
        SearchBusInput input = new SearchBusInput();
        List<BusSearchListDto> expectedBuses = new ArrayList<>();
        when(busListDAOMock.getBusListAll(input)).thenReturn(expectedBuses);

        // Act
        List<BusSearchListDto> result = busListService.getBusList(input);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(result, expectedBuses);
        verify(busListDAOMock,times(1)).getBusListAll(input);
    }

}
