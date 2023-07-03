package com.avengers.bus.services.contracts;

public interface FetchDetails {
	// This will get all the service details based on service id
	public String getServiceDetails(String service);

	// This will return all the details of a route based on its id
	public String getRouteDetails(String route);

}
