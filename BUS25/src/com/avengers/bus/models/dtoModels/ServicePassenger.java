package com.avengers.bus.models.dtoModels;

public class ServicePassenger {
	private int service_id;
	private String booking_id;
	private int seat_no;
	private String passenger_name;
	private int age;
	private String gender;
	
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
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
	@Override
	public String toString() {
		return "ServicePassenger [service_id=" + service_id + ", booking_id=" + booking_id + ", seat_no=" + seat_no
				+ ", passenger_name=" + passenger_name + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
