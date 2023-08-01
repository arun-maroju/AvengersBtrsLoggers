//package com.avengers.bus.services.implementation;
//
//import com.avengers.bus.dao.contracts.BusSearchDAO;
//import com.avengers.bus.models.entityModels.BusTypes;
//import com.avengers.bus.services.implementation.BusTypeServiceImpl;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.slf4j.Logger;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.testng.Assert.*;
//
//public class BusTypeServiceImplTest {
//
//    @Mock
//    private BusSearchDAO busSearchDAOMock;
//
//    @InjectMocks
//    private BusTypeServiceImpl busTypeService;
//
//    @BeforeMethod
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testListAll() {
//        // Arrange
//        List<BusTypes> expectedBusTypes = new ArrayList<>();
//        when(busSearchDAOMock.getAllBusTypes()).thenReturn(expectedBusTypes);
//
//        // Act
//        List<BusTypes> result = busTypeService.listAll();
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(result, expectedBusTypes);
//        verify(busSearchDAOMock,times(1)).getAllBusTypes();
//    }
//    
//    
//    @Test
//    public void testListAll_ReturnsMultipleBusTypes() {
//        // Arrange
//        List<BusTypes> expectedBusTypes = Arrays.asList(
//                createBusType(1, "AC Sleeper", "AC Sleeper Bus", 1.0),
//                createBusType(2, "Non-AC Seater", "Non-AC Seater Bus", 0.8),
//                createBusType(3, "Volvo", "Volvo Bus", 1.2)
//        );
//        when(busSearchDAOMock.getAllBusTypes()).thenReturn(expectedBusTypes);
//
//        // Act
//        List<BusTypes> result = busTypeService.listAll();
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(result.size(), expectedBusTypes.size());
//        assertEquals(result, expectedBusTypes);
//        verify(busSearchDAOMock).getAllBusTypes();
//    }
//
//    private BusTypes createBusType(int id, String title, String desc, Double fareFactor) {
//        BusTypes busType = new BusTypes();
//        busType.setBsty_id(id);
//        busType.setBsty_title(title);
//        busType.setBsty_desc(desc);
//        busType.setBsty_farefactor(fareFactor);
//        return busType;
//    }
//    
//    @Test
//    public void testListAll_NoBusTypes() {
//        // Arrange
//        List<BusTypes> expectedBusTypes = new ArrayList<>();
//        when(busSearchDAOMock.getAllBusTypes()).thenReturn(expectedBusTypes);
//
//        // Act
//        List<BusTypes> result = busTypeService.listAll();
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(expectedBusTypes.size(), result.size());
//        assertEquals(expectedBusTypes, result);
//
//        verify(busSearchDAOMock,times(1)).getAllBusTypes();
//    }
//
//    @Test
//    public void testListAll_NullBusTypes() {
//        // Arrange
//        when(busSearchDAOMock.getAllBusTypes()).thenReturn(null);
//
//        // Act
//        List<BusTypes> result = busTypeService.listAll();
//
//        // Assert
//        assertNull(result);
//        verify(busSearchDAOMock,times(1)).getAllBusTypes();
//    }
//}
