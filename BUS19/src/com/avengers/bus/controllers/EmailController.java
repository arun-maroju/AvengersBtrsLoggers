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
	public String email(@RequestParam("to") String to_mail) {
		// Assinging to email to whome we need to send email
		logger.info("Received GET request to send an email.");
	    logger.debug("Recipient Email: {}", to_mail);
		String email = to_mail;
		httpSession.setAttribute("email", email);
		// storing generated otp
		int OTP = mailService.sendmail(to_mail);
		httpSession.setAttribute("OTP", OTP);
	    logger.info("Email sent successfully.");

		return "Email Sent Successfully";

	}

	@RequestMapping(value = "/validateOTP", method = RequestMethod.POST)
	public ModelAndView validateOTP(@RequestParam("otp") int OTP) {
		logger.info("Received POST request to validate OTP.");
	    logger.debug("Entered OTP: {}", OTP);
		
		ModelAndView mav = new ModelAndView();
		int originalOtp = (Integer) httpSession.getAttribute("OTP");
		String email = (String) httpSession.getAttribute("email");
		// checking the otp sent by the user if true returning reset page else need to stay in the same page with error
		// msg
		if (originalOtp == OTP) {
	        logger.info("OTP validation successful. Redirecting to reset page.");
			mav.setViewName("reset");
			mav.addObject("email", email);
			return mav;
		}
	    logger.info("Invalid OTP entered. Redirecting back to the forgot page.");
		mav.setViewName("stylishForgot");
		mav.addObject("msg", "Please Enter Valid OTP");
		mav.addObject("email", email);
		return mav;
	}

	// verifying entered otp for sign-up
	@RequestMapping(value = "/validateOTP1", method = RequestMethod.POST)
	@ResponseBody
	public String emailValidate(@RequestParam("otp") int OTP) {
		
		logger.info("Received POST request to validate OTP (for sign-up).");
	    logger.debug("Entered OTP: {}", OTP);
		Map<String, String> data = new HashMap<>();
		int originalOtp = (Integer) httpSession.getAttribute("OTP");
		String email = (String) httpSession.getAttribute("email");
		if (originalOtp == OTP) {
	        logger.info("OTP validation successful.");
	        data.put("key1", "success");
	    } else {
	        logger.info("Invalid OTP entered.");
	        data.put("key1", "failed");
	        logger.debug("Original OTP: {}, Entered OTP: {}", originalOtp, OTP);
	    }

	    ObjectMapper om = new ObjectMapper();
	    String json;
	    try {
	        json = om.writeValueAsString(data);
	    } catch (JsonProcessingException e) {
	        logger.error("Failed to convert data to JSON.", e);
	        e.printStackTrace();
	        return null;
	    }
		return json;
	}
}
