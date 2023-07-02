package com.avengers.bus.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avengers.bus.services.contracts.CheckSeat;
import com.avengers.bus.services.contracts.OrderGenerator;

@Controller
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	private HttpSession httpSession;
	private OrderGenerator orderGenerator;
	private CheckSeat checkSeat;

	// constructor Autowiring
	@Autowired
	public PaymentController(HttpSession httpSession, OrderGenerator orderGenerator, CheckSeat checkSeat) {
		super();
		this.httpSession = httpSession;
		this.orderGenerator = orderGenerator;
		this.checkSeat = checkSeat;
	}

	// Handler method for initiating the payment process
	@RequestMapping(value = "/makePayment", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String pay(String ticketNumber, String amount, int seat[], int service_no) {
		logger.info("Received GET request to make a payment.");
	    logger.debug("Ticket Number: {}", ticketNumber);
	    logger.debug("Amount: {}", amount);
	    logger.debug("Seats: {}", Arrays.toString(seat));
	    logger.debug("Service Number: {}", service_no);
		
		System.out.println("============================" + service_no);
		boolean seatAvailable = checkSeat.checkAvailability(service_no, seat);
		if (seatAvailable == false) {
	        logger.info("Seats already filled for service number: {}", service_no);
			System.out.println("In controller if block");
			return "Seats already filled";
		}
		String fullTicketNo = orderGenerator.generateTicketNo(ticketNumber);
		// calling orderGenerator class for generating an order
		String order = orderGenerator.generateOrder(fullTicketNo, amount);
		httpSession.setAttribute("ticketNumber", fullTicketNo);
	    logger.info("Payment processing completed. Returning the order details.");

		return order;
	}
}
