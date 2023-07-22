//package com.avengers.bus.services.implementation;
//
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.slf4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.dao.contracts.UserListDAO;
//import com.avengers.bus.models.entityModels.User;
//import com.avengers.bus.services.implementation.FetchUserImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class FetchUserImplTest {
//
//	@Mock
//	private UserListDAO userListDAO;
//
//	@Mock
//	private Logger logger;
//
//	@InjectMocks
//	private FetchUserImpl fetchUser;
//
//	@BeforeClass
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testGetUserList() {
//		int userId = 1;
//
//		List<User> users = new ArrayList<>();
//		User user1 = new User();
//		user1.setUser_id(1);
//		user1.setFull_name("Imran Streak");
//		users.add(user1);
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		String expectedJson = null;
//		try {
//			expectedJson = objectMapper.writeValueAsString(users);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		when(userListDAO.UserList(userId)).thenReturn(users);
//
//		String actualJson = fetchUser.getUserList(userId);
//
//		verify(logger).info("Fetching user details for user with ID: {}", userId);
//		verify(userListDAO).UserList(userId);
//
//		Assert.assertEquals(actualJson, expectedJson);
//	}
//
//	@Test
//	public void testGetUserListException() {
//		int userId = 1;
//
//		when(userListDAO.UserList(userId)).thenReturn(null);
//
//		String actualJson = fetchUser.getUserList(userId);
//
//		verify(logger).info("Fetching user details for user with ID: {}", userId);
//		verify(userListDAO).UserList(userId);
//
//		Assert.assertNull(actualJson);
//	}
//
//	@Test
//	public void testAddUser() {
//		User user = new User();
//		user.setUser_id(1);
//		user.setFull_name("Imran Streak");
//
//		doNothing().when(userListDAO).updateUser(user);
//
//		fetchUser.add(user);
//
//		verify(logger).info("Adding or updating user with ID: {}", user.getUser_id());
//		verify(userListDAO).updateUser(user);
//		verify(logger).info("User details added/updated successfully.");
//	}
//}
