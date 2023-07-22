//package com.avengers.bus.services.implementation;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.slf4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.dao.contracts.UserCountsDAO;
//import com.avengers.bus.models.viewModels.UserCounts;
//import com.avengers.bus.services.implementation.FetchUserCountsImpl;
//
//public class FetchUserCountsImplTest {
//
//	@Mock
//	private UserCountsDAO userCountsDAO;
//
//	@Mock
//	private Logger logger;
//
//	@InjectMocks
//	private FetchUserCountsImpl fetchUserCounts;
//
//	@BeforeClass
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testGetUserBookedCount() {
//		int userId = 1;
//		int expectedCount = 19;
//
//		when(userCountsDAO.bookedCount(userId)).thenReturn(expectedCount);
//
//		int actualCount = fetchUserCounts.getUserBookedCount(userId);
//
//		verify(logger).info("Fetching User Booked Count for user with ID: {}", userId);
//		verify(userCountsDAO).bookedCount(userId);
//
//		Assert.assertEquals(actualCount, expectedCount);
//	}
//
//	@Test
//	public void testGetUserTravelCount() {
//		int userId = 1;
//		int expectedCount = 11;
//
//		when(userCountsDAO.travelCount(userId)).thenReturn(expectedCount);
//
//		int actualCount = fetchUserCounts.getUserTravelCount(userId);
//
//		verify(logger).info("Fetching User Travel Count for user with ID: {}", userId);
//		verify(userCountsDAO).travelCount(userId);
//
//		Assert.assertEquals(actualCount, expectedCount);
//	}
//
//	@Test
//	public void testGetUserWallet() {
//		int userId = 1;
//		double expectedWallet = 0.0;
//
//		when(userCountsDAO.getWallet(userId)).thenReturn(expectedWallet);
//
//		double actualWallet = fetchUserCounts.getUserwallet(userId);
//
//		verify(logger).info("Fetching User Wallet for user with ID: {}", userId);
//		verify(userCountsDAO).getWallet(userId);
//
//		Assert.assertEquals(actualWallet, expectedWallet);
//	}
//
//	@Test
//	public void testGetUsername() {
//		int userId = 1;
//		String expectedUsername = "Imran Streak";
//
//		when(userCountsDAO.getName(userId)).thenReturn(expectedUsername);
//
//		String actualUsername = fetchUserCounts.getUsername(userId);
//
//		verify(logger).info("Fetching Username for user with ID: {}", userId);
//		verify(userCountsDAO).getName(userId);
//
//		Assert.assertEquals(actualUsername, expectedUsername);
//	}
//
//	@Test
//	public void testGetUserCounts() {
//		int userId = 1;
//		int expectedBookedCount = 19;
//		int expectedTravelCount = 11;
//		double expectedWallet = 0.0;
//		String expectedUsername = "Imran Streak";
//		int expectedFutureTravelCount = 7;
//
//		when(userCountsDAO.bookedCount(userId)).thenReturn(expectedBookedCount);
//		when(userCountsDAO.travelCount(userId)).thenReturn(expectedTravelCount);
//		when(userCountsDAO.getWallet(userId)).thenReturn(expectedWallet);
//		when(userCountsDAO.getName(userId)).thenReturn(expectedUsername);
//		when(userCountsDAO.userFutureTravelCount(userId)).thenReturn(expectedFutureTravelCount);
//
//		UserCounts userCounts = fetchUserCounts.getUserCounts(userId);
//
//		verify(logger).info("Fetching User Counts for user with ID: {}", userId);
//		verify(userCountsDAO).bookedCount(userId);
//		verify(userCountsDAO).travelCount(userId);
//		verify(userCountsDAO).getWallet(userId);
//		verify(userCountsDAO).getName(userId);
//		verify(userCountsDAO).userFutureTravelCount(userId);
//
//		Assert.assertEquals(userCounts.getBookedCount(), expectedBookedCount);
//		Assert.assertEquals(userCounts.getTravelCount(), expectedTravelCount);
//		Assert.assertEquals(userCounts.getWallet(), expectedWallet);
//		Assert.assertEquals(userCounts.getName(), expectedUsername);
//		Assert.assertEquals(userCounts.getFutureTravelCount(), expectedFutureTravelCount);
//	}
//
//	@Test
//	public void testGetUserFutureTravelCount() {
//		int userId = 1;
//		int expectedCount = 7;
//
//		when(userCountsDAO.userFutureTravelCount(userId)).thenReturn(expectedCount);
//
//		int actualCount = fetchUserCounts.getUserFutureTravelCount(userId);
//
//		verify(logger).info("Fetching User Future Travel Count for user with ID: {}", userId);
//		verify(userCountsDAO).userFutureTravelCount(userId);
//
//		Assert.assertEquals(actualCount, expectedCount);
//	}
//}
