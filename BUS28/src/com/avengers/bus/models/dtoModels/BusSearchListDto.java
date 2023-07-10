package com.avengers.bus.models.dtoModels;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

public class BusSearchListDto {

	private int service_id;
	private int trip_id;
	private String source;
	private String destination;
	private Date trip_date;
	private Time depature;
	private Time arrival;
	private String bsty_title;
	private int available_seats;
	private double seat_fare;
	private double berth_fare;
	private Duration duration;

	public int getService_id() {
		return service_id;
	}

	public String getDuration() {

		LocalTime localTime1 = depature.toLocalTime();
		LocalTime localTime2 = arrival.toLocalTime();

		// Calculate the duration between two LocalTime objects
		Duration duration;
		if (localTime2.isAfter(localTime1)) {
			duration = Duration.between(localTime1, localTime2);
		} else {
			duration = Duration.between(localTime1, LocalTime.MAX).plus(Duration.between(LocalTime.MIN, localTime2))
					.plusMinutes(1);
		}

		// Get the time difference in hours and minutes
		long hours = duration.toHours();
		long minutes = duration.toMinutes() % 60;

		// Format the output with leading zeros
		String formattedHours = String.format("%02d", hours);
		String formattedMinutes = String.format("%02d", minutes);

		return formattedHours + " : " + formattedMinutes;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getTrip_date() {
		return trip_date;
	}

	public void setTrip_date(String trip_date) {
		this.trip_date = Date.valueOf(trip_date);
	}

	public Time getDepature() {
		return depature;
	}

	public void setDepature(String depature) {
		this.depature = Time.valueOf(depature);
	}

	public Time getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = Time.valueOf(arrival);
	}

	public String getBsty_title() {
		return bsty_title;
	}

	public void setBsty_title(String bsty_title) {
		this.bsty_title = bsty_title;
	}

	public int getAvailable_seats() {
		return available_seats;
	}

	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}

	public double getSeat_fare() {
		return seat_fare;
	}

	public void setSeat_fare(double seat_fare) {
		this.seat_fare = seat_fare;
	}

	public double getBerth_fare() {
		return berth_fare;
	}

	public void setBerth_fare(double berth_fare) {
		this.berth_fare = berth_fare;
	}

	@Override
	public String toString() {
		return "BusSearchListDto [service_id=" + service_id + ", trip_id=" + trip_id + ", source=" + source
				+ ", destination=" + destination + ", trip_date=" + trip_date + ", depature=" + depature + ", arrival="
				+ arrival + ", bsty_title=" + bsty_title + ", available_seats=" + available_seats + ", seat_fare="
				+ seat_fare + ", berth_fare=" + berth_fare + "]";
	}

}