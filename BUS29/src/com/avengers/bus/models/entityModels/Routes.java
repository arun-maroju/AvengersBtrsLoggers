package com.avengers.bus.models.entityModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_routes")
public class Routes {

	@Id
	private int route_id;
	private String source;
	private String destination;

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

	@Override
	public String toString() {
		return "Routes [route_id=" + route_id + ", source=" + source + ", destination=" + destination + "]";
	}

}
