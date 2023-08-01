//package com.avengers.bus.services.implementation;
//
//import static org.mockito.Mockito.*;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.dao.contracts.CountsDAO;
//import com.avengers.bus.services.implementation.FetchCountImpl;
//
//public class FetchCountImplTest {
//
//    @Mock
//    private CountsDAO countsDAO;
//
//    @InjectMocks
//    private FetchCountImpl fetchCountService;
//
//    @BeforeClass
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testGetBusCount() {
//        // Arrange
//        int expectedBusCount = 10;
//        when(countsDAO.busCount()).thenReturn(expectedBusCount);
//
//        // Act
//        int actualBusCount = fetchCountService.getBusCount();
//
//        // Assert
//        Assert.assertEquals(actualBusCount, expectedBusCount);
//    }
//
//    @Test
//    public void testGetServiceCount() {
//        // Arrange
//        int expectedServiceCount = 5;
//        when(countsDAO.serviceCount()).thenReturn(expectedServiceCount);
//
//        // Act
//        int actualServiceCount = fetchCountService.getServiceCount();
//
//        // Assert
//        Assert.assertEquals(actualServiceCount, expectedServiceCount);
//    }
//
//    @Test
//    public void testGetCollection() {
//        // Arrange
//        int expectedCollection = 5000;
//        when(countsDAO.totalPayments()).thenReturn(expectedCollection);
//
//        // Act
//        int actualCollection = fetchCountService.getCollection();
//
//        // Assert
//        Assert.assertEquals(actualCollection, expectedCollection);
//    }
//
//    @Test
//    public void testGetUserCount() {
//        // Arrange
//        int expectedUserCount = 100;
//        when(countsDAO.userCount()).thenReturn(expectedUserCount);
//
//        // Act
//        int actualUserCount = fetchCountService.getUserCount();
//
//        // Assert
//        Assert.assertEquals(actualUserCount, expectedUserCount);
//    }
//
//    @Test
//    public void testGetRouteCount() {
//        // Arrange
//        int expectedRouteCount = 8;
//        when(countsDAO.routeCount()).thenReturn(expectedRouteCount);
//
//        // Act
//        int actualRouteCount = fetchCountService.getRouteCount();
//
//        // Assert
//        Assert.assertEquals(actualRouteCount, expectedRouteCount);
//    }
//
//    @Test
//    public void testGetTripCount() {
//        // Arrange
//        int expectedTripCount = 20;
//        when(countsDAO.tripCount()).thenReturn(expectedTripCount);
//
//        // Act
//        int actualTripCount = fetchCountService.getTripCount();
//
//        // Assert
//        Assert.assertEquals(actualTripCount, expectedTripCount);
//    }
//
//    @Test
//    public void testGetPastTicketCollection() {
//        // Arrange
//        int expectedPastTicketCollection = 3000;
//        when(countsDAO.pastTicketCollection()).thenReturn(expectedPastTicketCollection);
//
//        // Act
//        int actualPastTicketCollection = fetchCountService.getPastTicketCollection();
//
//        // Assert
//        Assert.assertEquals(actualPastTicketCollection, expectedPastTicketCollection);
//    }
//
//    @Test
//    public void testGetFutureTicketCollection() {
//        // Arrange
//        int expectedFutureTicketCollection = 2000;
//        when(countsDAO.futureTicketCollection()).thenReturn(expectedFutureTicketCollection);
//
//        // Act
//        int actualFutureTicketCollection = fetchCountService.getFutureTicketCollection();
//
//        // Assert
//        Assert.assertEquals(actualFutureTicketCollection, expectedFutureTicketCollection);
//    }
//
//    // Add more test methods for other methods in FetchCountImpl class
//
//}
