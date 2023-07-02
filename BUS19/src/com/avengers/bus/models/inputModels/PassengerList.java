package com.avengers.bus.models.inputModels;

import java.util.Arrays;

public class PassengerList {

	private String[] passenger_id;
	private int[] seat_number;
	private String[] passenger_name;
	private int[] passenger_age;
	private String[] passenger_gender;

	public String[] getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(String[] passenger_id) {
		this.passenger_id = passenger_id;
	}

	public int[] getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int[] seat_number) {
		this.seat_number = seat_number;
	}

	public String[] getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String[] passenger_name) {
		this.passenger_name = passenger_name;
	}

	public int[] getPassenger_age() {
		return passenger_age;
	}

	public void setPassenger_age(int[] passenger_age) {
		this.passenger_age = passenger_age;
	}

	public String[] getPassenger_gender() {
		return passenger_gender;
	}

	public void setPassenger_gender(String[] passenger_gender) {
		this.passenger_gender = passenger_gender;
	}

	@Override
	public String toString() {
		return "PassengerList [passenger_id=" + Arrays.toString(passenger_id) + ", seat_number="
				+ Arrays.toString(seat_number) + ", passenger_name=" + Arrays.toString(passenger_name)
				+ ", passenger_age=" + Arrays.toString(passenger_age) + ", passenger_gender="
				+ Arrays.toString(passenger_gender) + "]";
	}

}
