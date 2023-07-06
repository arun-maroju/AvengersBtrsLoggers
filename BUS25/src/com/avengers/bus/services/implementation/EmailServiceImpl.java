package com.avengers.bus.services.implementation;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.services.contracts.EmailService;
import com.avengers.bus.services.contracts.UserService;

@Component
public class EmailServiceImpl implements EmailService {

	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private UserService userService;

	@Override
	public int sendmail(String to_mail, String purpose) {
		String to = to_mail;
		String subject;
		String body;
		User user = userService.getUser(to_mail);
		int OTP;
		if (purpose.equals("signup")) {
			if (user == null) {
				subject = "User Sign up";
				logger.info("Sending Mail for Signup to:{}", to);

				OTP = generateOTP();
				body = "The OTP for the Account Creation: " + OTP;
			} else
				return 01;
		} else {
			if (user != null) {
				subject = "Password Reset";
				logger.info("Sending Mail for Password reset to:{}", to);

				OTP = generateOTP();
				body = "The OTP for the Password Reset: " + OTP;
			} else
				return 10;
		}

		sendEmail(to, subject, body);

		logger.info("Generating OTP:{}", OTP);

		return OTP;
	}

	private static void sendEmail(String to, String subject, String body) {
		String host = "smtp.gmail.com";
		int port = 587;
		String username = "avengersbtrs@gmail.com";
		String password = "urpr twig ffeb uqlx";

		// Set properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		// Create session
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);
			logger.info("Fetching sent mail Message");
			Transport.send(message);
		} catch (MessagingException e) {
			logger.info("Error in message sending");
			e.printStackTrace();
		}

	}

	private static int generateOTP() {
		Random random = new Random();
		int randomNumber = 100000 + random.nextInt(900000);
		logger.info("Generating randon number for OTP:{}", randomNumber);

		return randomNumber;
	}

}