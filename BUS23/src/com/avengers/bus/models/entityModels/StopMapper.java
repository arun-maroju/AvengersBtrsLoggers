package com.avengers.bus.models.entityModels;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StopMapper implements RowMapper<Stop> {
	@Override
	public Stop mapRow(ResultSet rs, int rowNum) throws SQLException {
		Stop stop = new Stop();
		stop.setStop_id(rs.getString("stop_id"));
		stop.setStop_name(rs.getString("stop_name"));
		return stop;
	}
}
