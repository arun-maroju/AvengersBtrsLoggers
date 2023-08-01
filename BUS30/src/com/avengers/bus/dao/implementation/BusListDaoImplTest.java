// package com.avengers.bus.dao.implementation;
//
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;
//
// import java.sql.Date;
// import java.util.ArrayList;
// import java.util.List;
//
// import javax.sql.DataSource;
//
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.testng.Assert;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;
//
// import com.avengers.bus.dao.contracts.BusListDAO;
// import com.avengers.bus.models.dtoModels.BusListRowMapper;
// import com.avengers.bus.models.dtoModels.BusSearchListDto;
// import com.avengers.bus.models.inputModels.SearchBusInput;
//
// public class BusListDaoImplTest {
//
// @Mock
// private DataSource dataSource;
//
// @Mock
// private JdbcTemplate jdbcTemplate;
//
// @InjectMocks
// private BusListDAO busListDAO = new BusListDaoImpl(dataSource);
//
// @BeforeClass
// public void setUp() {
// MockitoAnnotations.initMocks(this);
// }
//
// @Test
// public void testGetBusList() {
// // Mocking the required objects and data
// SearchBusInput sbi = new SearchBusInput();
// sbi.setFssId("source");
// sbi.setTssId("destination");
// sbi.setDate("2023-07-14");
// sbi.setTravelClass(1);
//
// Date sqlDate = Date.valueOf(sbi.getDate());
//
// List<BusSearchListDto> busList = new ArrayList<>();
//
// // Mocking the JdbcTemplate behavior
// when(jdbcTemplate.query(anyString(), any(Object[].class), any(BusListRowMapper.class))).thenReturn(busList);
//
// // Calling the method to be tested
// List<BusSearchListDto> result = busListDAO.getBusList(sbi);
//
// // Verifying the method behavior and assertions
// verify(jdbcTemplate).query(anyString(), any(Object[].class), any(BusListRowMapper.class));
//
// Assert.assertEquals(result, busList);
// }
//
// @Test
// public void testGetBusListAll() {
// // Mocking the required objects and data
// SearchBusInput sbi = new SearchBusInput();
// sbi.setFssId("source");
// sbi.setTssId("destination");
// sbi.setDate("2023-07-14");
//
// Date sqlDate = Date.valueOf(sbi.getDate());
//
// List<BusSearchListDto> busList = new ArrayList<>();
//
// // Mocking the JdbcTemplate behavior
// when(jdbcTemplate.query(anyString(), any(Object[].class), any(BusListRowMapper.class))).thenReturn(busList);
//
// // Calling the method to be tested
// List<BusSearchListDto> result = busListDAO.getBusListAll(sbi);
//
// // Verifying the method behavior and assertions
// verify(jdbcTemplate).query(anyString(), any(Object[].class), any(BusListRowMapper.class));
//
// Assert.assertEquals(result, busList);
// }
// }
