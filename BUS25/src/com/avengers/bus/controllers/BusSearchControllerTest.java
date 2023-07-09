package com.avengers.bus.controllers;

import com.avengers.bus.dao.contracts.BusSearchDAO;
import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.entityModels.BusTypes;
import com.avengers.bus.models.entityModels.SeatsBookedForOneService;
import com.avengers.bus.models.entityModels.Stations;
import com.avengers.bus.models.inputModels.SearchBusInput;
import com.avengers.bus.services.contracts.BusListService;
import com.avengers.bus.services.contracts.BusTypeService;
import com.avengers.bus.services.contracts.StationService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BusSearchControllerTest {

    @Mock
    private StationService stationService;

    @Mock
    private BusTypeService busTypeService;

    @Mock
    private BusSearchDAO busSearchDAO;

    @Mock
    private BusListService busListService;

    @Mock
    private Model model;

    @InjectMocks
    private BusSearchController busSearchController;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSearchPage() {
        List<Stations> stationsList = new ArrayList<>();
        List<BusTypes> busTypesList = new ArrayList<>();

        when(stationService.listAll()).thenReturn(stationsList);
        when(busTypeService.listAll()).thenReturn(busTypesList);

        String result = busSearchController.getSearchPage(model);

        assert result.equals("home");
        verify(stationService, times(1)).listAll();
        verify(busTypeService, times(1)).listAll();
        verify(model, times(1)).addAttribute("stationList", stationsList);
        verify(model, times(1)).addAttribute("busTypeList", busTypesList);
    }

    @Test
    public void testGetServicesList() {
        SearchBusInput sbi = new SearchBusInput();
        List<BusSearchListDto> buses = new ArrayList<>();

        when(busListService.getBusList(sbi)).thenReturn(buses);

        String result = busSearchController.getServicesList(sbi, model);

        assert result.equals("busList");
        verify(busListService, times(1)).getBusList(sbi);
        verify(model, times(1)).addAttribute("buses", buses);
    }

    @Test
    public void testGetBusLayout() {
        BusSearchListDto bus = new BusSearchListDto();
        List<SeatsBookedForOneService> seatsList = new ArrayList<>();

        when(busSearchDAO.getBookedSeats(bus.getService_id())).thenReturn(seatsList);

        String result = busSearchController.getBusLayout(bus, model);

        assert result.equals("busLayout");
        verify(busSearchDAO, times(1)).getBookedSeats(bus.getService_id());
        verify(model, times(1)).addAttribute("sl", seatsList);
        verify(model, times(1)).addAttribute("selectedBusDetails", bus);
    }

    @Test
    public void testAbout() {
        String result = busSearchController.about();

        assert result.equals("aboutUs");
    }

    @Test
    public void testContact() {
        String result = busSearchController.contact();

        assert result.equals("contactUs");
    }
}
