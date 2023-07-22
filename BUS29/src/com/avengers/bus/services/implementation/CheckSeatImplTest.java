//package com.avengers.bus.services.implementation;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.dao.contracts.TicketManagementDAO;
//import com.avengers.bus.models.dtoModels.Ticket;
//import com.avengers.bus.models.inputModels.Passengers;
//import com.avengers.bus.services.contracts.CancelTicketService;
//
//public class CheckSeatImplTest {
//
//	@Mock
//	private TicketManagementDAO ticketManagementDAO;
//
//	@Mock
//	private CancelTicketService cancelTicketService;
//
//	@InjectMocks
//	private CheckSeatImpl checkSeatService;
//
//	@BeforeClass
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testCheckAvailability_SeatsAvailable() {
//		// Mock the necessary objects and behavior
//		int serviceNo = 123;
//		int[] seats = { 1, 2, 3 };
//
//		when(ticketManagementDAO.getBookedSeatsCount(serviceNo, seats)).thenReturn(0);
//
//		// Call the method to be tested
//		boolean result = checkSeatService.checkAvailability(serviceNo, seats);
//
//		// Verify the interactions and assertions
//		verify(ticketManagementDAO).getBookedSeatsCount(serviceNo, seats);
//		Assert.assertTrue(result);
//	}
//
//	@Test
//	public void testCheckAvailability_SeatsNotAvailable() {
//		// Mock the necessary objects and behavior
//		int serviceNo = 123;
//		int[] seats = { 1, 2, 3 };
//
//		when(ticketManagementDAO.getBookedSeatsCount(serviceNo, seats)).thenReturn(1);
//
//		// Call the method to be tested
//		boolean result = checkSeatService.checkAvailability(serviceNo, seats);
//
//		// Verify the interactions and assertions
//		// verify(ticketManagementDAO, times(1)).getBookedSeatsCount(serviceNo, seats);
//		Assert.assertFalse(result);
//	}
//
//	@Test
//	public void testCheckPersistability_SeatsAvailable() {
//		// Mock the necessary objects and behavior
//		Ticket ticket = new Ticket();
//		Passengers passenger1 = new Passengers();
//		passenger1.setSeat_id(1);
//		Passengers passenger2 = new Passengers();
//		passenger2.setSeat_id(2);
//
//		List<Passengers> passengers = new ArrayList<>();
//		passengers.add(passenger1);
//		passengers.add(passenger2);
//
//		ticket.setService_no(123);
//		ticket.setPassengers(passengers);
//
//		int[] seats = { 1, 2 };
//
//		when(checkSeatService.checkAvailability(ticket.getService_no(), seats)).thenReturn(true);
//
//		// Call the method to be tested
//		boolean result = checkSeatService.checkpersistability(ticket);
//
//		// Verify the interactions and assertions
//		verify(checkSeatService).checkAvailability(ticket.getService_no(), seats);
//		Assert.assertTrue(result);
//	}
//
//	@Test
//	public void testCheckPersistability_SeatsNotAvailable() {
//		// Mock the necessary objects and behavior
//		Ticket ticket = new Ticket();
//		Passengers passenger1 = new Passengers();
//		passenger1.setSeat_id(1);
//		Passengers passenger2 = new Passengers();
//		passenger2.setSeat_id(2);
//
//		List<Passengers> passengers = new ArrayList<>();
//		passengers.add(passenger1);
//		passengers.add(passenger2);
//
//		ticket.setService_no(123);
//		ticket.setPassengers(passengers);
//
//		int[] seats = { 1, 2 };
//
//		when(checkSeatService.checkAvailability(ticket.getService_no(), seats)).thenReturn(false);
//
//		// Call the method to be tested
//		boolean result = checkSeatService.checkpersistability(ticket);
//
//		// Verify the interactions and assertions
//		verify(checkSeatService).checkAvailability(ticket.getService_no(), seats);
//		Assert.assertFalse(result);
//	}
//}
