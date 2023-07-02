package com.avengers.bus.dao.contracts;

import java.util.List;

import com.avengers.bus.models.dtoModels.MonthlyCollection;
import com.avengers.bus.models.dtoModels.RouteCollection;
import com.avengers.bus.models.dtoModels.TripCollection;

public interface GraphDAO {
	// retruns route wise collection
	public List<RouteCollection> routeCollection();

	// returns trip wise collections
	public List<TripCollection> tripCollection();

	// returns monthly collections
	public List<MonthlyCollection> monthlyCollection();

}
