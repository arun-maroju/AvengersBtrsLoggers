package com.avengers.bus.models.dtoModels;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import com.avengers.bus.models.inputModels.Passengers;

public class Ticket {

	private String ticketNo;
	private Date journey_date;
	private Time departure_time;
	private Time arrival_time;
	private int numberOfPassengers;
	private List<Passengers> passengers;
	private double totalFare;
	private String payment_id;
	private String from;
	private String to;
	private int service_no;
	private int trip_no;
	private String bus_type;
	private String order_id;
	
	private Duration duration;
	
	public String getDuration() {

		LocalTime localTime1 = departure_time.toLocalTime();
		LocalTime localTime2 = arrival_time.toLocalTime();

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

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Date getJourney_date() {
		return journey_date;
	}

	public void setJourney_date(Date journey_date) {
		this.journey_date = journey_date;
	}

	public Time getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(Time departure_time) {
		this.departure_time = departure_time;
	}

	public Time getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(Time arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public List<Passengers> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}

	public int getTotalFare() {
		return (int) totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getService_no() {
		return service_no;
	}

	public void setService_no(int service_no) {
		this.service_no = service_no;
	}

	public int getTrip_no() {
		return trip_no;
	}

	public void setTrip_no(int trip_no) {
		this.trip_no = trip_no;
	}

	public String getBus_type() {
		return bus_type;
	}

	public void setBus_type(String bus_type) {
		this.bus_type = bus_type;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "Ticket [ticketNo=" + ticketNo + ", journey_date=" + journey_date + ", departure_time=" + departure_time
				+ ", arrival_time=" + arrival_time + ", numberOfPassengers=" + numberOfPassengers + ", passengers="
				+ passengers + ", totalFare=" + totalFare + ", payment_id=" + payment_id + ", from=" + from + ", to="
				+ to + ", service_no=" + service_no + ", trip_no=" + trip_no + ", bus_type=" + bus_type + ", order_id="
				+ order_id + "]";
	}

}