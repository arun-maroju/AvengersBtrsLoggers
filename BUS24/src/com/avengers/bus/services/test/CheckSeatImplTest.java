package com.avengers.bus.services.test;

import com.avengers.bus.dao.contracts.TicketManagementDAO;
import com.avengers.bus.models.dtoModels.Ticket;
import com.avengers.bus.models.inputModels.Passengers;
import com.avengers.bus.services.contracts.CancelTicketService;
import com.avengers.bus.services.implementation.CheckSeatImpl;
import com.razorpay.RazorpayException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckSeatImplTest {
    @Mock
    private TicketManagementDAO ticketManagementDAOMock;

    @Mock
    private CancelTicketService cancelTicketServiceMock;

    @InjectMocks
    private CheckSeatImpl checkSeat;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkAvailability_SeatsNotAvailable_ReturnsFalse() {
        // Arrange
        int serviceNo = 123;
        int[] seats = {1, 2, 3};
        when(ticketManagementDAOMock.getBookedSeatsCount(serviceNo, seats)).thenReturn(3);

        // Act
        boolean result = checkSeat.checkAvailability(serviceNo, seats);

        // Assert
        assertFalse(result);
        verify(ticketManagementDAOMock).getBookedSeatsCount(serviceNo, seats);
    }

    @Test
    public void checkAvailability_SeatsAvailable_ReturnsTrue() {
        // Arrange
        int serviceNo = 123;
        int[] seats = {4, 5, 6};
        when(ticketManagementDAOMock.getBookedSeatsCount(serviceNo, seats)).thenReturn(0);

        // Act
        boolean result = checkSeat.checkAvailability(serviceNo, seats);

        // Assert
        assertTrue(result);
        verify(ticketManagementDAOMock).getBookedSeatsCount(serviceNo, seats);
    }

//    @Test
//    public void checkPersistability_SeatsNotAvailable_RefundsTicketAndReturnsRefundId() throws RazorpayException {
//        // Arrange
//        Ticket ticket = new Ticket();
//        ticket.setService_no(123);
//        ticket.setTicketNo("ABC123");
//        ticket.setPayment_id("PAY456");
//        ticket.setTotalFare(1000);
//        List<Passengers> passengers = new ArrayList<>();
//        passengers.add(new Passengers("John", 25, "Male", 1, 500.0));
//        passengers.add(new Passengers("Jane", 30, "Female", 2, 500.0));
//        ticket.setPassengers(passengers);
//
//        int[] seats = {1, 2};
//        when(checkSeat.checkAvailability(ticket.getService_no(), seats)).thenReturn(false);
//        when(cancelTicketServiceMock.refund(ticket.getTicketNo(), ticket.getPayment_id(), ticket.getTotalFare()))
//                .thenReturn("REF789");
//
//        // Act
//        String result = checkSeat.checkpersistability(ticket);
//
//        // Assert
//        assertEquals(result, "REF789");
//        verify(checkSeat).checkAvailability(ticket.getService_no(), seats);
//        verify(cancelTicketServiceMock).refund(ticket.getTicketNo(), ticket.getPayment_id(), ticket.getTotalFare());
//        verifyNoMoreInteractions(ticketManagementDAOMock, cancelTicketServiceMock);
//    }
//
//    @Test
//    public void checkPersistability_SeatsAvailable_ReturnsPersistable() throws RazorpayException {
//        // Arrange
//        Ticket ticket = new Ticket();
//        ticket.setService_no(123);
//        ticket.setTicketNo("ABC123");
//        ticket.setPayment_id("PAY456");
//        ticket.setTotalFare(1000);
//        List<Passengers> passengers = new ArrayList<>();
//        passengers.add(new Passengers("John", 25, "Male", 3, 500.0));
//        passengers.add(new Passengers("Jane", 30, "Female", 4, 500.0));
//        ticket.setPassengers(passengers);
//
//        int[] seats = {3, 4};
//        when(checkSeat.checkAvailability(ticket.getService_no(), seats)).thenReturn(true);
//
//        // Act
//        String result = checkSeat.checkpersistability(ticket);
//
//        // Assert
//        assertEquals(result, "persistable");
//        verify(checkSeat).checkAvailability(ticket.getService_no(), seats);
//        verifyNoMoreInteractions(ticketManagementDAOMock, cancelTicketServiceMock);
//    }
}
