package com.avengers.bus.dao.contracts;

import com.avengers.bus.models.entityModels.Route;
import com.avengers.bus.models.entityModels.TripStops;
import com.avengers.bus.models.entityModels.Trips;

public interface MasterDAO {
	public boolean persistRoute(Route route, Route route2);

	public boolean mergeRoute(Route route);

	public int getLastTripId();

	public boolean persistTrip(Trips tripEntity);

	public boolean persistTripStop(TripStops ts);
}
