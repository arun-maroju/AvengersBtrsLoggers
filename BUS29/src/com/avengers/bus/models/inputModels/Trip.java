package com.avengers.bus.models.inputModels;

public class Trip {
	private int tripNo;
    private String source;
    private String destination;
    private String departure;
    private String arrival;
    private int busType;
    private int interStopsCount;
    private int routeId;
	public int getTripNo() {
		return tripNo;
	}
	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
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
	public int getBusType() {
		return busType;
	}
	public void setBusType(int busType) {
		this.busType = busType;
	}
	public int getInterStopsCount() {
		return interStopsCount;
	}
	public void setInterStopsCount(int interStopsCount) {
		this.interStopsCount = interStopsCount;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	@Override
	public String toString() {
		return "Trip [tripNo=" + tripNo + ", source=" + source + ", destination=" + destination + ", departure="
				+ departure + ", arrival=" + arrival + ", busType=" + busType + ", interStopsCount=" + interStopsCount
				+ ", routeId=" + routeId + "]";
	}
    
    
}
