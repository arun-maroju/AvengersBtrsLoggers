package com.avengers.bus.services.contracts;

public interface FetchUserTickets {

	public String getticketList(int userId);

	public String getPastTicketList(int userId);

	public String getFutureTicketList(int userId);

	public String getCancelTicketList(int userId);

	public String getratingTicketList(int userId);

	void updateRatingTicketList(int userId, com.avengers.bus.models.entityModels.Ticket ratingSubmission);

}
