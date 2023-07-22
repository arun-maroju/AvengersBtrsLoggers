//package com.avengers.bus.services.implementation;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.verify;
//
//import java.sql.Date;
//import java.sql.Time;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.dao.contracts.TicketManagementDAO;
//import com.avengers.bus.models.dtoModels.Ticket;
//import com.avengers.bus.models.inputModels.Passengers;
//import com.avengers.bus.services.implementation.SaveTicketServiceImpl;
//import com.avengers.bus.utilities.exceptions.TicketNotPersistedException;
//
//public class SaveTicketServiceImplTest {
//
//	@Mock
//	private TicketManagementDAO ticketManagementDAO;
//
//	@InjectMocks
//	private SaveTicketServiceImpl saveTicketService;
//
//	@BeforeClass
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testSaveTheTicket() throws TicketNotPersistedException {
//		// Arrange
//		Ticket ticket = createSampleTicket();
//		int userId = 123;
//
//		// Mock the DAO's saveTicket method
//		doNothing().when(ticketManagementDAO).saveTicket(any());
//
//		// Act
//		try {
//			saveTicketService.saveTheTicket(ticket, userId);
//		} catch (TicketNotPersistedException e) {
//			e.printStackTrace();
//		}
//
//		// Assert
//		verify(ticketManagementDAO).saveTicket(any());
//	}
//
//	// Helper method to create a sample Ticket for testing
//	private Ticket createSampleTicket() {
//		Ticket ticket = new Ticket();
//		ticket.setTicketNo("T12345");
//		ticket.setNumberOfPassengers(2);
//		ticket.setPayment_id("PAY123");
//		ticket.setService_no(911);
//		ticket.setTotalFare(100.0);
//		ticket.setTrip_no(1001);
//		ticket.setFrom("Source");
//		ticket.setTo("Destination");
//		ticket.setJourney_date(new Date(System.currentTimeMillis()));
//		ticket.setDeparture_time(new Time(System.currentTimeMillis()));
//		ticket.setOrder_id("ORD789");
//
//		List<Passengers> passengers = new ArrayList<>();
//		passengers.add(new Passengers());
//		passengers.add(new Passengers());
//		ticket.setPassengers(passengers);
//
//		return ticket;
//	}
//
//	// Add more test methods for edge cases and error scenarios
//
//}
