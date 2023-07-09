package com.avengers.bus.controllers;

import com.avengers.bus.models.entityModels.Ticket;
import com.avengers.bus.models.entityModels.User;
import com.avengers.bus.models.entityModels.UserPassengers;
import com.avengers.bus.models.viewModels.UserCounts;
import com.avengers.bus.services.contracts.CancelTicketService;
import com.avengers.bus.services.contracts.FetchUser;
import com.avengers.bus.services.contracts.FetchUserCounts;
import com.avengers.bus.services.contracts.FetchUserPassengers;
import com.avengers.bus.services.contracts.FetchUserTickets;
import com.razorpay.RazorpayException;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class UserProfileControllerTest {

    @Mock
    private FetchUser fetchUser;

    @Mock
    private FetchUserTickets fetchUserTickets;

    @Mock
    private FetchUserPassengers fetchUserPassengers;

    @Mock
    private FetchUserCounts fetchUserCounts;

    @Mock
    private CancelTicketService cancelTicketService;

    @Mock
    private Model model;

    @InjectMocks
    private UserProfileController userProfileController;

    private MockHttpSession mockHttpSession;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute("userId", 123);
    }

    @Test
    public void testAdmin() {
        int userId = 123;
        UserCounts uc=new UserCounts(userId, userId, userId, "Streak", userId);
        when(fetchUserCounts.getUserCounts(userId)).thenReturn(uc);

        ModelAndView result = userProfileController.admin(model);

        assert result.equals("UserDashBoard");
        verify(fetchUserCounts, times(1)).getUserCounts(userId);
        verify(model, times(1)).addAttribute("userCounts", "User Counts");
    }

    // Write similar tests for other methods of UserProfileController

    // Example test for UserDetailsController
    @Test
    public void testUserDetailsController() {
        int userId = 123;
        String expectedJson = "User Details JSON";

        when(fetchUser.getUserList(userId)).thenReturn(expectedJson);

        String result = userProfileController.UserDetailsController();

        assert result.equals(expectedJson);
        verify(fetchUser, times(1)).getUserList(userId);
    }

    // Example test for Userupdate
    @Test
    public void testUserupdate() {
        User user = new User();
        String expectedResponse = "updatedSuccessfully";

        String result = userProfileController.Userupdate(user);

        assert result.equals(expectedResponse);
        verify(fetchUser, times(1)).add(user);
    }

    // Example test for allTicketsDetails
    @Test
    public void testAllTicketsDetails() {
        int userId = 123;
        String expectedJson = "All Tickets Details JSON";

        when(fetchUserTickets.getticketList(userId)).thenReturn(expectedJson);

        String result = userProfileController.allTicketsDetails();

        assert result.equals(expectedJson);
        verify(fetchUserTickets, times(1)).getticketList(userId);
    }

    // Example test for pastTicketsDetails
    @Test
    public void testPastTicketsDetails() {
        int userId = 123;
        String expectedJson = "Past Tickets Details JSON";

        when(fetchUserTickets.getPastTicketList(userId)).thenReturn(expectedJson);

        String result = userProfileController.pastTicketsDetails();

        assert result.equals(expectedJson);
        verify(fetchUserTickets, times(1)).getPastTicketList(userId);
    }

    // Example test for futureTicketsDetails
    @Test
    public void testFutureTicketsDetails() {
        int userId = 123;
        String expectedJson = "Future Tickets Details JSON";

        when(fetchUserTickets.getFutureTicketList(userId)).thenReturn(expectedJson);

        String result = userProfileController.futureTicketsDetails();

        assert result.equals(expectedJson);
        verify(fetchUserTickets, times(1)).getFutureTicketList(userId);
    }

    // Example test for cancelTicketsDetails
    @Test
    public void testCancelTicketsDetails() {
        int userId = 123;
        String expectedJson = "Cancel Tickets Details JSON";

        when(fetchUserTickets.getCancelTicketList(userId)).thenReturn(expectedJson);

        String result = userProfileController.cancelTicketsDetails();

        assert result.equals(expectedJson);
        verify(fetchUserTickets, times(1)).getCancelTicketList(userId);
    }

    // Example test for RatingDetails
    @Test
    public void testRatingDetails() {
        int userId = 123;
        String expectedJson = "Rating Details JSON";

        when(fetchUserTickets.getratingTicketList(userId)).thenReturn(expectedJson);

        String result = userProfileController.RatingDetails();

        assert result.equals(expectedJson);
        verify(fetchUserTickets, times(1)).getratingTicketList(userId);
    }

    // Example test for passengersDetails
    @Test
    public void testPassengersDetails() {
        int userId = 123;
        String expectedJson = "Passengers Details JSON";

        when(fetchUserPassengers.getPassengersList(userId)).thenReturn(expectedJson);

        String result = userProfileController.passengersDetails();

        assert result.equals(expectedJson);
        verify(fetchUserPassengers, times(1)).getPassengersList(userId);
    }

    // Example test for deletepassengersDetails
    @Test
    public void testDeletepassengersDetails() {
        UserPassengers userPassengers = new UserPassengers();

        String result = userProfileController.deletepassengersDetails(userPassengers);

        assert result.equals("deleteSuccess");
        verify(fetchUserPassengers, times(1)).deleteUserpassengers(userPassengers);
    }

    // Example test for addPassengersDetails
    @Test
    public void testAddPassengersDetails() {
        UserPassengers userPassengers = new UserPassengers();

        String result = userProfileController.addPassengersDetails(userPassengers);

        assert result.equals("addSuccess");
        verify(fetchUserPassengers, times(1)).addUserpassengers(userPassengers);
    }

    // Example test for cancelTicket
    @Test
    public void testCancelTicket() throws RazorpayException {
        String bookingId = "123";
        String paymentId = "456";
        int fare = 100;

        String expectedResponse = "Your Refund has been processed.\nrefundId\ncancelTicketSuccess";

        when(cancelTicketService.refund(bookingId, paymentId, fare)).thenReturn("refundId");

        String result = userProfileController.cancelTicket(bookingId, paymentId, fare);

        assert result.equals(expectedResponse);
        verify(cancelTicketService, times(1)).refund(bookingId, paymentId, fare);
        verify(cancelTicketService, times(1)).cancelTicket(bookingId, "refundId");
    }

    // Example test for UpdateRatingDetails
    @Test
    public void testUpdateRatingDetails() {
        Ticket ratingSubmission = new Ticket();
        int userId = 123;

        String result = userProfileController.UpdateRatingDetails(ratingSubmission);

        assert result.equals("updated");
        verify(fetchUserTickets, times(1)).updateRatingTicketList(userId, ratingSubmission);
    }
}
