package com.avengers.bus.dao.implementation;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.contracts.BusListDAO;
import com.avengers.bus.models.dtoModels.BusListRowMapper;
import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.inputModels.SearchBusInput;

@Component
public class BusListDaoImpl implements BusListDAO {

	private JdbcTemplate jdbcTemplate;
	private final String BUS_LIST_QUERY = "select  (t5.fare*bsty_farefactor) as seat_fare,((t5.fare*bsty_farefactor)+((t5.fare*bsty_farefactor)/2)) as berth_fare,t1.service_id, t1.trip_id, t2.source, t2.destination , t2.depature , t2.arrival,t1.trip_date,\r\n"
			+ "t1.seats_available,t4.bsty_title, t4.bsty_desc from btrs_services t1,\r\n"
			+ "(select ts1.trip_id as trip_id ,ts1.stop_id as source , ts2.stop_id as destination , ts1.stop_time as Depature ,\r\n"
			+ "ts2.stop_time as arrival from btrs_trip_stops ts1, btrs_trip_stops ts2 \r\n"
			+ "where ts1.trip_id=ts2.trip_id and ts1.stop_id=? and ts2.stop_id=? and ts1.stop_index<ts2.stop_index ) t2,\r\n"
			+ "btrs_trips t3, btrs_bustypes t4,\r\n"
			+ "(select * from btrs_distance_fares where distance_limit>(select distance from btrs_stp_distances where source=? and destination=?) limit 1)t5\r\n"
			+ "where (t1.trip_id=t2.trip_id and t1.trip_id=t3.trip_id and t1.trip_date = ? \r\n"
			+ "and t3.bus_type =t4.bsty_id and t1.seats_available>0 and t1.trip_date <> now()::date and t4.bsty_id=?)\r\n"
			+ "or (t1.trip_id=t2.trip_id and t1.trip_id=t3.trip_id and t1.trip_date = ?\r\n"
			+ "and t3.bus_type =t4.bsty_id and t1.seats_available>0 and t1.trip_date = now()::date  and t2.depature>now()  :: time and t4.bsty_id=?)";

	private final String BUS_LIST_ALL_QUERY = "select  (t5.fare*bsty_farefactor) as seat_fare,((t5.fare*bsty_farefactor)+((t5.fare*bsty_farefactor)/2)) as berth_fare,t1.service_id, t1.trip_id, t2.source, t2.destination , t2.depature , t2.arrival,t1.trip_date,\r\n"
			+ "t1.seats_available,t4.bsty_title, t4.bsty_desc from btrs_services t1,\r\n"
			+ "(select ts1.trip_id as trip_id ,ts1.stop_id as source , ts2.stop_id as destination , ts1.stop_time as Depature ,\r\n"
			+ "ts2.stop_time as arrival from btrs_trip_stops ts1, btrs_trip_stops ts2\r\n"
			+ "where ts1.trip_id=ts2.trip_id and ts1.stop_id=? and ts2.stop_id=? and ts1.stop_index<ts2.stop_index ) t2,\r\n"
			+ "btrs_trips t3, btrs_bustypes t4,\r\n"
			+ "(select * from btrs_distance_fares where distance_limit>(select distance from btrs_stp_distances where source=? and destination=?) limit 1)t5\r\n"
			+ "where (t1.trip_id=t2.trip_id and t1.trip_id=t3.trip_id and t1.trip_date = ?\r\n"
			+ "and t3.bus_type =t4.bsty_id and t1.seats_available>0 and t1.trip_date <> now()::date ) or\r\n"
			+ "(t1.trip_id=t2.trip_id and t1.trip_id=t3.trip_id and t1.trip_date = ?\r\n"
			+ "and t3.bus_type =t4.bsty_id and t1.seats_available>0 and t1.trip_date = now()::date  and t2.depature>now()  :: time)";

	public BusListDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// This will get all the busList based on specific bus type
	@Override
	public List<BusSearchListDto> getBusList(SearchBusInput sbi) {

		String date = sbi.getDate();
		Date sqlDate = Date.valueOf(date);

		System.out.println(sbi);
		return jdbcTemplate.query(BUS_LIST_QUERY, new Object[] { sbi.getFssId(), sbi.getTssId(), sbi.getFssId(),
				sbi.getTssId(), sqlDate, sbi.getTravelClass(), sqlDate, sbi.getTravelClass() }, new BusListRowMapper());
	}

	// this will return all the buslist
	@Override
	public List<BusSearchListDto> getBusListAll(SearchBusInput sbi) {
		String date = sbi.getDate();
		Date sqlDate = Date.valueOf(date);
		return jdbcTemplate.query(BUS_LIST_ALL_QUERY,
				new Object[] { sbi.getFssId(), sbi.getTssId(), sbi.getFssId(), sbi.getTssId(), sqlDate, sqlDate },
				new BusListRowMapper());
	}
}