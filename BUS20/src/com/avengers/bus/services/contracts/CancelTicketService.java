package com.avengers.bus.services.contracts;

import com.avengers.bus.models.dtoModels.Ticket;
import com.razorpay.RazorpayException;

public interface CancelTicketService {

	public boolean cancelTicket(String booking_id);

	public String refund(String booking_id, String payment_id, int fare) throws RazorpayException;

	String refundAmount(Ticket ticket);
}
