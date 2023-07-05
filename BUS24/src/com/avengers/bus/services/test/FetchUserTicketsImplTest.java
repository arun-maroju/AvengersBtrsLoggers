package com.avengers.bus.services.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.dao.contracts.UserTicketsDAO;
import com.avengers.bus.models.dtoModels.UserTickets;
import com.avengers.bus.models.entityModels.Ticket;
import com.avengers.bus.services.implementation.FetchUserTicketsImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchUserTicketsImplTest {

	@Mock
	private UserTicketsDAO userTicketsDAO;

	@Spy
	@InjectMocks
	private FetchUserTicketsImpl fetchUserTickets;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetTicketList() throws Exception {
		// Arrange
		int userId = 1;

		Ticket ticket1 = createTicket("1", "Booking 1", 1);
		Ticket ticket2 = createTicket("2", "Booking 2", 1);
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket1);
		tickets.add(ticket2);

		when(userTicketsDAO.ticketList(userId)).thenReturn(tickets);

		// Act
		String result = fetchUserTickets.getticketList(userId);

		// Assert
		ObjectMapper objectMapper = new ObjectMapper();
		List<UserTickets> userTicketsList = objectMapper.readValue(result,
				objectMapper.getTypeFactory().constructCollectionType(List.class, UserTickets.class));

		Assert.assertEquals(userTicketsList.size(), 2);
		Assert.assertEquals(userTicketsList.get(0).getBooking_id(), 1);
		Assert.assertEquals(userTicketsList.get(0).getBooking_date(), "Booking 1");
		Assert.assertEquals(userTicketsList.get(1).getBooking_id(), 2);
		Assert.assertEquals(userTicketsList.get(1).getBooking_date(), "Booking 2");
		verify(userTicketsDAO, times(1)).ticketList(userId);
	}

	@Test
	public void testGetPastTicketList() throws Exception {
		// Arrange
		int userId = 1;

		Ticket ticket1 = createTicket("1", "Booking 1", 1);
		Ticket ticket2 = createTicket("2", "Booking 2", 1);
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket1);
		tickets.add(ticket2);

		when(userTicketsDAO.pastTicketList(userId)).thenReturn(tickets);

		// Act
		String result = fetchUserTickets.getPastTicketList(userId);

		// Assert
		ObjectMapper objectMapper = new ObjectMapper();
		List<UserTickets> userTicketsList = objectMapper.readValue(result,
				objectMapper.getTypeFactory().constructCollectionType(List.class, UserTickets.class));

		Assert.assertEquals(userTicketsList.size(), 2);
		Assert.assertEquals(userTicketsList.get(0).getBooking_id(), 1);
		Assert.assertEquals(userTicketsList.get(0).getBooking_date(), "Booking 1");
		Assert.assertEquals(userTicketsList.get(1).getBooking_id(), 2);
		Assert.assertEquals(userTicketsList.get(1).getBooking_date(), "Booking 2");
		verify(userTicketsDAO, times(1)).pastTicketList(userId);
	}

	// Similar test methods for other methods (getFutureTicketList, getCancelTicketList, getratingTicketList,
	// updateRatingTicketList) can be implemented.

	private Ticket createTicket(String bookingId, String bookingDate, int userId) {
		Ticket ticket = new Ticket();
		ticket.setBooking_id(bookingId);
		// ticket.setBooking_date(bookingDate);
		ticket.setUser_id(userId);
		return ticket;
	}
}
