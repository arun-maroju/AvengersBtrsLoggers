package com.avengers.bus.models.entityModels;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_services")
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int service_id;
	private int trip_id;
	private Date trip_date;
	private int seats_available;
	private int collection;

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public int getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}

	public Date getTrip_date() {
		return trip_date;
	}

	public void setTrip_date(Date trip_date) {
		this.trip_date = trip_date;
	}

	public int getSeats_available() {
		return seats_available;
	}

	public void setSeats_available(int seats_available) {
		this.seats_available = seats_available;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "Services [service_id=" + service_id + ", trip_id=" + trip_id + ", trip_date=" + trip_date
				+ ", seats_available=" + seats_available + ", collection=" + collection + "]";
	}

}
