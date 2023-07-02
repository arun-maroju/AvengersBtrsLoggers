package com.avengers.bus.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.dtoModels.Ticket;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.entityModels.UserPassengers;
import com.avengers.bus.models.inputModels.PassengerList;
import com.avengers.bus.models.inputModels.PaymentDetails;
import com.avengers.bus.models.inputModels.SelectedSeatsDetails;
import com.avengers.bus.services.contracts.CancelTicketService;
import com.avengers.bus.services.contracts.CheckSeat;
import com.avengers.bus.services.contracts.SaveTicketService;
import com.avengers.bus.services.contracts.TicketDetails;
import com.avengers.bus.services.contracts.UserPassengersService;
import com.avengers.bus.services.implementation.TicketMail;
import com.avengers.bus.utilities.exceptions.TicketNotPersistedException;

@Controller
public class BookingController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	private UserPassengersService userPassengersService;
	private SaveTicketService saveTicketService;
	private HttpSession httpSession;
	private TicketDetails ticketDetails;
	private CheckSeat checkSeat;
	private CancelTicketService cancelTicketService;

	// constructor auto-wiring
	@Autowired
	public BookingController(UserPassengersService userPassengersService, SaveTicketService saveTicketService,
			HttpSession httpSession, TicketDetails ticketDetails, CheckSeat checkSeat,
			CancelTicketService cancelTicketService) {
		super();
		this.userPassengersService = userPassengersService;
		this.saveTicketService = saveTicketService;
		this.httpSession = httpSession;
		this.ticketDetails = ticketDetails;
		this.checkSeat = checkSeat;
		this.cancelTicketService = cancelTicketService;
	}

	// Handler method for displaying the passengers form
	@RequestMapping(value = "/passengers", method = RequestMethod.POST)
	public ModelAndView getPassengersForm(SelectedSeatsDetails ssd, BusSearchListDto bus) {
		logger.info("Received POST request to get passengers form.");
		int currentUserId = (Integer) httpSession.getAttribute("userId");
		List<UserPassengers> userList = userPassengersService.getAllUserPassengers(currentUserId);
		ModelAndView mav = new ModelAndView("passengers");
		// adding previously booked seats data
		mav.addObject("seatsData", ssd.getSeatsData());
		// number of seats selected by the user
		mav.addObject("count", ssd.getSeatsCount());
		// previously added passengers for that particular user
		mav.addObject("userList", userList);
		// bus details selected by the user
		mav.addObject("selectedBusDetails", bus);
		logger.info("Returning passengers form view.");
		return mav;
	}

	// Handler method for generating the ticket preview
	@RequestMapping(value = "passengerPreview", method = RequestMethod.POST)
	public ModelAndView getPreview(@Validated PassengerList passengers, BusSearchListDto bus) {
		logger.info("Received POST request to generate ticket preview.");
		Ticket ticket = ticketDetails.generateTicketDetails(passengers, bus);
		httpSession.setAttribute("ticket", ticket);
		// calling the ticketPreview view
		ModelAndView mav = new ModelAndView("ticketPreview");
		// sending all the details related to the preview ticket
		mav.addObject("ticket", ticket);
		logger.info("Returning ticket preview view.");
		return mav;
	}

	// Handler method for displaying the ticket confirmation page
	@RequestMapping(value = "confirm", method = RequestMethod.GET)
	public String showTicketConfirmation(Model model, PaymentDetails paymentDetails, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("Showing the ticket confirmation page.");
		Ticket ticket = (Ticket) httpSession.getAttribute("ticket");
		ticket.setTicketNo((String) httpSession.getAttribute("ticketNumber"));
		ticket.setPayment_id(paymentDetails.getPayment_id());
		User user = (User) httpSession.getAttribute("user");
		ticket.setOrder_id(paymentDetails.getOrder_id());
		boolean bookable = checkSeat.checkpersistability(ticket);
		if (!bookable) {
			logger.warn("Ticket is not persistable. Reason: " + bookable);
			cancelTicketService.refundAmount(ticket);
			return "bookingFailed";
		}
		// saving the ticket details to the database..
		try {
			saveTicketService.saveTheTicket(ticket, paymentDetails.getUser_id());
		} catch (TicketNotPersistedException e1) {
			e1.getMessage();
			System.out.println(e1.getTicket());
			return "bookingFailed";
		}
		try {
			// calling the email sending class with all the ticket details..
			TicketMail.sendEmail(request, response, ticket, (User) httpSession.getAttribute("user"));
			logger.info("Email sent successfully for ticket confirmation.");
		} catch (Exception e) {
			logger.error("Failed to send email for ticket confirmation. Error: " + e.getMessage(), e);
			e.printStackTrace();
		}
		logger.info("Returning ticket confirmation view.");
		return "confirm";
	}

	// @ExceptionHandler(TicketNotPersistedException.class)
	// public ResponseEntity ticketNotPersisted()
	// {
	//
	// }
}