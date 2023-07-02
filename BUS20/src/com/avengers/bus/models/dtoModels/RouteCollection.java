package com.avengers.bus.models.dtoModels;

public class RouteCollection {
	private String route;
	private double collection;

	public RouteCollection(String route, double collection) {
		super();
		this.route = route;
		this.collection = collection;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public double getCollection() {
		return collection;
	}

	public void setCollection(double collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "RouteCollection [route=" + route + ", collection=" + collection + "]";
	}

}
