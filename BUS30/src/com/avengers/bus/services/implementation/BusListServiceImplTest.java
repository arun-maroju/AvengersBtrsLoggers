//package com.avengers.bus.services.implementation;
//
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.dao.contracts.BusListDAO;
//import com.avengers.bus.models.dtoModels.BusSearchListDto;
//import com.avengers.bus.models.inputModels.SearchBusInput;
//import com.avengers.bus.services.implementation.BusListServiceImpl;
//
//public class BusListServiceImplTest {
//
//	@Mock
//	BusListDAO busListDAO;
//
//	@InjectMocks
//	private BusListServiceImpl busListServiceImpl;
//
//	@BeforeMethod
//	public void beforeMethod() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testGetBusListWithTravelClass() {
//		// Mock the necessary objects
//		SearchBusInput sbi = new SearchBusInput();
//		sbi.setTravelClass(1);
//
//		List<BusSearchListDto> mockBusList = new ArrayList<>();
//		// Add some mock BusSearchListDto objects to the list
//
//		when(busListDAO.getBusList(sbi)).thenReturn(mockBusList);
//
//		// Call the method to be tested
//		List<BusSearchListDto> result = busListServiceImpl.getBusList(sbi);
//
//		// Verify the interactions and assertions
//		// verify(busListDAO).getBusList(sbi);
//		Assert.assertEquals(result, mockBusList);
//	}
//
//	@Test
//	public void testGetBusListWithoutTravelClass() {
//		// Mock the necessary objects
//		SearchBusInput sbi = new SearchBusInput();
//		sbi.setTravelClass(0);
//
//		List<BusSearchListDto> mockBusList = new ArrayList<>();
//		// Add some mock BusSearchListDto objects to the list
//
//		when(busListDAO.getBusListAll(sbi)).thenReturn(mockBusList);
//
//		// Call the method to be tested
//		List<BusSearchListDto> result = busListServiceImpl.getBusList(sbi);
//
//		// Verify the interactions and assertions
//		// verify(busListDAO).getBusListAll(sbi);
//		Assert.assertEquals(result, mockBusList);
//	}
//}
