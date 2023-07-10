package com.avengers.bus.models.dtoModels;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.avengers.bus.models.viewModels.Passenger;

public class UserTickets {
	private String booking_id;
	private String payment_id;
	private int user_id;
	private Date booking_date;
	private Time booking_time;
	private int trip_id;
	private int service_id;
	private String payment_mode;
	private double total_fare;
	private String status;
	private int no_of_seats_booked;
	private Date travel_date;
	private String source;
	private String destination;
	private Time departure;
	private List<Passenger> passengerList;

	public UserTickets() {
		super();
	}

	public UserTickets(String booking_id, String payment_id, int user_id, Date booking_date, Time booking_time,
			int trip_id, int service_id, String payment_mode, double total_fare, String status, int no_of_seats_booked,
			Date travel_date, String source, String destination, Time departure, List<Passenger> passengerList) {
		super();
		this.booking_id = booking_id;
		this.payment_id = payment_id;
		this.user_id = user_id;
		this.booking_date = booking_date;
		this.booking_time = booking_time;
		this.trip_id = trip_id;
		this.service_id = service_id;
		this.payment_mode = payment_mode;
		this.total_fare = total_fare;
		this.status = status;
		this.no_of_seats_booked = no_of_seats_booked;
		this.travel_date = travel_date;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.passengerList = passengerList;
	}

	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public Time getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(Time booking_time) {
		this.booking_time = booking_time;
	}

	public int getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public double getTotal_fare() {
		return total_fare;
	}

	public void setTotal_fare(double total_fare) {
		this.total_fare = total_fare;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNo_of_seats_booked() {
		return no_of_seats_booked;
	}

	public void setNo_of_seats_booked(int no_of_seats_booked) {
		this.no_of_seats_booked = no_of_seats_booked;
	}

	public Date getTravel_date() {
		return travel_date;
	}

	public void setTravel_date(Date travel_date) {
		this.travel_date = travel_date;
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

	public Time getDeparture() {
		return departure;
	}

	public void setDeparture(Time departure) {
		this.departure = departure;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "UserTickets [booking_id=" + booking_id + ", payment_id=" + payment_id + ", user_id=" + user_id
				+ ", booking_date=" + booking_date + ", booking_time=" + booking_time + ", trip_id=" + trip_id
				+ ", service_id=" + service_id + ", payment_mode=" + payment_mode + ", total_fare=" + total_fare
				+ ", status=" + status + ", no_of_seats_booked=" + no_of_seats_booked + ", travel_date=" + travel_date
				+ ", source=" + source + ", destination=" + destination + ", departure=" + departure
				+ ", passengerList=" + passengerList + "]";
	}

}