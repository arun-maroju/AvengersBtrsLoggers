package com.avengers.bus.services.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.json.JSONObject;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.services.implementation.OrderGeneratorImpl;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@ContextConfiguration
public class OrderGeneratorImplTest extends AbstractTestNGSpringContextTests {

	@Mock
	private RazorpayClient razorpayClientMock;

	@InjectMocks
	private OrderGeneratorImpl orderGenerator;

	@BeforeMethod
	public void setup() throws RazorpayException {
		MockitoAnnotations.initMocks(this);
		orderGenerator.setRazorpayClient(razorpayClientMock);
	}

	@Test
	public void testGenerateOrder_Success() throws RazorpayException {
		// Arrange
		String ticketNumber = "132103620236281687956264990";
		String amount = "1000";
		int expectedAmount = 1000;
		Order expectedOrder = new Order(null);

		JSONObject options = new JSONObject();
		options.put("amount", expectedAmount);
		options.put("currency", "INR");
		options.put("receipt", ticketNumber);

		when(razorpayClientMock.orders.create(any())).thenReturn(expectedOrder);

		// Act
		String result = orderGenerator.generateOrder(ticketNumber, amount);

		// Assert
		Assert.assertNotNull(result);
		Assert.assertEquals(result, expectedOrder.toString());
	}

	@Test
	public void testGenerateOrder_RazorpayException() throws RazorpayException {
		// Arrange
		String ticketNumber = "132103620236281687956264990";
		String amount = "1000";

		when(razorpayClientMock.orders.create(any())).thenThrow(new RazorpayException("Error"));

		// Act
		String result = orderGenerator.generateOrder(ticketNumber, amount);

		// Assert
		Assert.assertNull(result);
	}

	@Test
	public void testGenerateTicketNo() {
		// Arrange
		String ticketNumber = "132103620236281687956264990";

		// Act
		String result = orderGenerator.generateTicketNo(ticketNumber);

		// Assert
		Assert.assertNotNull(result);
		Assert.assertTrue(result.startsWith(ticketNumber));
	}
}
