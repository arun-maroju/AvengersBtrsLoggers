package com.avengers.bus.dao.contracts;

import java.util.List;

import com.avengers.bus.models.entityModels.Ticket;

public interface UserTicketsDAO {

	// lists all the tickets booked by one user
	public List<Ticket> ticketList(int userId);

	// lists all the future tickets belongs to one user
	public List<Ticket> futureTicketList(int userId);

	// lists all the past tickets of one user
	public List<Ticket> pastTicketList(int userId);

	// lists all the tickets of all types
	public List<Ticket> getAllTickets(int userId);

	// lists all the tickets cancelled by one user
	public List<Ticket> cancelTicketList(int userId);

	// list the ticket for which user can give rating it will then reflect to route wise rating
	public List<Ticket> ratingTicketList(int userId);

	// user rating will be submitted here
	public void updateRatingTicketList(int userId, Ticket ratingSubmission);

}
