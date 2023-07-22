//package com.avengers.bus.services.implementation;
//package com.avengers.bus.services.test;
//
//import com.avengers.bus.dao.contracts.TicketManagementDAO;
//import com.avengers.bus.services.contracts.CancelTicketService;
//import com.avengers.bus.services.implementation.CancelTicketServiceImpl;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//import com.razorpay.Refund;
//import org.json.JSONObject;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertFalse;
//import static org.testng.Assert.assertTrue;
//
//public class CancelTicketServiceImplTest {
//    @Mock
//    private TicketManagementDAO ticketManagementDAOMock;
//
//    @Mock
//    private RazorpayClient razorpayClientMock;
//
//    @InjectMocks
//    private CancelTicketServiceImpl cancelTicketService;
//
//    @BeforeMethod
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testCancelTicket() {
//        // Arrange
//        String bookingId = "123";
//        when(ticketManagementDAOMock.cancelTicket(bookingId)).thenReturn(true);
//
//        // Act
//        boolean result = cancelTicketService.cancelTicket(bookingId);
//
//        // Assert
//        assertTrue(result);
//        verify(ticketManagementDAOMock).cancelTicket(bookingId);
//    }
//    
//
//    @Test
//    void cancelTicket_InvalidBookingId_ReturnsFalse() {
//        // Arrange
//        String bookingId = "456";
//        when(ticketManagementDAOMock.cancelTicket(bookingId)).thenReturn(false);
//
//        // Act
//        boolean result = cancelTicketService.cancelTicket(bookingId);
//
//        // Assert
//        assertFalse(result);
//        verify(ticketManagementDAOMock).cancelTicket(bookingId);
//    }
//
//    @Test
//    void cancelTicket_NullBookingId_ReturnsFalse() {
//        // Arrange
//        String bookingId = null;
//
//        // Act
//        boolean result = cancelTicketService.cancelTicket(bookingId);
//
//        // Assert
//        assertFalse(result);
//        verify(ticketManagementDAOMock, never()).cancelTicket(anyString());
//    }
//
//
//
//    
//}
//
