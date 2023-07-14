package com.avengers.bus.services.contracts;

import com.avengers.bus.models.dtoModels.Ticket;
import com.razorpay.RazorpayException;

public interface CancelTicketService {
	// cancel the ticket change its status to 'cancelled'
	public boolean cancelTicket(String booking_id, String refund_id);

	// refund amount when user want to cancel the booking
	public String refund(String booking_id, String payment_id, int fare) throws RazorpayException;

	// refund the amount seats not available after payment...
	public String refundAmount(Ticket ticket);
}
