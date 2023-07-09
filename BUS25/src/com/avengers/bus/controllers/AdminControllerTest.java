package com.avengers.bus.controllers;



import com.avengers.bus.dao.contracts.ServiceGenerationDAO;
import com.avengers.bus.models.viewModels.AdminCounts;
import com.avengers.bus.services.contracts.AdminCountsService;
import com.avengers.bus.services.contracts.FetchDetails;
import com.avengers.bus.services.contracts.FetchGraphData;
import com.avengers.bus.services.contracts.FetchList;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class AdminControllerTest {

    @Mock
    private AdminCountsService adminCountsService;

    @Mock
    private FetchDetails fetchDetails;

    @Mock
    private FetchList fetchList;

    @Mock
    private FetchGraphData fetchGraphData;

    @Mock
    private ServiceGenerationDAO serviceGenerationDAO;

    @Mock
    private Model model;

    @InjectMocks
    private AdminController adminController;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdmin() {
        ModelAndView modelAndView = new ModelAndView("AdminDashboard");
        AdminCounts ac=new AdminCounts(0, 0, 0, 0, 0, 0, 0, 0);
        
        when(adminCountsService.getCounts()).thenReturn(ac);

        ModelAndView result = adminController.admin(model);

        assert result.getViewName().equals(modelAndView.getViewName());
        assert result.getModel().get("counts").equals("Counts");
        verify(adminCountsService, times(1)).getCounts();
    }

    @Test
    public void testGetServiceList() {
        int page = 1;
        int records = 10;
        String expectedJson = "Service List JSON";

        when(fetchList.getServiceList(page, records)).thenReturn(expectedJson);

        String result = adminController.getServiceList(page, records);

        assert result.equals(expectedJson);
        verify(fetchList, times(1)).getServiceList(page, records);
    }

    @Test
    public void testGetRoutesList() {
        String expectedJson = "Route List JSON";

        when(fetchList.getRouteList()).thenReturn(expectedJson);

        String result = adminController.getRoutesList();

        assert result.equals(expectedJson);
        verify(fetchList, times(1)).getRouteList();
    }

    @Test
    public void testGetBusesList() {
        String expectedJson = "Bus List JSON";

        when(fetchList.getBusList()).thenReturn(expectedJson);

        String result = adminController.getBusesList();

        assert result.equals(expectedJson);
        verify(fetchList, times(1)).getBusList();
    }

    @Test
    public void testGetTicketsList() {
        String expectedJson = "Ticket List JSON";

        when(fetchList.getTicketList()).thenReturn(expectedJson);

        String result = adminController.getTicketsList();

        assert result.equals(expectedJson);
        verify(fetchList, times(1)).getTicketList();
    }

    @Test
    public void testGetRefundsList() {
        String expectedJson = "Refund List JSON";

        when(fetchList.getRefundsList()).thenReturn(expectedJson);

        String result = adminController.getRefundsList();

        assert result.equals(expectedJson);
        verify(fetchList, times(1)).getRefundsList();
    }

    @Test
    public void testGetTicketPassengerList() {
        String serviceId = "123";
        String expectedJson = "Passenger List JSON";

        when(fetchList.getTicketPassengerList(serviceId)).thenReturn(expectedJson);

        String result = adminController.getTicketPassengerList(serviceId);

        assert result.equals(expectedJson);
        verify(fetchList, times(1)).getTicketPassengerList(serviceId);
    }

    @Test
    public void testGetServiceDetails() {
        String serviceId = "123";
        String expectedJson = "Service Details JSON";

        when(fetchDetails.getServiceDetails(serviceId)).thenReturn(expectedJson);

        String result = adminController.getServiceDetails(serviceId);

        assert result.equals(expectedJson);
        verify(fetchDetails, times(1)).getServiceDetails(serviceId);
    }

    @Test
    public void testGetRouteDetails() {
        String routeNumber = "ABC";
        String expectedJson = "Route Details JSON";

        when(fetchDetails.getRouteDetails(routeNumber)).thenReturn(expectedJson);

        String result = adminController.getRouteDetails(routeNumber);

        assert result.equals(expectedJson);
        verify(fetchDetails, times(1)).getRouteDetails(routeNumber);
    }

    @Test
    public void testGetRouteCollection() {
        String expectedJson = "Route Collection JSON";

        when(fetchGraphData.getRouteCollection()).thenReturn(expectedJson);

        String result = adminController.getRoute();

        assert result.equals(expectedJson);
        verify(fetchGraphData, times(1)).getRouteCollection();
    }

    @Test
    public void testGetTripCollection() {
        String expectedJson = "Trip Collection JSON";

        when(fetchGraphData.getTripCollection()).thenReturn(expectedJson);

        String result = adminController.getTrip();

        assert result.equals(expectedJson);
        verify(fetchGraphData, times(1)).getTripCollection();
    }

    @Test
    public void testGetMonthlyCollection() {
        String expectedJson = "Monthly Collection JSON";

        when(fetchGraphData.getMonthlyCollection()).thenReturn(expectedJson);

        String result = adminController.getMonthlycollection();

        assert result.equals(expectedJson);
        verify(fetchGraphData, times(1)).getMonthlyCollection();
    }
}

