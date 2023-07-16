package com.avengers.bus.models.entityModels;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_routes")
public class Route {
	@Id
	private int route_id;
	private String source;
	private String destination;
	private int active;
	private String status;

	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Trip> trips;

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int route_id) {
		this.route_id = route_id;
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
	
	

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Route [route_id=" + route_id + ", source=" + source + ", destination=" + destination + ", active="
				+ active + ", status=" + status + ", trips=" + trips + "]";
	}

}
