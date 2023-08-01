package com.avengers.bus.models.inputModels;

public class Route {
	int routeId;
	String source;
	String Destination;
	
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", Destination=" + Destination + "]";
	}
	
	

}
