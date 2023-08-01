package com.avengers.bus.models.inputModels;

import java.util.List;

public class ActivateData {
	private List<Trip> trips;
    private List<InterStop> interStops;
	public List<Trip> getTrips() {
		return trips;
	}
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	public List<InterStop> getInterStops() {
		return interStops;
	}
	public void setInterStops(List<InterStop> interStops) {
		this.interStops = interStops;
	}
	@Override
	public String toString() {
		return "ActivateData [trips=" + trips + ", interStops=" + interStops + "]";
	}

}
