package com.avengers.bus.services.test;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.UserDAO;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.inputModels.UserPasswordChange;
import com.avengers.bus.services.implementation.UserServiceImpl;

public class UserServiceImplTest {

	@Mock
	private UserDAO userDAOMock;

	@InjectMocks
	private UserServiceImpl userService;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testVerifyLogin_ValidCredentials_ReturnsTrue() {
		// Arrange
		String email = "venkatsharma098@gmail.com";
		String password = "Venkat@786";
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		// Mock the behavior of the UserDAO
		Mockito.when(userDAOMock.findByEmail(email)).thenReturn(user);

		// Act
		boolean result = userService.verifylogin(email, password);

		// Assert
		Assert.assertTrue(result);
	}

	@Test
	public void testVerifyLogin_InvalidCredentials_ReturnsFalse() {
		// Arrange
		String email = "venkatsharma098@gmail.com";
		String password = "Venkat@7861";
		User user = new User();
		user.setEmail(email);
		user.setPassword("Venkat@2001");

		// Mock the behavior of the UserDAO
		Mockito.when(userDAOMock.findByEmail(email)).thenReturn(user);

		// Act
		boolean result = userService.verifylogin(email, password);

		// Assert
		Assert.assertFalse(result);
	}

	@Test
	public void testGetUser_ExistingEmail_ReturnsUser() {
		// Arrange
		String email = "venkatsharma098@gmail.com";
		User user = new User();
		user.setEmail(email);

		// Mock the behavior of the UserDAO
		Mockito.when(userDAOMock.findByEmail(email)).thenReturn(user);

		// Act
		User result = userService.getUser(email);

		// Assert
		Assert.assertEquals(result, user);
	}

	@Test
	public void testListAll_ReturnsListOfUsers() {
		// Arrange
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());

		// Mock the behavior of the UserDAO
		Mockito.when(userDAOMock.getAllUsers()).thenReturn(users);

		// Act
		List<User> result = userService.listAll();

		// Assert
		Assert.assertEquals(result.size(), users.size());
		Assert.assertEquals(result.get(0), users.get(0));
		Assert.assertEquals(result.get(1), users.get(1));
	}

	@Test
	public void testAddUser_UserIsAdded() {
		// Arrange
		User user = new User();
		user.setEmail("venkat.sharma7861@gmail.com");

		// Act
		userService.addUser(user);

		// Assert
		// Verify that the UserDAO's persistUser method is called with the expected user
		Mockito.verify(userDAOMock).persistUser(user);
	}

	@Test
	public void testChangePassword_PasswordIsChanged() {
		// Arrange
		String email = "venkatsharma098@gmail.com";
		String newPassword = "venkat@2001";
		UserPasswordChange userPasswordChange = new UserPasswordChange(newPassword, newPassword);
		userPasswordChange.setEmail(email);
		userPasswordChange.setPassword(newPassword);

		// Act
		userService.change_Password(userPasswordChange);

		// Assert
		// Verify that the UserDAO's changePassword method is called with the expected UserPasswordChange object
		Mockito.verify(userDAOMock).changePassword(userPasswordChange);
	}
}
