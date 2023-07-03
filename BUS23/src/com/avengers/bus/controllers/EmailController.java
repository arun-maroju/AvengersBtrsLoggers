package com.avengers.bus.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
		String email = to_mail;
		httpSession.setAttribute("email", email);
		// storing generated otp
		int OTP = mailService.sendmail(to_mail);
		httpSession.setAttribute("OTP", OTP);
		return "Email Sent Successfully";

	}

	@RequestMapping(value = "/validateOTP", method = RequestMethod.POST)
	public ModelAndView validateOTP(@RequestParam("otp") int OTP) {
		ModelAndView mav = new ModelAndView();
		int originalOtp = (Integer) httpSession.getAttribute("OTP");
		String email = (String) httpSession.getAttribute("email");
		// checking the otp sent by the user if true returning reset page else need to stay in the same page with error
		// msg
		if (originalOtp == OTP) {
			mav.setViewName("reset");
			mav.addObject("email", email);
			return mav;
		}
		mav.setViewName("stylishForgot");
		mav.addObject("msg", "Please Enter Valid OTP");
		mav.addObject("email", email);
		return mav;
	}

	// verifying entered otp for sign-up
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
			return json;
		}
		System.out.println("Failed" + originalOtp + " " + OTP);
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
