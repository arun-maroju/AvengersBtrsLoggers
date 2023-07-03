import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.json.JSONObject;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.services.contracts.OrderGenerator;
import com.avengers.bus.services.implementation.OrderGeneratorImpl;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

public class OrderGeneratorImplTest {

	@Mock
	private RazorpayClient razorpayClient;

	@InjectMocks
	private OrderGenerator orderGenerator = new OrderGeneratorImpl();

	@BeforeMethod
	public void setUp() throws RazorpayException {
		MockitoAnnotations.initMocks(this);
		Order mockOrder = mock(Order.class);
		when(razorpayClient.orders()).thenReturn(mockOrder);
		when(mockOrder.create(any(JSONObject.class))).thenReturn(mockOrder);
	}

	@Test
	public void testGenerateOrder() {
		String ticketNumber = "TICKET123";
		String amount = "100";
		String orderString = orderGenerator.generateOrder(ticketNumber, amount);
		Assert.assertNotNull(orderString);
	}

	@Test
	public void testGenerateOrder_RazorpayException() throws RazorpayException {
		String ticketNumber = "TICKET123";
		String amount = "100";

		when(razorpayClient.orders().create(any(JSONObject.class)))
				.thenThrow(new RazorpayException("Razorpay server error"));

		String orderString = orderGenerator.generateOrder(ticketNumber, amount);
		Assert.assertNull(orderString);
	}

	@Test
	public void testGenerateTicketNo() {
		String ticketNumber = "TICKET";
		String generatedTicketNo = orderGenerator.generateTicketNo(ticketNumber);
		Assert.assertNotNull(generatedTicketNo);
	}

	@Test
	public void testGenerateTicketNo_Uniqueness() {
		String ticketNumber = "TICKET";
		String generatedTicketNo1 = orderGenerator.generateTicketNo(ticketNumber);
		String generatedTicketNo2 = orderGenerator.generateTicketNo(ticketNumber);
		Assert.assertNotEquals(generatedTicketNo1, generatedTicketNo2);
	}
}
