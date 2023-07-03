package com.avengers.bus.services.test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.UserListDAO;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.services.implementation.FetchUserImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		int userId = 1;

		List<User> users = new ArrayList<>();
		User user1 = new User();
		user1.setUser_id(1);
		user1.setFull_name("Imran Streak");
		users.add(user1);

		ObjectMapper objectMapper = new ObjectMapper();
		String expectedJson = null;
		try {
			expectedJson = objectMapper.writeValueAsString(users);
		} catch (Exception e) {
			e.printStackTrace();
		}

		when(userListDAO.UserList(userId)).thenReturn(users);

		String actualJson = fetchUser.getUserList(userId);

		verify(userListDAO).UserList(userId);

		Assert.assertEquals(actualJson, expectedJson);
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
