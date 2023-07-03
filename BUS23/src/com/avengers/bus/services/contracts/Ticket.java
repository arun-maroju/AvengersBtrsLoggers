package com.avengers.bus.services.contracts;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_tickets")
public class Ticket {

	@Id
	String booking_id;
	String payment_id;
	int user_id;
	String booking_date;
	String booking_time;
	int trip_id;
	int service_id;
	String payment_mode;
	int total_fare;
	String status;
	int no_of_seats_booked;

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
		Date bd = Date.valueOf(booking_date);
		return bd;
	}

	public void setBooking_date(Date booking_date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String bd = dateFormat.format(booking_date);
		this.booking_date = bd;
	}

	public String getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(String booking_time) {
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

	public int getTotal_fare() {
		return total_fare;
	}

	public void setTotal_fare(int total_fare) {
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

	@Override
	public String toString() {
		return "Ticket [booking_id=" + booking_id + ", payment_id=" + payment_id + ", user_id=" + user_id
				+ ", booking_date=" + booking_date + ", booking_time=" + booking_time + ", trip_id=" + trip_id
				+ ", service_id=" + service_id + ", payment_mode=" + payment_mode + ", total_fare=" + total_fare
				+ ", status=" + status + ", no_of_seats_booked=" + no_of_seats_booked + "]";
	}

}
