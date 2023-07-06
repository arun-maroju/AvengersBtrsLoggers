package com.avengers.bus.models.inputModels;

import org.springframework.stereotype.Component;

@Component
public class Passengers {
	private String passenger_id;
	private String passenger_name;
	private String passenger_gender;
	private int passenger_age;
	private int seat_id;
	private double seat_fare;

	public double getSeat_fare() {
		return seat_fare;
	}

	public void setSeat_fare(double seat_fare) {
		this.seat_fare = seat_fare;
	}

	public String getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(String passenger_id) {
		this.passenger_id = passenger_id;
	}

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public String getPassenger_gender() {
		return passenger_gender;
	}

	public void setPassenger_gender(String passenger_gender) {
		this.passenger_gender = passenger_gender;
	}

	public int getPassenger_age() {
		return passenger_age;
	}

	public void setPassenger_age(int passenger_age) {
		this.passenger_age = passenger_age;
	}

	public int getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	@Override
	public String toString() {
		return "Passengers [passenger_id=" + passenger_id + ", passenger_name=" + passenger_name + ", passenger_gender="
				+ passenger_gender + ", passenger_age=" + passenger_age + ", seat_id=" + seat_id +"seat_fare"+seat_fare+ "]";
	}

}