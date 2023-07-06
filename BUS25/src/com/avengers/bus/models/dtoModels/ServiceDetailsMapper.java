package com.avengers.bus.models.dtoModels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class ServiceDetailsMapper implements RowMapper<ServiceDetails> {
	@Override
	public ServiceDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		ServiceDetails serviceDetails = new ServiceDetails();

		serviceDetails.setServiceId(rs.getInt("service_id"));
		serviceDetails.setSource(rs.getString("source"));
		serviceDetails.setDestination(rs.getString("destination"));
		Time dep = rs.getTime("departure");
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		String departure = df.format(dep);

		Time ariv = rs.getTime("arrival");
		df = new SimpleDateFormat("HH:mm");
		String arrival = df.format(dep);

		Date td = rs.getDate("departure");
		df = new SimpleDateFormat("yyyy-MM-dd");
		String tripDate = df.format(dep);

		serviceDetails.setDeparture(departure);
		serviceDetails.setArrival(arrival);
		serviceDetails.setTripDate(tripDate);
		serviceDetails.setBusType(rs.getString("bus_type"));
		serviceDetails.setRouteId(rs.getInt("route_id"));
		serviceDetails.setCollection(rs.getString("collection"));
		serviceDetails.setSeatsAvailable(rs.getInt("seats_available"));
		serviceDetails.setSeatsBooked(rs.getInt("seats_booked"));
		serviceDetails.setBusTypeTitle(rs.getString("bsty_title"));
		serviceDetails.setBusTypeDescription(rs.getString("bsty_desc"));

		return serviceDetails;
	}
}
