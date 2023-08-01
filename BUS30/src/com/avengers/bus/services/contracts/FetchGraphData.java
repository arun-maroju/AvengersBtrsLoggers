package com.avengers.bus.services.contracts;

public interface FetchGraphData {
	// This will return the routeWise collection
	public String getRouteCollection();

	// This will return the tirp wise collection
	public String getTripCollection();

	// This will return the monthly collection
	public String getMonthlyCollection();

}
