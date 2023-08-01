package com.avengers.bus.dao.contracts;

import java.util.List;

import com.avengers.bus.models.dtoModels.ServiceDetails;
import com.avengers.bus.models.entityModels.Stop;

public interface DetailsDAO {
	// lists all the details of one particular service based on service_id
	ServiceDetails serviceDetails(int service_id);

	// lists all the stops in one particular route
	List<Stop> routeDetails(int route);

}
