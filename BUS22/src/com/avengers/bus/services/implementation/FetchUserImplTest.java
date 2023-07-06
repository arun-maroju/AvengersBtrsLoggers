package com.avengers.bus.services.implementation;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.UserListDAO;
import com.avengers.bus.models.entityModels.User;

public class FetchUserImplTest {

	@Mock
	private UserListDAO userListDAO;

	@InjectMocks
	private FetchUserImpl fetchUser;

	@BeforeClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetUserList() {
		// Arrange
		int userId = 1;

		List<User> users = new ArrayList<>();
		User user1 = new User();
		user1.setUser_id(1);
		user1.setFull_name("Imran Streak");
		users.add(user1);

		when(userListDAO.UserList(userId)).thenReturn(users);

		// Act
		String actualJson = fetchUser.getUserList(userId);

		// Assert
		verify(userListDAO, times(1)).UserList(userId);

		String expectedJson = "[{\"userId\":1,\"name\":\"John\"},{\"userId\":1,\"name\":\"Jane\"}]";
		Assert.assertEquals(actualJson, expectedJson);
	}

	@Test
	public void testGetUserListException() {
		int userId = 1;

		// Reset the mock to clear any previous invocations
		Mockito.reset(userListDAO);

		// Specify the behavior of the mock
		when(userListDAO.UserList(userId)).thenReturn(null);

		String actualJson = fetchUser.getUserList(userId);

		// Verify the expected number of invocations
		verify(userListDAO, times(1)).UserList(userId);

		Assert.assertNull(actualJson);
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setUser_id(1);
		user.setFull_name("Imran Streak");

		doNothing().when(userListDAO).updateUser(user);

		fetchUser.add(user);

		verify(userListDAO).updateUser(user);
	}
}
