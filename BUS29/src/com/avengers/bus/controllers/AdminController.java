package com.avengers.bus.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.avengers.bus.dao.contracts.ServiceGenerationDAO;
import com.avengers.bus.models.inputModels.ActivateData;
import com.avengers.bus.models.inputModels.InterStop;
import com.avengers.bus.models.inputModels.Route;
import com.avengers.bus.models.inputModels.Trip;
import com.avengers.bus.services.contracts.AdminCountsService;
import com.avengers.bus.services.contracts.FetchDetails;
import com.avengers.bus.services.contracts.FetchGraphData;
import com.avengers.bus.services.contracts.FetchList;
import com.avengers.bus.services.contracts.RouteModifier;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private AdminCountsService adminCountsService;
    private FetchDetails fetchDetails;
    private FetchList fetchList;
    private FetchGraphData fetchGraphData;
    private ServiceGenerationDAO serviceGenerationDAO;
    private RouteModifier routeModifier;

    // constructor autowiring
    @Autowired
    public AdminController(RouteModifier routeModifier, ServiceGenerationDAO serviceGenerationDAO, FetchGraphData fetchGraphData,
            AdminCountsService adminCountsService, FetchDetails fetchDetails, FetchList fetchList) {
        this.fetchList = fetchList;
        this.adminCountsService = adminCountsService;
        this.fetchDetails = fetchDetails;
        this.fetchGraphData = fetchGraphData;
        this.serviceGenerationDAO = serviceGenerationDAO;
        this.serviceGenerationDAO.callAutoGenerateServicesProcedure();
        this.routeModifier=routeModifier;
    }

    // Handles GET requests to "/admin"
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(Model model) {
        logger.info("Admin dashboard accessed.");
        // Constructs a ModelAndView object with the view name "AdminDashboard"
        ModelAndView mv = new ModelAndView("AdminDashboard");
        // Adds the counts obtained from adminCountsService to the ModelAndView object
        mv.addObject("counts", adminCountsService.getCounts());
        return mv;
    }

    // Handles GET requests to "/serviceList"
    @RequestMapping(value = "/serviceList", method = RequestMethod.GET)
    @ResponseBody
    public String getServiceList(int page, int records) {
        logger.info("Fetching service list. Page: {}, Records: {}", page, records);
        // Retrieves a list of services in JSON format using fetchList
        String servicesJson = fetchList.getServiceList(page, records);
        return servicesJson;
    }

    // Handles GET requests to "/routeList"
    @RequestMapping(value = "/routeList", method = RequestMethod.GET)
    @ResponseBody
    public String getRoutesList() {
        logger.info("Fetching route list.");
        // Retrieves a list of routes in JSON format using fetchList
        String routesJson = fetchList.getRouteList();
        return routesJson;
    }

    // Handles GET requests to "/busList"
    @RequestMapping(value = "/busList", method = RequestMethod.GET)
    @ResponseBody
    public String getBusesList() {
        logger.info("Fetching bus list.");
        // Retrieves a list of buses in JSON format using fetchList
        String busesJson = fetchList.getBusList();
        return busesJson;
    }

    // Handles GET requests to "/adminTicketList"
    @RequestMapping(value = "/adminTicketList", method = RequestMethod.GET)
    @ResponseBody
    public String getTicketsList() {
        logger.info("Fetching ticket list.");
        // Retrieves a list of tickets in JSON format using fetchList
        String routesJson = fetchList.getTicketList();
        return routesJson;
    }

    // Handles GET requests to "/adminRefundList"
    @RequestMapping(value = "/adminRefundList", method = RequestMethod.GET)
    @ResponseBody
    public String getRefundsList() {
        logger.info("Fetching refund list.");
        // Retrieves a list of refunds in JSON format using fetchList
        String routesJson = fetchList.getRefundsList();
        return routesJson;
    }

    // Handles GET requests to "/viewServicePassengerDetails"
    @RequestMapping(value = "/viewServicePassengerDetails", method = RequestMethod.GET)
    @ResponseBody
    public String getTicketPassengerList(String serviceId) {
        logger.info("Fetching passenger list for service ID: {}", serviceId);
        // Retrieves a list of passengers for a specific service in JSON format using fetchList
        String routesJson = fetchList.getTicketPassengerList(serviceId);
        return routesJson;
    }

    // Handles GET requests to "/viewServiceDetails"
    @RequestMapping(value = "/viewServiceDetails", method = RequestMethod.GET)
    @ResponseBody
    public String getServiceDetails(String serviceId) {
        logger.info("Fetching details for service ID: {}", serviceId);
        // Retrieves details of a specific service in JSON format using fetchDetails
        String sdJson = fetchDetails.getServiceDetails(serviceId);
        return sdJson;
    }

    // Handles GET requests to "/viewRouteDetails"
    @RequestMapping(value = "/viewRouteDetails", method = RequestMethod.GET)
    @ResponseBody
    public String getRouteDetails(String routeNumber) {
        logger.info("Fetching details for route number: {}", routeNumber);
        // Retrieves details of a specific route in JSON format using fetchDetails
        String rdJson = fetchDetails.getRouteDetails(routeNumber);
        return rdJson;
    }

    // Handles GET requests to "/routeCollection"
    @RequestMapping(value = "/routeCollection", method = RequestMethod.GET)
    @ResponseBody
    public String getRouteCollection() {
        logger.info("Fetching route collection data.");
        // Retrieves route collection data in JSON format using fetchGraphData
        String rcJson = fetchGraphData.getRouteCollection();
        return rcJson;
    }

    // Handles GET requests to "/tripCollection"
    @RequestMapping(value = "/tripCollection", method = RequestMethod.GET)
    @ResponseBody
    public String getTripCollection() {
        logger.info("Fetching trip collection data.");
        // Retrieves trip collection data in JSON format using fetchGraphData
        String tcJson = fetchGraphData.getTripCollection();
        return tcJson;
    }

    // Handles GET requests to "/monthlyCollection"
    @RequestMapping(value = "/monthlyCollection", method = RequestMethod.GET)
    @ResponseBody
    public String getMonthlycollection() {
        logger.info("Fetching monthly collection data.");
        // Retrieves monthly collection data in JSON format using fetchGraphData
        String mcJson = fetchGraphData.getMonthlyCollection();
        return mcJson;
    }
    
    @RequestMapping(value = "/addRoute", method = RequestMethod.POST)
    @ResponseBody
    public String addNewRoute(int routeNumber, String routeSource, String routeDestination) {
        boolean persisted=routeModifier.generateRoute(routeNumber, routeSource, routeDestination);
        if(persisted)
        	return "Success";
        else
        	return "Failed";
    }
    
    @RequestMapping(value = "/deactivateRoute", method = RequestMethod.POST)
    @ResponseBody
    public String deactivateRoute(int routeNumber, String routeSource, String routeDestination) {
        boolean deactivated=routeModifier.deactivateRoute(routeNumber, routeSource, routeDestination);
        if(deactivated)
        	return "Success";
        else
        	return "Failed";
    }
    
    @RequestMapping(value = "/activateRoute", method = RequestMethod.POST)
    @ResponseBody
    public String activateRoute(int routeNumber, String routeSource, String routeDestination) {
        boolean deactivated=routeModifier.activateRoute(routeNumber, routeSource, routeDestination);
        if(deactivated)
        	return "Success";
        else
        	return "Failed";
    }
    
    @RequestMapping(value = "/activateNewRoute", method = RequestMethod.POST)
    @ResponseBody
    public String activateNewRoute(@RequestBody ActivateData data) {
    	
    	boolean activated=routeModifier.activateNewRoute(data);
        if(activated)
        	return "Success";
        else
        	return "Failed";
    	
    	
    
}
    
}  
