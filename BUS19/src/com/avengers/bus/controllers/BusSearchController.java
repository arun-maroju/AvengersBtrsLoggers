package com.avengers.bus.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.dao.contracts.ServiceGenerationDAO;
import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.entityModels.BusTypes;
import com.avengers.bus.models.entityModels.SeatsBookedForOneService;
import com.avengers.bus.models.entityModels.Stations;
import com.avengers.bus.models.inputModels.SearchBusInput;
import com.avengers.bus.services.contracts.BusListService;
import com.avengers.bus.services.contracts.BusTypeService;
import com.avengers.bus.services.contracts.StationService;

@Controller
public class BusSearchController {
	private static final Logger logger = LoggerFactory.getLogger(BusSearchController.class);

	private StationService stationService;
	private BusTypeService busTypeService;
	private BusSearchDAO busSearchDAO;
	private BusListService busListService;
	private ServiceGenerationDAO serviceGenerationDAO;

	// constructor.. autowired
	@Autowired
	public BusSearchController(StationService stationService, BusTypeService busTypeService, BusSearchDAO busSearchDAO,
			BusListService busListService, ServiceGenerationDAO serviceGenerationDAO) {
		super();
		this.stationService = stationService;
		this.busTypeService = busTypeService;
		this.busSearchDAO = busSearchDAO;
		this.busListService = busListService;
		this.serviceGenerationDAO = serviceGenerationDAO;
	}

	// Handler method for the search page
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getSearchPage(Model model) {
	    logger.info("Showing the home page.");
		// retrieving all the busstops and bus types
		List<Stations> stationsList = stationService.listAll();
		List<BusTypes> busTypesList = busTypeService.listAll();
		// sending list of all bus-stops..
	    logger.info("Retrieved the list of bus stops and bus types.");
		model.addAttribute("stationList", stationsList);
		// sending list of all bus types
		model.addAttribute("busTypeList", busTypesList);
		return "home";
	}

	// Handler method for retrieving the list of buses based on search criteria
	@RequestMapping(value = "/getBusList", method = RequestMethod.POST)
	public String getServicesList(@Validated SearchBusInput sbi, Model model) {
	    logger.info("Received POST request to retrieve the list of buses based on search criteria.");
		// getting all the services available based on user requirements
		List<BusSearchListDto> buses = busListService.getBusList(sbi);
	    logger.info("Retrieved the list of buses based on search criteria.");
		// sending all the available services
		model.addAttribute("buses", buses);
		return "busList";
	}

	// Handler method for retrieving the bus layout and booked seats
	@RequestMapping(value = "/layout", method = RequestMethod.POST)
	public String getBusLayout(@Validated BusSearchListDto bus, Model model) {
	    logger.info("Received POST request to retrieve the bus layout and booked seats.");
		// getting the seats booked for that particular service from database so that no one can book them again
		List<SeatsBookedForOneService> seatsList = busSearchDAO.getBookedSeats(bus.getService_id());
	    logger.info("Retrieved the list of booked seats for the selected bus service.");
		// sending the seats details
		
		model.addAttribute("sl", seatsList);
		// sending selected bus details
		model.addAttribute("selectedBusDetails", bus);
		return "busLayout";
	}

	// Handler method for the about page
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
	    logger.info("Showing the about page.");
		return "aboutUs";
	}

	// Handler method for the contact page
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
	    logger.info("Showing the contact page.");
		return "contactUs";
	}
}
