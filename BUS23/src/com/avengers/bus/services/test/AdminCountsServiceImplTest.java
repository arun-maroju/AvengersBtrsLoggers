package com.avengers.bus.services.test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.UserDAO;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.inputModels.UserPasswordChange;
import com.avengers.bus.services.implementation.UserServiceImpl;

public class AdminCountsServiceImplTest {

	@Mock
	private UserDAO userDAOMock;

	@InjectMocks
	private UserServiceImpl userService;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testVerifylogin_ValidCredentials_ReturnsTrue() {
		// Arrange
		String email = "user@example.com";
		String password = "securepassword";
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		when(userDAOMock.findByEmail(email)).thenReturn(user);

		// Act
		boolean result = userService.verifylogin(email, password);

		// Assert
		Assert.assertTrue(result);
		verify(userDAOMock, times(1)).findByEmail(email);
	}

	@Test
	public void testVerifylogin_InvalidCredentials_ReturnsFalse() {
		// Arrange
		String email = "user@example.com";
		String password = "wrongpassword";
		when(userDAOMock.findByEmail(email)).thenReturn(null);

		// Act
		boolean result = userService.verifylogin(email, password);

		// Assert
		Assert.assertFalse(result);
		verify(userDAOMock, times(1)).findByEmail(email);
	}

	@Test
	public void testGetUser_UserExists_ReturnsUser() {
		// Arrange
		String email = "user@example.com";
		User user = new User();
		user.setEmail(email);
		when(userDAOMock.findByEmail(email)).thenReturn(user);

		// Act
		User result = userService.getUser(email);

		// Assert
		Assert.assertEquals(result, user);
		verify(userDAOMock, times(1)).findByEmail(email);
	}

	@Test
	public void testGetUser_UserDoesNotExist_ReturnsNull() {
		// Arrange
		String email = "user@example.com";
		when(userDAOMock.findByEmail(email)).thenReturn(null);

		// Act
		User result = userService.getUser(email);

		// Assert
		Assert.assertNull(result);
		verify(userDAOMock, times(1)).findByEmail(email);
	}

	@Test
	public void testListAll_ReturnsListOfUsers() {
		// Arrange
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		when(userDAOMock.getAllUsers()).thenReturn(users);

		// Act
		List<User> result = userService.listAll();

		// Assert
		Assert.assertEquals(result, users);
		verify(userDAOMock, times(1)).getAllUsers();
	}

	@Test
	public void testAddUser_UserAddedSuccessfully() {
		// Arrange
		User user = new User();
		user.setEmail("user@example.com");

		// Act
		userService.addUser(user);

		// Assert
		verify(userDAOMock, times(1)).persistUser(user);
	}

	@Test
	public void testChangePassword_PasswordChangedSuccessfully() {
		// Arrange
		String email = "user@example.com";
		String newPassword = "newsecurepassword";
		UserPasswordChange userPasswordChange = new UserPasswordChange();
		userPasswordChange.setEmail(email);
		userPasswordChange.setPassword(newPassword);

		// Act
		userService.change_Password(userPasswordChange);

		// Assert
		verify(userDAOMock, times(1)).changePassword(userPasswordChange);
	}

	@Test
	public void testVerifylogin_NullEmail_ReturnsFalse() {
		// Arrange
		String email = null;
		String password = "securepassword";

		// Act
		boolean result = userService.verifylogin(email, password);

		// Assert
		Assert.assertFalse(result);
		verify(userDAOMock, never()).findByEmail(anyString());
	}

	@Test
	public void testVerifylogin_NullPassword_ReturnsFalse() {
		// Arrange
		String email = "user@example.com";
		String password = null;
		User user = new User();
		user.setEmail(email);
		user.setPassword("securepassword");
		when(userDAOMock.findByEmail(email)).thenReturn(user);

		// Act
		boolean result = userService.verifylogin(email, password);

		// Assert
		Assert.assertFalse(result);
		verify(userDAOMock, times(1)).findByEmail(email);
	}

	@Test
	public void testGetUser_UserNotFound_ReturnsNull() {
		// Arrange
		String email = "user@example.com";
		when(userDAOMock.findByEmail(email)).thenReturn(null);

		// Act
		User result = userService.getUser(email);

		// Assert
		Assert.assertNull(result);
		verify(userDAOMock, times(1)).findByEmail(email);
	}

	@Test
	public void testListAll_NoUsers_ReturnsEmptyList() {
		// Arrange
		when(userDAOMock.getAllUsers()).thenReturn(new ArrayList<>());

		// Act
		List<User> result = userService.listAll();

		// Assert
		Assert.assertNotNull(result);
		Assert.assertTrue(result.isEmpty());
		verify(userDAOMock, times(1)).getAllUsers();
	}

}
