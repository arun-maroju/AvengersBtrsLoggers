//package com.avengers.bus.services.implementation;
//
//
//import static org.mockito.Mockito.*;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.avengers.bus.models.dtoModels.BusSearchListDto;
//import com.avengers.bus.models.dtoModels.Ticket;
//import com.avengers.bus.models.inputModels.PassengerList;
//import com.avengers.bus.models.inputModels.Passengers;
//import com.avengers.bus.services.implementation.TicketDetailsImpl;
//
//public class TicketDetailsImplTest {
//
//    private TicketDetailsImpl ticketDetails;
//
//    @BeforeMethod
//    public void setUp() {
//        ticketDetails = new TicketDetailsImpl();
//    }
//
//    @Test
//    public void testGenerateTicketDetails() {
//        // Arrange
//        PassengerList passengers = new PassengerList();
//        passengers.setPassenger_id(new String[] { "P1", "P2" });
//        passengers.setSeat_number(new int[] { 1, 2 });
//        passengers.setPassenger_name(new String[] { "Passenger 1", "Passenger 2" });
//        passengers.setPassenger_age(new int[] { 25, 30 });
//        passengers.setPassenger_gender(new String[] { "Male", "Female" });
//
//        BusSearchListDto bus = new BusSearchListDto();
//        bus.setSource("Source");
//        bus.setDestination("Destination");
//        bus.setBsty_title("Bus Type");
//        bus.setTrip_date("2-7-2023");
//        bus.setDepature("09:00 AM");
//        bus.setArrival("12:00 PM");
//        bus.setService_id(911);
//        bus.setTrip_id(1001);
//        bus.setSeat_fare(200.0);
//        bus.setBerth_fare(300.0);
//
//        // Mock the logger, not necessary in this test, but shown for completeness
//        // Logger logger = LoggerFactory.getLogger(TicketDetailsImpl.class);
//
//        // Act
//        Ticket result = ticketDetails.generateTicketDetails(passengers, bus);
//
//        // Assert
//        Assert.assertNotNull(result);
//        Assert.assertEquals(result.getTo(), "Destination");
//        Assert.assertEquals(result.getFrom(), "Source");
//        Assert.assertEquals(result.getBus_type(), "Bus Type");
//        Assert.assertEquals(result.getJourney_date(), "2-7-2023");
//        Assert.assertEquals(result.getDeparture_time(), "09:00 AM");
//        Assert.assertEquals(result.getArrival_time(), "12:00 PM");
//        Assert.assertEquals(result.getService_no(), 911);
//        Assert.assertEquals(result.getTrip_no(), 1001);
//        Assert.assertEquals(result.getNumberOfPassengers(), 2);
//        Assert.assertEquals(result.getTotalFare(), 500.0); // (200 + 300)
//        Assert.assertEquals(result.getPassengers().size(), 2);
//
//        Passengers passenger1 = result.getPassengers().get(0);
//        Assert.assertEquals(passenger1.getPassenger_id(), "P1");
//        Assert.assertEquals(passenger1.getSeat_id(), 1);
//        Assert.assertEquals(passenger1.getPassenger_name(), "Passenger 1");
//        Assert.assertEquals(passenger1.getPassenger_age(), 25);
//        Assert.assertEquals(passenger1.getPassenger_gender(), "Male");
//        Assert.assertEquals(passenger1.getSeat_fare(), 200.0);
//
//        Passengers passenger2 = result.getPassengers().get(1);
//        Assert.assertEquals(passenger2.getPassenger_id(), "P2");
//        Assert.assertEquals(passenger2.getSeat_id(), 2);
//        Assert.assertEquals(passenger2.getPassenger_name(), "Passenger 2");
//        Assert.assertEquals(passenger2.getPassenger_age(), 30);
//        Assert.assertEquals(passenger2.getPassenger_gender(), "Female");
//        Assert.assertEquals(passenger2.getSeat_fare(), 300.0);
//    }
//}
//
