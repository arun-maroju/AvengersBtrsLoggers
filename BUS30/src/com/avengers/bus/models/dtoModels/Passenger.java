package com.avengers.bus.models.dtoModels;

public class Passenger {
	private int passengerId;
	private String name;
	private int age;
	private String gender;
	private double fare;
	private int seatId;

	public Passenger(int passengerId, String name, int age, String gender, double fare, int seatId) {
		super();
		this.passengerId = passengerId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.fare = fare;
		this.seatId = seatId;
	}

	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	// Constructor, getters, and setters

	@Override
	public String toString() {
		return "Passenger{" + "passengerId=" + passengerId + ", name='" + name + '\'' + ", age=" + age + ", gender='"
				+ gender + '\'' + ", fare=" + fare + ", seatId=" + seatId + '}';
	}
}
