package com.avengers.bus.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avengers.bus.services.contracts.CheckSeat;
import com.avengers.bus.services.contracts.OrderGenerator;

@Controller
public class PaymentController {
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
		System.out.println("============================" + service_no);
		boolean seatAvailable = checkSeat.checkAvailability(service_no, seat);
		if (seatAvailable == false) {
			System.out.println("In controller if block");
			String myString="SeatsFilled";
			return "{\"status\": \"" + myString + "\"}";
		}
		String fullTicketNo = orderGenerator.generateTicketNo(ticketNumber);
		// calling orderGenerator class for generating an order
		String order = orderGenerator.generateOrder(fullTicketNo, amount);
		httpSession.setAttribute("ticketNumber", fullTicketNo);
		return order;
	}
}
