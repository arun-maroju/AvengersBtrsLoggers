package com.avengers.bus.services.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.UserPassengersDAO;
import com.avengers.bus.models.entityModels.UserPassengers;
import com.avengers.bus.models.entityModels.UserPassengersId;
import com.avengers.bus.services.implementation.FetchUserPassengersImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchUserPassengersImplTest {
	@Mock
	private UserPassengersDAO userPassengersDAO;

	@Mock
	private ObjectMapper objectMapper;

	@InjectMocks
	private FetchUserPassengersImpl fetchUserPassengers;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		objectMapper = new ObjectMapper();
	}

	@Test
	public void testGetPassengersList() throws Exception {
		int userId = 1;
		List<UserPassengers> userPassengersList = new ArrayList<>();
		userPassengersList.add(new UserPassengers(1, "Renu", 21, "Female"));
		userPassengersList.add(new UserPassengers(1, "Venkat", 30, "Male"));

		when(userPassengersDAO.getAllUserPassengers(userId)).thenReturn(userPassengersList);

		String actualJson = fetchUserPassengers.getPassengersList(userId);

		verify(userPassengersDAO).getAllUserPassengers(userId);

		String expectedJson = objectMapper.writeValueAsString(userPassengersList);
		Assert.assertEquals(actualJson, expectedJson);
	}

	@Test
	public void testAddeditedpassengers() {
		UserPassengers userPassenger = new UserPassengers(1, "Passenger 1", 25, "Male");

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) {
				UserPassengersId passengerId = invocation.getArgument(0);
				Assert.assertEquals(passengerId.getUser_id(), userPassenger.getUser_id());
				Assert.assertEquals(passengerId.getPassenger_name(), userPassenger.getPassenger_name());
				Assert.assertEquals(passengerId.getAge(), userPassenger.getAge());
				Assert.assertEquals(passengerId.getGender(), userPassenger.getGender());
				return null;
			}
		}).when(userPassengersDAO).updateUserPassengers(any(UserPassengersId.class));

		fetchUserPassengers.addeditedpassengers(userPassenger);

		verify(userPassengersDAO).updateUserPassengers(any(UserPassengersId.class));
	}

	@Test
	public void testDeleteUserpassengers() {
		UserPassengers userPassenger = new UserPassengers(1, "Passenger 1", 25, "Male");

		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) {
				UserPassengersId passengerId = invocation.getArgument(0);
				Assert.assertEquals(passengerId.getUser_id(), userPassenger.getUser_id());
				Assert.assertEquals(passengerId.getPassenger_name(), userPassenger.getPassenger_name());
				Assert.assertEquals(passengerId.getAge(), userPassenger.getAge());
				Assert.assertEquals(passengerId.getGender(), userPassenger.getGender());
				return null;
			}
		}).when(userPassengersDAO).deleteUserPassengers(any(UserPassengersId.class));

		fetchUserPassengers.deleteUserpassengers(userPassenger);

		verify(userPassengersDAO).deleteUserPassengers(any(UserPassengersId.class));
	}

	@Test
	public void testAddUserpassengers() {
		UserPassengers userPassenger = new UserPassengers(1, "vamsi", 50, "Male");

		fetchUserPassengers.addUserpassengers(userPassenger);

		verify(userPassengersDAO).persist(userPassenger);
	}

	@Test
	public void testGetPassengersListEmpty() throws Exception {
		int userId = 1;
		List<UserPassengers> userPassengersList = new ArrayList<>();

		when(userPassengersDAO.getAllUserPassengers(userId)).thenReturn(userPassengersList);

		String actualJson = fetchUserPassengers.getPassengersList(userId);

		verify(userPassengersDAO).getAllUserPassengers(userId);

		String expectedJson = objectMapper.writeValueAsString(userPassengersList);
		Assert.assertEquals(actualJson, expectedJson);
	}
}
// @Test
// public void testAddeditedPassengersWithNullInput() {
// UserPassengers userPassenger = null;
//
// doAnswer(new Answer<Void>() {
// @Override
// public Void answer(InvocationOnMock invocation) {
// Assert.fail("UserPassengersDAO.updateUserPassengers() should not be called.");
// return null;
// }
// }).when(userPassengersDAO).updateUserPassengers(any(UserPassengersId.class));
//
// fetchUserPassengers.addeditedpassengers(userPassenger);
//
// verify(userPassengersDAO, Mockito.times(0)).updateUserPassengers(any(UserPassengersId.class));
// }

// @Test
// public void testDeleteUserPassengersWithNullInput() {
// UserPassengers userPassenger = null;
//
// doAnswer(new Answer<Void>() {
// @Override
// public Void answer(InvocationOnMock invocation) {
// Assert.fail("UserPassengersDAO.deleteUserPassengers() should not be called.");
// return null;
// }
// }).when(userPassengersDAO).deleteUserPassengers(any(UserPassengersId.class));
//
// fetchUserPassengers.deleteUserpassengers(userPassenger);
//
// verify(userPassengersDAO, Mockito.times(0)).deleteUserPassengers(any(UserPassengersId.class));
// }

// @Test
// public void testAddUserPassengersWithNullInput() {
// UserPassengers userPassenger = null;
//
// doAnswer(new Answer<Void>() {
// @Override
// public Void answer(InvocationOnMock invocation) {
// Assert.fail("UserPassengersDAO.persist() should not be called.");
// return null;
// }
// }).when(userPassengersDAO).persist(any(UserPassengers.class));
//
// fetchUserPassengers.addUserpassengers(userPassenger);
//
// verify(userPassengersDAO, Mockito.times(0)).persist(any(UserPassengers.class));
// }
