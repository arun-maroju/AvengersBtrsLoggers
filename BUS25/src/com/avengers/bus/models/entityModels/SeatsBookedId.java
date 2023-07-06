package com.avengers.bus.models.entityModels;

import java.io.Serializable;

public class SeatsBookedId implements Serializable {

	private int service_id;

	private int seat_id;

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public int getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	@Override
	public String toString() {
		return "SeatsBookedId [service_id=" + service_id + ", seat_id=" + seat_id + "]";
	}

}