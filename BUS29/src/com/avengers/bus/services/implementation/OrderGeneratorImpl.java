package com.avengers.bus.services.implementation;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.avengers.bus.services.contracts.OrderGenerator;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Component
public class OrderGeneratorImpl implements OrderGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderGeneratorImpl.class);

	@Override
	public String generateOrder(String ticketNumber, String amount) {
		LOGGER.info("Generating order for ticketNumber: {}", ticketNumber);
		RazorpayClient razorpayClient = null;
		try {
			razorpayClient = new RazorpayClient("rzp_test_eH7ePzZMEaZaJo", "zD7v7uOY240NjF1QTEqylAv7");
		} catch (RazorpayException e1) {
			LOGGER.error("Error creating Razorpay client: {}", e1.getMessage());
			e1.printStackTrace();
		}
		JSONObject options = new JSONObject();
		int amt = Integer.parseInt(amount) * 100;
		options.put("amount", amt); // Amount in paise (e.g., 1000 paise = Rs 10)
		options.put("currency", "INR");
		options.put("receipt", ticketNumber);
		Order order = null;
		try {
			order = razorpayClient.orders.create(options);
		} catch (RazorpayException e) {
			LOGGER.error("Error generating order: {}", e.getMessage());
			e.printStackTrace();
			return null;
		}
		LOGGER.debug("Order generated: {}", order);

		return order.toString();
	}

	@Override
	public String generateTicketNo(String ticketNumber) {
		LOGGER.info("Generating ticket number");
		return ticketNumber = ticketNumber + System.currentTimeMillis();
	}

}
