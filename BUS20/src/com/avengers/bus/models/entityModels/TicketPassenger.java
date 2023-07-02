package com.avengers.bus.models.entityModels;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_ticket_passengers")
// @IdClass(TicketPassengerId.class)
public class TicketPassenger implements Serializable {

	@Id
	private String booking_id;
	@Id
	private int passenger_index;
	private String passenger_name;
	private int age;
	private String gender;
	private int seat_no;
	private double p_fare;

	@ManyToOne
	@JoinColumn(name = "booking_id", referencedColumnName = "booking_id", insertable = false, updatable = false)
	private Ticket ticket;

	public TicketPassenger() {
		super();
	}

	public TicketPassenger(String booking_id, int passenger_index, String passenger_name, int age, String gender,
			int seat_no, double p_fare) {
		super();
		this.booking_id = booking_id;
		this.passenger_index = passenger_index;
		this.passenger_name = passenger_name;
		this.age = age;
		this.gender = gender;
		this.seat_no = seat_no;
		this.p_fare = p_fare;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public int getPassenger_index() {
		return passenger_index;
	}

	public void setPassenger_index(int passenger_index) {
		this.passenger_index = passenger_index;
	}

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}

	public double getP_fare() {
		return p_fare;
	}

	public void setP_fare(double p_fare) {
		this.p_fare = p_fare;
	}

	@Override
	public String toString() {
		return "TicketPassenger [booking_id=" + booking_id + ", passenger_index=" + passenger_index
				+ ", passenger_name=" + passenger_name + ", age=" + age + ", gender=" + gender + ", seat_no=" + seat_no
				+ ", p_fare=" + p_fare + "]";
	}

}
