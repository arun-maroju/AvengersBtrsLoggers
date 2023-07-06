package com.avengers.bus.services.implementation;
// package com.avengers.bus.services.test;
//
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.doReturn;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.verify;
//
// import org.json.JSONObject;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.Spy;
// import org.testng.Assert;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.Test;
//
// import com.avengers.bus.services.implementation.OrderGeneratorImpl;
// import com.razorpay.Order;
// import com.razorpay.RazorpayClient;
// import com.razorpay.RazorpayException;
//
// public class OrderGeneratorImplTest {
//
// @Mock
// private RazorpayClient razorpayClient;
//
// @Spy
// private OrderGeneratorImpl orderGenerator;
//
// @BeforeMethod
// public void setup() throws RazorpayException {
// MockitoAnnotations.initMocks(this);
// doReturn(razorpayClient).when(orderGenerator).getRazorpayClient();
// }
//
// @Test
// public void testGenerateOrder() throws RazorpayException {
// // Mock the RazorpayClient and Order creation
// Order order = mock(Order.class);
// doReturn(order).when(razorpayClient).orders().create(any(JSONObject.class));
//
// // Define the inputs for generateOrder()
// String ticketNumber = "TICKET123";
// String amount = "10";
//
// // Invoke the method under test
// String result = orderGenerator.generateOrder(ticketNumber, amount);
//
// // Verify that RazorpayClient and Order were used correctly
// verify(orderGenerator).getRazorpayClient();
// verify(razorpayClient.orders()).create(any(JSONObject.class));
//
// // Assert the result
// Assert.assertNotNull(result);
// }
//
// @Test
// public void testGenerateTicketNo() {
// // Define the input for generateTicketNo()
// String ticketNumber = "TICKET";
//
// // Invoke the method under test
// String result = orderGenerator.generateTicketNo(ticketNumber);
//
// // Assert the result
// Assert.assertNotNull(result);
// Assert.assertTrue(result.startsWith(ticketNumber));
// }
// }
