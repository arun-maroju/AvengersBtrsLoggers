package com.avengers.bus.services.contracts;

public interface FetchUserTickets {
	// This will get the ticket list data
	public String getticketList(int userId);

	// This will get the past ticket list data
	public String getPastTicketList(int userId);

	// This will get the future ticket list data
	public String getFutureTicketList(int userId);

	// This will get the cancelled tickets list data
	public String getCancelTicketList(int userId);

	// This will get the tickets list data which are qualified for give rating
	public String getratingTicketList(int userId);

	// This will update rating
	void updateRatingTicketList(int userId, com.avengers.bus.models.entityModels.Ticket ratingSubmission);

}
