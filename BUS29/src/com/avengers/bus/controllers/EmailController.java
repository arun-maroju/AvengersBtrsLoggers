package com.avengers.bus.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.avengers.bus.services.contracts.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class EmailController {
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	private EmailService mailService;
	private HttpSession httpSession;

	// constructor Autowiring
	@Autowired
	public EmailController(EmailService mailService, HttpSession httpSession) {
		this.mailService = mailService;
		this.httpSession = httpSession;
	}

	@RequestMapping(value = "/email", method = RequestMethod.GET)
	@ResponseBody
	public String email(@RequestParam("to") String to_mail, @RequestParam("purpose") String purpose) {
		// Assigning the email to whom we need to send the email
		String email = to_mail;
		logger.info("Trying to send Email to: {}", to_mail);
		httpSession.setAttribute("email", email);
		// Storing the generated OTP
		int OTP = mailService.sendmail(to_mail, purpose);
		if (OTP == 01) {
			return "Account already Exists. Please Log In.";
		}
		if (OTP == 10) {
			return "Account Does Not Exists. Please Sign Up.";
		}
		httpSession.setAttribute("OTP", OTP);
		logger.info("Email Sent Successfully to: {}", to_mail);
		return "Email Sent Successfully";
	}

	@RequestMapping(value = "/validateOTP", method = RequestMethod.POST)
	public ModelAndView validateOTP(@RequestParam("otp") int OTP) {
		ModelAndView mav = new ModelAndView();
		int originalOtp = (Integer) httpSession.getAttribute("OTP");
		String email = (String) httpSession.getAttribute("email");
		// Checking the OTP sent by the user. If it's true, returning the reset page. Otherwise, staying on the same
		// page with an error message.
		if (originalOtp == OTP) {
			mav.setViewName("reset");
			mav.addObject("email", email);
			logger.info("OTP validated successfully for email: {}", email);
			return mav;
		}
		mav.setViewName("stylishForgot");
		mav.addObject("msg", "Please Enter Valid OTP");
		mav.addObject("email", email);
		logger.info("Invalid OTP entered for email: {}", email);
		return mav;
	}

	// Verifying entered OTP for sign-up
	@RequestMapping(value = "/validateOTP1", method = RequestMethod.POST)
	@ResponseBody
	public String emailValidate(@RequestParam("otp") int OTP) {
		Map<String, String> data = new HashMap<>();
		int originalOtp = (Integer) httpSession.getAttribute("OTP");
		String email = (String) httpSession.getAttribute("email");
		if (originalOtp == OTP) {
			data.put("key1", "success");
			ObjectMapper om = new ObjectMapper();
			String json;
			try {
				json = om.writeValueAsString(data);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return null;
			}
			logger.info("OTP validated successfully for email: {}", email);
			return json;
		}
		logger.info("Invalid OTP entered for email: {}", email);
		data.put("key1", "failed");
		ObjectMapper om = new ObjectMapper();
		String json;
		try {
			json = om.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
		return json;
	}
}
