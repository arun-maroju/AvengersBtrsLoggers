package com.avengers.bus.models.dtoModels;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicePassengerMapper implements RowMapper<ServicePassenger> {

    @Override
    public ServicePassenger mapRow(ResultSet rs, int rowNum) throws SQLException {
        ServicePassenger passenger = new ServicePassenger();
        passenger.setBooking_id(rs.getString("booking_id"));
        passenger.setSeat_no(rs.getInt("seat_no"));
        passenger.setPassenger_name(rs.getString("passenger_name"));
        passenger.setAge(rs.getInt("age"));
        passenger.setGender(rs.getString("gender"));
        return passenger;
    }
}
