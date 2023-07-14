package com.avengers.bus.models.dtoModels;

public class ServiceDetails {
	private int serviceId;
	private String source;
	private String destination;
	private String departure;
	private String arrival;
	private String tripDate;
	private String busType;
	private int routeId;
	private String collection;
	private int seatsAvailable;
	private int seatsBooked;
	private String busTypeTitle;
	private String busTypeDescription;

	// Default constructor
	public ServiceDetails() {
	}

	// Getters and Setters

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
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

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public String getBusTypeTitle() {
		return busTypeTitle;
	}

	public void setBusTypeTitle(String busTypeTitle) {
		this.busTypeTitle = busTypeTitle;
	}

	public String getBusTypeDescription() {
		return busTypeDescription;
	}

	public void setBusTypeDescription(String busTypeDescription) {
		this.busTypeDescription = busTypeDescription;
	}
}
