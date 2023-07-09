package com.avengers.bus.models.entityModels;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_tickets")
public class Ticket {

	@Id
	private String booking_id;
	private String payment_id;
	private String refund_id;
	private int user_id;
	private Date booking_date;
	private Time booking_time;
	private int trip_id;
	private int service_id;
	private String payment_mode;
	private double total_fare;
	private String status;
	private int no_of_seats_booked;

	private String source;
	private String destination;
	private String order_id;
	private Date travel_date;
	private Time departure;
	private int rating;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TicketPassenger> passengerList;

	public Ticket() {
		super();
	}

	public Ticket(String booking_id, String payment_id, int user_id, Date booking_date, Time booking_time, int trip_id,
			int service_id, String payment_mode, double total_fare, String status, int no_of_seats_booked,
			String source, String destination, String order_id, Date travel_date, Time departure,
			List<TicketPassenger> passengerList) {
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
		this.source = source;
		this.destination = destination;
		this.order_id = order_id;
		this.travel_date = travel_date;
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

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
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

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Date getTravel_date() {
		return travel_date;
	}

	public void setTravel_date(Date travel_date) {
		this.travel_date = travel_date;
	}

	public Time getDeparture() {
		return departure;
	}

	public void setDeparture(Time departure) {
		this.departure = departure;
	}

	public List<TicketPassenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<TicketPassenger> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "Ticket [booking_id=" + booking_id + ", payment_id=" + payment_id + ", refund_id=" + refund_id
				+ ", user_id=" + user_id + ", booking_date=" + booking_date + ", booking_time=" + booking_time
				+ ", trip_id=" + trip_id + ", service_id=" + service_id + ", payment_mode=" + payment_mode
				+ ", total_fare=" + total_fare + ", status=" + status + ", no_of_seats_booked=" + no_of_seats_booked
				+ ", source=" + source + ", destination=" + destination + ", order_id=" + order_id + ", travel_date="
				+ travel_date + ", departure=" + departure + ", rating=" + rating + ", passengerList=" + passengerList
				+ "]";
	}

}
