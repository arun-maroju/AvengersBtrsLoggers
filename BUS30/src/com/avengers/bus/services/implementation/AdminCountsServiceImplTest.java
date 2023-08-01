//package com.avengers.bus.services.implementation;
//
//import static org.mockito.Mockito.when;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.models.inputModels.SearchBusInput;
//import com.avengers.bus.models.viewModels.AdminCounts;
//import com.avengers.bus.services.contracts.FetchCount;
//import com.avengers.bus.services.implementation.AdminCountsServiceImpl;
//
//public class AdminCountsServiceImplTest {
//
//	@Mock
//	FetchCount fc;
//
//	@Mock
//	SearchBusInput sbi;
//
//	@InjectMocks
//	private AdminCountsServiceImpl adminCountsServiceImpl;
//
//	@BeforeMethod
//	public void beforeMethod() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void getCountsTest() {
//		when(fc.getUserCount()).thenReturn(12);
//		when(fc.getCollection()).thenReturn(12);
//		when(fc.getBusCount()).thenReturn(12);
//		when(fc.getFutureTicketCollection()).thenReturn(12);
//		when(fc.getPastTicketCollection()).thenReturn(12);
//		when(fc.getRouteCount()).thenReturn(12);
//		when(fc.getTripCount()).thenReturn(12);
//		when(fc.getServiceCount()).thenReturn(12);
//
//		// Expected AdminCounts object
//		AdminCounts expectedAdminCounts = new AdminCounts(12, 12, 12, 12, 12, 12, 12, 12);
//
//		// Call the getCounts() method
//		AdminCounts actualAdminCounts = adminCountsServiceImpl.getCounts();
//
//		// Verify the result
//		Assert.assertEquals(actualAdminCounts, expectedAdminCounts);
//
//	}
//}
