package com.avengers.bus.models.entityModels;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_trips")
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trip_id;

	@Override
	public String toString() {
		return "Trips [trip_id=" + trip_id + ", source=" + source + ", destination=" + destination + ", departure="
				+ departure + ", arrival=" + arrival + ", bus_type=" + bus_type + ", inter_stops=" + inter_stops + "]";
	}

	public int getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
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

	public Time getDeparture() {
		return departure;
	}

	public void setDeparture(Time departure) {
		this.departure = departure;
	}

	public Time getArrival() {
		return arrival;
	}

	public void setArrival(Time arrival) {
		this.arrival = arrival;
	}

	public int getBus_type() {
		return bus_type;
	}

	public void setBus_type(int bus_type) {
		this.bus_type = bus_type;
	}

	public int getInter_stops() {
		return inter_stops;
	}

	public void setInter_stops(int inter_stops) {
		this.inter_stops = inter_stops;
	}

	private String source;
	private String destination;
	private Time departure;
	private Time arrival;
	private int bus_type;
	private int inter_stops;

	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;

	@OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Service> services;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

}
