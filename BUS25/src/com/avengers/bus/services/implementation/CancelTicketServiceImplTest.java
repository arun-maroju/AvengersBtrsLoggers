//package com.avengers.bus.services.implementation;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.spy;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.json.JSONObject;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.dao.contracts.TicketManagementDAO;
//import com.avengers.bus.models.dtoModels.Ticket;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//import com.razorpay.Refund;
//
//public class CancelTicketServiceImplTest {
//
//	@Mock
//	private TicketManagementDAO ticketManagementDAO;
//
//	@InjectMocks
//	private CancelTicketServiceImpl cancelTicketService;
//
//	@BeforeClass
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testCancelTicket() {
//		// Mock the necessary objects
//		String bookingId = "booking123";
//		when(ticketManagementDAO.cancelTicket(bookingId)).thenReturn(true);
//
//		// Call the method to be tested
//		boolean result = cancelTicketService.cancelTicket(bookingId);
//
//		// Verify the interactions and assertions
//		verify(ticketManagementDAO).cancelTicket(bookingId);
//		Assert.assertTrue(result);
//	}
//
//	@Test
//	public void testRefund() throws RazorpayException {
//		// Mock the necessary objects
//		Ticket ticket = new Ticket();
//		ticket.setTicketNo("ticket123");
//		ticket.setPayment_id("payment123");
//		ticket.setTotalFare(1000);
//		String booking_id = ticket.getTicketNo();
//		String refundId = "refund123";
//		RazorpayClient razorpay = mock(RazorpayClient.class);
//		Refund refund = mock(Refund.class);
//		JSONObject refundRequest = mock(JSONObject.class);
//
//		when(razorpay.payments.refund("abc")).thenReturn(null);
//		when(refund.get("id")).thenReturn(refundId);
//		when(refundRequest.put("amount", 1500)).thenReturn(null);
//		when(refundRequest.put("amount", 1500)).thenReturn(null);
//		when(refundRequest.put("receipt", booking_id)).thenReturn(null);
//
//		CancelTicketServiceImpl cancelTicketServiceSpy = spy(cancelTicketService);
//		// doReturn(razorpay).when(cancelTicketServiceSpy).getRazorpayClient();
//		// doReturn(refundRequest).when(cancelTicketServiceSpy).createRefundRequest(anyInt(), anyString());
//
//		// Call the method to be tested
//		String result = cancelTicketServiceSpy.refundAmount(ticket);
//
//		// Verify the interactions and assertions
//		Assert.assertEquals(result, refundId);
//		// verify(cancelTicketServiceSpy).getRazorpayClient();
//		// verify(cancelTicketServiceSpy).createRefundRequest(1000, "ticket123");
//		verify(refundRequest).put("amount", 1000 * 100);
//		verify(refundRequest).put("speed", "optimum");
//		verify(refundRequest).put("receipt", "ticket123");
//		// verify(razorpay.payments()).refund("payment123", refundRequest);
//		verify(refund).get("id");
//		verify(refund).get("amount");
//	}
//}
