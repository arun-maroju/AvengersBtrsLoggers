package com.avengers.bus.services.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.UserTicketsDAO;
import com.avengers.bus.models.entityModels.Ticket;
import com.avengers.bus.services.implementation.FetchUserTicketsImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchUserTicketsImplTest {

	@Mock
	private UserTicketsDAO userTicketsDAO;

	@InjectMocks
	private FetchUserTicketsImpl fetchUserTickets;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetticketList() {
		// Arrange
		int userId = 1;
		List<Ticket> tickets = createDummyTicketList();
		when(userTicketsDAO.ticketList(userId)).thenReturn(tickets);

		// Act
		String result = fetchUserTickets.getticketList(userId);

		// Assert
		verify(userTicketsDAO).ticketList(userId);
		Assert.assertNotNull(result);
		// Add more assertions based on the expected JSON response
	}

	@Test
	public void testGetPastTicketList() {
		// Arrange
		int userId = 1;
		List<Ticket> tickets = createDummyTicketList();
		when(userTicketsDAO.pastTicketList(userId)).thenReturn(tickets);

		// Act
		String result = fetchUserTickets.getPastTicketList(userId);

		// Assert
		verify(userTicketsDAO).pastTicketList(userId);
		Assert.assertNotNull(result);
		// Add more assertions based on the expected JSON response
	}

	@Test
	public void testGetFutureTicketList() {
		// Arrange
		int userId = 1;
		List<Ticket> tickets = createDummyTicketList();
		when(userTicketsDAO.futureTicketList(userId)).thenReturn(tickets);

		// Act
		String result = fetchUserTickets.getFutureTicketList(userId);

		// Assert
		verify(userTicketsDAO).futureTicketList(userId);
		Assert.assertNotNull(result);
		// Add more assertions based on the expected JSON response
	}

	@Test
	public void testGetCancelTicketList() {
		// Arrange
		int userId = 1;
		List<Ticket> tickets = createDummyTicketList();
		when(userTicketsDAO.cancelTicketList(userId)).thenReturn(tickets);

		// Act
		String result = fetchUserTickets.getCancelTicketList(userId);

		// Assert
		verify(userTicketsDAO).cancelTicketList(userId);
		Assert.assertNotNull(result);
		// Add more assertions based on the expected JSON response
	}

	@Test
	public void testGetratingTicketList() {
		// Arrange
		int userId = 1;
		List<Ticket> tickets = createDummyTicketList();
		when(userTicketsDAO.ratingTicketList(userId)).thenReturn(tickets);

		// Act
		String result = fetchUserTickets.getratingTicketList(userId);

		// Assert
		verify(userTicketsDAO).ratingTicketList(userId);
		Assert.assertNotNull(result);
		// Add more assertions based on the expected JSON response
	}

	@Test
	public void testUpdateRatingTicketList() {
		// Arrange
		int userId = 1;
		Ticket ratingSubmission = createDummyTicket();

		// Act
		fetchUserTickets.updateRatingTicketList(userId, ratingSubmission);

		// Assert
		verify(userTicketsDAO).updateRatingTicketList(userId, ratingSubmission);
	}

	// Helper methods to create dummy data

	private List<Ticket> createDummyTicketList() {
		List<Ticket> tickets = new ArrayList<>();
		// Create dummy tickets and add them to the list
		return tickets;
	}

	private Ticket createDummyTicket() {
		Ticket ticket = new Ticket();
		// Set dummy values for the ticket
		return ticket;
	}

	// Helper method to convert object to JSON

	private String convertToJson(Object object) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
