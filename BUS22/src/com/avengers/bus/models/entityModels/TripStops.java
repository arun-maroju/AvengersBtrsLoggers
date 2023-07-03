package com.avengers.bus.models.entityModels;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_trip_stops")
public class TripStops {

	@Id
	@Column(name = "trip_id")
	private int trip_id;

	@Override
	public String toString() {
		return "TripStops [trip_id=" + trip_id + ", stop_id=" + stop_id + ", stop_index=" + stop_index + ", stop_time="
				+ stop_time + "]";
	}

	public int getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}

	public String getStop_id() {
		return stop_id;
	}

	public void setStop_id(String stop_id) {
		this.stop_id = stop_id;
	}

	public int getStop_index() {
		return stop_index;
	}

	public void setStop_index(int stop_index) {
		this.stop_index = stop_index;
	}

	public Time getStop_time() {
		return stop_time;
	}

	public void setStop_time(Time stop_time) {
		this.stop_time = stop_time;
	}

	@Column(name = "stop_id")
	private String stop_id;
	@Column(name = "stop_index")
	private int stop_index;
	@Column(name = "stop_time")
	private Time stop_time;

}
