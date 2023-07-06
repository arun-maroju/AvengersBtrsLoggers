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
    public void testGetAllUserPassengers_ValidUserId_ReturnsCorrectNumberOfPassengers() {
        // Arrange
        int userId = 1;
        List<UserPassengers> userPassengersList = new ArrayList<>();
        userPassengersList.add(new UserPassengers());
        userPassengersList.add(new UserPassengers());
        userPassengersList.add(new UserPassengers());
        when(userPassengersDAOMock.getAllUserPassengers(userId)).thenReturn(userPassengersList);

        // Act
        List<UserPassengers> result = userPassengersService.getAllUserPassengers(userId);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), userPassengersList.size());
        verify(userPassengersDAOMock, times(1)).getAllUserPassengers(userId);
    }



    @Test
    public void testGetAllUserPassengers_UserIdWithNoPassengers_ReturnsEmptyList() {
        // Arrange
        int userId = 1;
        when(userPassengersDAOMock.getAllUserPassengers(userId)).thenReturn(new ArrayList<>());
 
        // Act
        List<UserPassengers> result = userPassengersService.getAllUserPassengers(userId);

        // Assert
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
        verify(userPassengersDAOMock, times(1)).getAllUserPassengers(userId);
    }

    @Test
    public void testGetAllUserPassengers_MultipleUsers_ReturnsCorrectPassengersForUserId() {
        // Arrange
        int userId1 = 1;
        int userId2 = 2;
        List<UserPassengers> userPassengersList1 = new ArrayList<>();
        userPassengersList1.add(new UserPassengers());
        userPassengersList1.add(new UserPassengers());
        List<UserPassengers> userPassengersList2 = new ArrayList<>();
        userPassengersList2.add(new UserPassengers());
        when(userPassengersDAOMock.getAllUserPassengers(userId1)).thenReturn(userPassengersList1);
        when(userPassengersDAOMock.getAllUserPassengers(userId2)).thenReturn(userPassengersList2);

        // Act
        List<UserPassengers> result1 = userPassengersService.getAllUserPassengers(userId1);
        List<UserPassengers> result2 = userPassengersService.getAllUserPassengers(userId2);

        // Assert
        Assert.assertNotNull(result1);
        Assert.assertEquals(result1, userPassengersList1);
        Assert.assertNotNull(result2);
        Assert.assertEquals(result2, userPassengersList2);
        verify(userPassengersDAOMock, times(1)).getAllUserPassengers(userId1);
        verify(userPassengersDAOMock, times(1)).getAllUserPassengers(userId2);
    }
    
}
