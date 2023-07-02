package com.avengers.bus.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avengers.bus.models.dtoModels.Email;
import com.avengers.bus.models.dtoModels.Userlist;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.inputModels.UserPasswordChange;
import com.avengers.bus.services.contracts.UserService;

// Still working on it..

@Controller
public class AuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private UserService userService;

	Userlist ul = new Userlist();
	List<Email> el = ul.getuser();

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) {

		logger.info("Your Message from login method!!");

		System.out.println("In post login ..");

		// Perform authentication logic and redirect based on the result
		if (userService.verifylogin(username, password)) {

			User user = userService.getUser(username);
			session.setAttribute("user", user);
			session.setAttribute("userId", user.getUser_id());

			// User authentication successful
			System.out.println("im in login method if block");
			session.setAttribute("authenticatedUser", username);

			logger.info("Your Message from login method!!  user logged in Successufully");
			return "redirect:/home";
		} else {
			System.out.println("In post login ..else block");
			logger.info("Your Message from login method!!  Error while logging");
			model.addAttribute("errorMessage", "Invalid username or password");
			return "stylishLogin";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(HttpSession session) {
	    
	    logger.info("Received GET request for login page.");
	    
	    // Check if the user is already logged in
	    if (session.getAttribute("authenticatedUser") != null) {
	        logger.info("User is already logged in. Redirecting to the dashboard page.");
	        return "redirect:/home";
	    }
	    
	    logger.info("User is not logged in. Showing the login page.");
	    return "stylishLogin";
	}
	

	@GetMapping("/")
	public String showDashboard(HttpSession session) {
	    logger.info("Received GET request for dashboard page.");

	    // Check if the user is logged in
	    if (session.getAttribute("authenticatedUser") == null) {
	        logger.info("User is not logged in. Redirecting to the login page.");
	        return "redirect:/login";
	    }

	    logger.info("User is logged in. Redirecting to the dashboard page.");
	    return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
	    logger.info("Received GET request for logout.");

	    // Perform logout logic
	    request.getSession().invalidate();

	    logger.info("User has been logged out. Redirecting to the home page.");
	    return "redirect:/home";
	}

	// Admin logins..
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String showAdminLogin(HttpSession session) {

		// Check if the user is already logged in
		if (session.getAttribute("adminLogged") != null) {
			System.out.println("In get admin login if condition..");
			// User is already logged in, redirect to the dashboard page
	        logger.info("Admin user is already logged in. Redirecting to the admin dashboard.");
			return "redirect:/admin";
		}
	    logger.info("Admin user is not logged in. Showing the admin login page.");
		return "adminLogin";
	}

	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public String showAdminLogin(@RequestParam("user_name") String user_name, @RequestParam("password") String password,
			HttpSession httpSession, Model model) {

		if (user_name.equals("Admin") && password.equals("Admin")) {
			httpSession.setAttribute("adminLogged", "Yes");
	        logger.info("Admin user login successful. Redirecting to the admin dashboard.");
			return "redirect:/admin";
		}

		else {
			System.out.println("In post login ..else block");
	        logger.info("Admin user login failed. Invalid username or password.");
			model.addAttribute("errorMessage", "Invalid username or password");
			return "adminLogin";
		}

	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
	    logger.info("Showing the signup page.");
		return "stylishSignup";
	}

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String forgot() {
	    logger.info("Showing the forgot password page.");
		return "stylishForgot";
	}

	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String reset() {
	    logger.info("Showing the password reset page.");
		return "reset";
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String changePassword(@Validated UserPasswordChange userPasswordChange) {
		
		logger.info("Received POST request to change password.");
	    logger.info("Email: " + userPasswordChange.getEmail());
	    logger.info("New Password: " + userPasswordChange.getPassword());

		System.out.println(userPasswordChange.getEmail());
		System.out.println(userPasswordChange.getPassword());
		userService.change_Password(userPasswordChange);
	    logger.info("Password change successful. Redirecting to the login page.");
		return "stylishLogin";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(User u) {
		logger.info("Received POST request to register a new user.");
	    logger.info("User Details: " + u);
		System.out.println(u);
		userService.addUser(u);
	    logger.info("User registration successful. Redirecting to the login page.");
		return "redirect:login";
	}

}
