package com.avengers.bus.services.test;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.UserPassengersDAO;
import com.avengers.bus.models.entityModels.UserPassengers;
import com.avengers.bus.services.implementation.UserPassengersServiceImpl;

public class UserPassengersServiceImplTest {

    @Mock
    private UserPassengersDAO userPassengersDAOMock;

    @InjectMocks
    private UserPassengersServiceImpl userPassengersService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUserPassengers_ValidUserId_ReturnsListOfUserPassengers() {
        // Arrange
        int userId = 1;
        List<UserPassengers> userPassengersList = new ArrayList<>();
        userPassengersList.add(new UserPassengers());
        userPassengersList.add(new UserPassengers());
        when(userPassengersDAOMock.getAllUserPassengers(userId)).thenReturn(userPassengersList);

        // Act
        List<UserPassengers> result = userPassengersService.getAllUserPassengers(userId);

        // Assert
        Assert.assertEquals(result, userPassengersList);
        verify(userPassengersDAOMock, times(1)).getAllUserPassengers(userId);
    }

    @Test
    public void testGetAllUserPassengers_InvalidUserId_ReturnsEmptyList() {
        // Arrange
        int userId = -1;
        when(userPassengersDAOMock.getAllUserPassengers(userId)).thenReturn(new ArrayList<>());

        // Act
        List<UserPassengers> result = userPassengersService.getAllUserPassengers(userId);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
        verify(userPassengersDAOMock, times(1)).getAllUserPassengers(userId);
    }

    @Test
    public void testGetAllUserPassengers_UserPassengersDAOReturnsNull_ReturnsEmptyList() {
        // Arrange
        int userId = 1;
        when(userPassengersDAOMock.getAllUserPassengers(userId)).thenReturn(null);

        // Act
        List<UserPassengers> result = userPassengersService.getAllUserPassengers(userId);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
        verify(userPassengersDAOMock, times(1)).getAllUserPassengers(userId);
    }
}
