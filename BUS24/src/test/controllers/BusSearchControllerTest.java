package test.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avengers.bus.controllers.BusSearchController;
import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.entityModels.BusTypes;
import com.avengers.bus.models.entityModels.SeatsBookedForOneService;
import com.avengers.bus.models.entityModels.Stations;
import com.avengers.bus.models.inputModels.SearchBusInput;
import com.avengers.bus.services.contracts.BusListService;
import com.avengers.bus.services.contracts.BusTypeService;
import com.avengers.bus.services.contracts.StationService;

public class BusSearchControllerTest {

	@Mock
	private StationService stationService;
	@Mock
	private BusTypeService busTypeService;
	@Mock
	private BusSearchDAO busSearchDAO;
	@Mock
	private BusListService busListService;
	@InjectMocks
	private BusSearchController busSearchController;

	@Mock
	private Model model;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetSearchPage() {
		// Arrange
		List<Stations> stationsList = new ArrayList<>();
		List<BusTypes> busTypesList = new ArrayList<>();
		when(stationService.listAll()).thenReturn(stationsList);
		when(busTypeService.listAll()).thenReturn(busTypesList);

		// Act
		String result = busSearchController.getSearchPage(model);
		System.out.println(result);

		// Assert
		// verify(logger).info("Showing the home page.");
		verify(stationService).listAll();
		verify(busTypeService).listAll();
		verify(model).addAttribute("stationList", stationsList);
		verify(model).addAttribute("busTypeList", busTypesList);
		assertEquals("home", result);

	}

	@Test
	public void testGetServicesList() {
		// Arrange
		SearchBusInput sbi = new SearchBusInput();
		List<BusSearchListDto> buses = new ArrayList<>();
		when(busListService.getBusList(sbi)).thenReturn(buses);

		// Act
		String result = busSearchController.getServicesList(sbi, model);

		// Assert
		// verify(logger).info("Received POST request to retrieve the list of buses based on search criteria.");
		verify(busListService).getBusList(sbi);
		verify(model).addAttribute("buses", buses);
		assertEquals("busList", result);
	}

	@Test
	public void testGetBusLayout() {
		// Arrange
		BusSearchListDto bus = new BusSearchListDto();
		List<SeatsBookedForOneService> seatsList = new ArrayList<>();
		when(busSearchDAO.getBookedSeats(bus.getService_id())).thenReturn(seatsList);

		// Act
		String result = busSearchController.getBusLayout(bus, model);

		// Assert
		// verify(logger).info("Received POST request to retrieve the bus layout and booked seats.");
		verify(busSearchDAO).getBookedSeats(bus.getService_id());
		verify(model).addAttribute("sl", seatsList);
		verify(model).addAttribute("selectedBusDetails", bus);
		assertEquals("busLayout", result);
	}

	@Test
	public void testAbout() {
		// Act
		String result = busSearchController.about();

		// Assert
		// verify(logger).info("Showing the about page.");
		assertEquals("aboutUs", result);
	}

	@Test
	public void testContact() {
		// Act
		String result = busSearchController.contact();

		// Assert
		// verify(logger).info("Showing the contact page.");
		assertEquals("contactUs", result);
	}
}
