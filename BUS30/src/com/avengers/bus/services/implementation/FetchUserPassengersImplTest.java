//package com.avengers.bus.services.implementation;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.dao.contracts.UserPassengersDAO;
//import com.avengers.bus.models.entityModels.UserPassengers;
//import com.avengers.bus.models.entityModels.UserPassengersId;
//import com.avengers.bus.services.implementation.FetchUserPassengersImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class FetchUserPassengersImplTest {
//
//	@Mock
//	private UserPassengersDAO userPassengersDAO;
//
//	@InjectMocks
//	@Spy
//	private FetchUserPassengersImpl fetchUserPassengers;
//
//	@BeforeClass
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testGetPassengersList() throws Exception {
//		int userId = 1;
//
//		List<UserPassengers> userPassengers = new ArrayList<>();
//		// Add some test data
//		userPassengers.add(new UserPassengers());
//		userPassengers.add(new UserPassengers());
//
//		when(userPassengersDAO.getAllUserPassengers(userId)).thenReturn(userPassengers);
//
//		String expectedJson = new ObjectMapper().writeValueAsString(userPassengers);
//		String actualJson = fetchUserPassengers.getPassengersList(userId);
//
//		verify(userPassengersDAO, times(1)).getAllUserPassengers(userId);
//
//		// Assert the JSON response
//		assert expectedJson.equals(actualJson);
//	}
//
//	@Test
//	public void testAddeditedPassengers() {
//		UserPassengers userPass = new UserPassengers();
//
//		fetchUserPassengers.addeditedpassengers(userPass);
//
//		UserPassengersId expectedPassengerId = new UserPassengersId();
//
//		verify(userPassengersDAO, times(1)).updateUserPassengers(expectedPassengerId);
//	}
//
//	@Test
//	public void testDeleteUserPassengers() {
//		UserPassengers userPass = new UserPassengers();
//
//		fetchUserPassengers.deleteUserpassengers(userPass);
//
//		UserPassengersId expectedPassengerId = new UserPassengersId();
//
//		verify(userPassengersDAO, times(1)).deleteUserPassengers(expectedPassengerId);
//	}
//
//	@Test
//	public void testAddUserPassengers() {
//		UserPassengers userPass = new UserPassengers();
//
//		fetchUserPassengers.addUserpassengers(userPass);
//
//		verify(userPassengersDAO, times(1)).persist(userPass);
//	}
//}
