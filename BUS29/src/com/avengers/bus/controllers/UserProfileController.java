package com.avengers.bus.controllers;

import javax.servlet.http.HttpSession;

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

import com.avengers.bus.models.entityModels.Ticket;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.entityModels.UserPassengers;
import com.avengers.bus.services.contracts.CancelTicketService;
import com.avengers.bus.services.contracts.FetchUser;
import com.avengers.bus.services.contracts.FetchUserCounts;
import com.avengers.bus.services.contracts.FetchUserPassengers;
import com.avengers.bus.services.contracts.FetchUserTickets;
import com.razorpay.RazorpayException;

@Controller
public class UserProfileController {
    private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    private FetchUser fetchUser;
    private FetchUserTickets fetchUserTickets;
    private FetchUserPassengers fetchUserPassengers;
    private FetchUserCounts fetchUserCounts;
    private HttpSession httpSession;
    private CancelTicketService cancelTicketService;

    // constructor Autowiring
    @Autowired
    public UserProfileController(FetchUser fetchUser, FetchUserTickets fetchUserTickets,
            FetchUserPassengers fetchUserPassengers, FetchUserCounts fetchUserCounts, HttpSession httpSession,
            CancelTicketService cancelTicketService) {
        this.fetchUser = fetchUser;
        this.fetchUserTickets = fetchUserTickets;
        this.fetchUserPassengers = fetchUserPassengers;
        this.fetchUserCounts = fetchUserCounts;
        this.httpSession = httpSession;
        this.cancelTicketService = cancelTicketService;
    }

    // Handles GET requests to "/dashboard"
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView user(Model model) {
        // Retrieves the userId from the HttpSession
        int userId = (Integer) httpSession.getAttribute("userId");
        logger.info("Displaying user dashboard for userId: {}", userId);
        // Constructs a ModelAndView object with the view name "UserDashBoard"
        ModelAndView mv = new ModelAndView("UserDashBoard");
        // Adds the user counts obtained from fetchUserCounts to the ModelAndView object
        mv.addObject("userCounts", fetchUserCounts.getUserCounts(userId));
        return mv;
    }

    // Handles GET requests to "/UserList"
    @RequestMapping(value = "/UserList", method = RequestMethod.GET)
    @ResponseBody
    public String UserDetailsController() {
        // Retrieves the userId from the HttpSession
        int userId = (Integer) httpSession.getAttribute("userId");
        logger.info("Fetching user details for userId: {}", userId);
        // Retrieves the user details in JSON format using fetchUser
        String userJson = fetchUser.getUserList(userId);
        return userJson;
    }

    // Handles POST requests to "/updateUser"
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public String Userupdate(@RequestBody User user) {
        logger.info("Updating user information: {}", user);
        // Updates the user information using fetchUser
        fetchUser.add(user);
        return "updatedSuccessfully";
    }

    // Handles GET requests to "/ticketList"
    @RequestMapping(value = "/ticketList", method = RequestMethod.GET)
    @ResponseBody
    public String allTicketsDetails() {
        // Retrieves the userId from the HttpSession
        int userId = (Integer) httpSession.getAttribute("userId");
        logger.info("Fetching all ticket details for userId: {}", userId);
        // Retrieves all ticket details for the user in JSON format using fetchUserTickets
        String userJson = fetchUserTickets.getticketList(userId);
        return userJson;
    }

    // Handles GET requests to "/pastticketList"
    @RequestMapping(value = "/pastticketList", method = RequestMethod.GET)
    @ResponseBody
    public String pastTicketsDetails() {
        // Retrieves the userId from the HttpSession
        int userId = (Integer) httpSession.getAttribute("userId");
        logger.info("Fetching past ticket details for userId: {}", userId);
        // Retrieves past ticket details for the user in JSON format using fetchUserTickets
        String userJson = fetchUserTickets.getPastTicketList(userId);
        return userJson;
    }

    // Handles GET requests to "/futureticketList"
    @RequestMapping(value = "/futureticketList", method = RequestMethod.GET)
    @ResponseBody
    public String futureTicketsDetails() {
        // Retrieves the userId from the HttpSession
        int userId = (Integer) httpSession.getAttribute("userId");
        logger.info("Fetching future ticket details for userId: {}", userId);
        // Retrieves future ticket details for the user in JSON format using fetchUserTickets
        String userJson = fetchUserTickets.getFutureTicketList(userId);
        return userJson;
    }

    // Handles GET requests to "/cancelticketList"
    @RequestMapping(value = "/cancelticketList", method = RequestMethod.GET)
    @ResponseBody
    public String cancelTicketsDetails() {
        // Retrieves the userId from the HttpSession
        int userId = (Integer) httpSession.getAttribute("userId");
        logger.info("Fetching cancel ticket details for userId: {}", userId);
        // Retrieves cancel ticket details for the user in JSON format using fetchUserTickets
        String userJson = fetchUserTickets.getCancelTicketList(userId);
        return userJson;
    }

    // Handles GET requests to "/ratingList"
    @RequestMapping(value = "/ratingList", method = RequestMethod.GET)
    @ResponseBody
    public String RatingDetails() {
        // Retrieves the userId from the HttpSession
        int userId = (Integer) httpSession.getAttribute("userId");
        logger.info("Fetching rating ticket details for userId: {}", userId);
        // Retrieves rating ticket details for the user in JSON format using fetchUserTickets
        String userJson = fetchUserTickets.getratingTicketList(userId);
        return userJson;
    }

    // Handles GET requests to "/passengersList"
    @RequestMapping(value = "/passengersList", method = RequestMethod.GET)
    @ResponseBody
    public String passengersDetails() {
        // Retrieves the userId from the HttpSession
        int userId = (Integer) httpSession.getAttribute("userId");
        logger.info("Fetching passengers list for userId: {}", userId);
        // Retrieves passengers list for the user in JSON format using fetchUserPassengers
        String userJson = fetchUserPassengers.getPassengersList(userId);
        return userJson;
    }

    // Handles POST requests to "/deletePassenger"
    @RequestMapping(value = "/deletePassenger", method = RequestMethod.POST)
    @ResponseBody
    public String deletepassengersDetails(@RequestBody UserPassengers userpass) {
        logger.info("Deleting user passenger details: {}", userpass);
        // Deletes the user passenger details using fetchUserPassengers
        fetchUserPassengers.deleteUserpassengers(userpass);
        return "deleteSuccess";
    }

    // Handles POST requests to "/addPassenger"
    @RequestMapping(value = "/addPassenger", method = RequestMethod.POST)
    @ResponseBody
    public String addPassengersDetails(@RequestBody UserPassengers userpass) {
        logger.info("Adding user passenger details: {}", userpass);
        // Adds the user passenger details using fetchUserPassengers
        fetchUserPassengers.addUserpassengers(userpass);
        return "addSuccess";
    }

    // Handles POST requests to "/cancelTicket"
    @RequestMapping(value = "/cancelTicket", method = RequestMethod.POST)
    @ResponseBody
    public String cancelTicket(String booking_id, String payment_id, Integer fare) {
        logger.info("Canceling ticket with booking_id: {}, payment_id: {}, fare: {}", booking_id, payment_id, fare);
        String refund_id = null;
        try {
            refund_id = cancelTicketService.refund(booking_id, payment_id, fare);
            cancelTicketService.cancelTicket(booking_id, refund_id);
            return "Your Refund has been processed.\n" + refund_id + "\ncancelTicketSuccess";
        } catch (RazorpayException e1) {
            logger.error("Failed to cancel ticket with booking_id: {}, payment_id: {}", booking_id, payment_id, e1);
            return "\ncancelTicketFailed";
        }
    }

    // Handles POST requests to "/updateRatingList"
    @RequestMapping(value = "/updateRatingList", method = RequestMethod.POST)
    @ResponseBody
    public String UpdateRatingDetails(@RequestBody Ticket ratingSubmission) {
        // Retrieves the userId from the HttpSession
        int userId = (Integer) httpSession.getAttribute("userId");
        logger.info("Updating rating details for userId: {}, ratingSubmission: {}", userId, ratingSubmission);
        // Updates the rating ticket details for the user using fetchUserTickets
        fetchUserTickets.updateRatingTicketList(userId, ratingSubmission);
        return "updated";
    }
}
