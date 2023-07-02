package com.avengers.bus.services.implementation;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.TicketManagementDAO;
import com.avengers.bus.services.contracts.CancelTicketService;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Refund;

@Component
public class CancelTicketServiceImpl implements CancelTicketService {
	private static final Logger logger = LoggerFactory.getLogger(CancelTicketServiceImpl.class);

	@Autowired
	private TicketManagementDAO ticketManagementDAO;

	@Override
	public boolean cancelTicket(String booking_id) {
		logger.info("Cancelling Ticket");

		System.out.println("in CancelTicketServiceImpl cancel ticket");

		return ticketManagementDAO.cancelTicket(booking_id);
	}

	@Override
	public String refund(String booking_id, String payment_id, int fare) throws RazorpayException {

		RazorpayClient razorpay = null;

		razorpay = new RazorpayClient("rzp_test_eH7ePzZMEaZaJo", "zD7v7uOY240NjF1QTEqylAv7");

		JSONObject refundRequest = new JSONObject();
		refundRequest.put("amount", fare * 100);
		refundRequest.put("speed", "optimum");
		refundRequest.put("receipt", booking_id);

		Refund refund = razorpay.payments.refund(payment_id, refundRequest);

		System.out.println("Refund ID: " + refund.get("id"));
		System.out.println("Refund Amount: " + refund.get("amount"));
		String refund_id = refund.get("id");
		logger.info("Fetching Refund id of CancelledTicket:{}", refund_id);

		return refund_id;

	}

}
