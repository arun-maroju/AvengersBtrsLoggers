package com.avengers.bus.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.avengers.bus.dao.contracts.ServiceGenerationDAO;
import com.avengers.bus.services.contracts.AdminCountsService;
import com.avengers.bus.services.contracts.FetchDetails;
import com.avengers.bus.services.contracts.FetchGraphData;
import com.avengers.bus.services.contracts.FetchList;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	private AdminCountsService adminCountsService;
	private FetchDetails fetchDetails;
	private FetchList fetchList;
	private FetchGraphData fetchGraphData;
	private ServiceGenerationDAO serviceGenerationDAO;

	// constructor autowiring
	@Autowired
	public AdminController(ServiceGenerationDAO serviceGenerationDAO, FetchGraphData fetchGraphData,
			AdminCountsService adminCountsService, FetchDetails fetchDetails, FetchList fetchList) {
		this.fetchList = fetchList;
		this.adminCountsService = adminCountsService;
		this.fetchDetails = fetchDetails;
		this.fetchGraphData = fetchGraphData;
		this.serviceGenerationDAO = serviceGenerationDAO;
		this.serviceGenerationDAO.callAutoGenerateServicesProcedure();
	}

	// Handles GET requests to "/admin"
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin(Model model) {
	    logger.info("Received GET request for admin dashboard.");
		// Constructs a ModelAndView object with the view name "AdminDashboard"
		ModelAndView mv = new ModelAndView("AdminDashboard");
		// Adds the counts obtained from adminCountsService to the ModelAndView object
		mv.addObject("counts", adminCountsService.getCounts());
	    logger.info("Returning admin dashboard.");
		return mv;
	}

	// Handles GET requests to "/serviceList"
	@RequestMapping(value = "/serviceList", method = RequestMethod.GET)
	@ResponseBody
	public String getServiceList() {
	    logger.info("Received GET request for service list.");
		// Retrieves a list of services in JSON format using fetchList
		String servicesJson = fetchList.getServiceList();
	    logger.info("Returning service list.");
		return servicesJson;
	}

	// Handles GET requests to "/routeList"
	@RequestMapping(value = "/routeList", method = RequestMethod.GET)
	@ResponseBody
	public String getRoutesList() {
	    logger.info("Received GET request for route list.");
		// Retrieves a list of routes in JSON format using fetchList
		String routesJson = fetchList.getRouteList();
	    logger.info("Returning route list.");
		return routesJson;
	}

	// Handles GET requests to "/busList"
	@RequestMapping(value = "/busList", method = RequestMethod.GET)
	@ResponseBody
	public String getBusesList() {
	    logger.info("Received GET request for bus list.");
		// Retrieves a list of buses in JSON format using fetchList
		String busesJson = fetchList.getBusList();
	    logger.info("Returning bus list.");
		return busesJson;
	}

	// Handles GET requests to "/adminTicketList"
	@RequestMapping(value = "/adminTicketList", method = RequestMethod.GET)
	@ResponseBody
	public String getTicketsList() {
	    logger.info("Received GET request for ticket list.");
		// Retrieves a list of tickets in JSON format using fetchList
		String routesJson = fetchList.getTicketList();
	    logger.info("Returning ticket list.");
		return routesJson;
	}

	// Handles GET requests to "/viewServicePassengerDetails"
	@RequestMapping(value = "/viewServicePassengerDetails", method = RequestMethod.GET)
	@ResponseBody
	public String getTicketPassengerList(String serviceId) {
	    logger.info("Received GET request for passenger list of service ID: {}", serviceId);
		// Retrieves a list of passengers for a specific service in JSON format using fetchList
		String routesJson = fetchList.getTicketPassengerList(serviceId);
	    logger.info("Returning passenger list for service ID: {}", serviceId);
		return routesJson;
	}

	// Handles GET requests to "/viewServiceDetails"
	@RequestMapping(value = "/viewServiceDetails", method = RequestMethod.GET)
	@ResponseBody
	public String getServiceDetails(String serviceId) {
	    logger.info("Received GET request for service details of ID: {}", serviceId);
		// Retrieves details of a specific service in JSON format using fetchDetails
		String sdJson = fetchDetails.getServiceDetails(serviceId);
	    logger.info("Returning service details for ID: {}", serviceId);
		return sdJson;
	}

	// Handles GET requests to "/viewRouteDetails"
	@RequestMapping(value = "/viewRouteDetails", method = RequestMethod.GET)
	@ResponseBody
	public String getRouteDetails(String routeNumber) {
	    logger.info("Received GET request for route details of route number: {}", routeNumber);
		// Retrieves details of a specific route in JSON format using fetchDetails
		String rdJson = fetchDetails.getRouteDetails(routeNumber);
	    logger.info("Returning route details for route number: {}", routeNumber);

		return rdJson;
	}

	// Handles GET requests to "/routeCollection"
	@RequestMapping(value = "/routeCollection", method = RequestMethod.GET)
	@ResponseBody
	public String getRoute() {
	    logger.info("Received GET request for route collection.");
		// Retrieves route collection data in JSON format using fetchGraphData
		String rcJson = fetchGraphData.getRouteCollection();
	    logger.info("Returning route collection.");
		return rcJson;
	}

	// Handles GET requests to "/tripCollection"
	@RequestMapping(value = "/tripCollection", method = RequestMethod.GET)
	@ResponseBody
	public String getTrip() {
	    logger.info("Received GET request for trip collection.");
		// Retrieves trip collection data in JSON format using fetchGraphData
		String tcJson = fetchGraphData.getTripCollection();
	    logger.info("Returning trip collection.");
		return tcJson;
	}

	// Handles GET requests to "/monthlyCollection"
	@RequestMapping(value = "/monthlyCollection", method = RequestMethod.GET)
	@ResponseBody
	public String getMonthlycollection() {
	    logger.info("Received GET request for monthly collection.");
		// Retrieves monthly collection data in JSON format using fetchGraphData
		String mcJson = fetchGraphData.getMonthlyCollection();
	    logger.info("Returning monthly collection.");
		return mcJson;
	}

}
