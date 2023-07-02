package com.avengers.bus.models.dtoModels;

import java.sql.Time;

public class TripCollection {
	private String route;
	private String time;
	private double collection;

	public TripCollection(String route, Time time, double collection) {
		super();
		this.route = route;
		this.time = time.toString();
		this.collection = collection;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {

		this.time = time;
	}

	public double getCollection() {
		return collection;
	}

	public void setCollection(double collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "TripCollection [route=" + route + ", time=" + time + ", collection=" + collection + "\n";
	}

}
