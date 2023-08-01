package com.avengers.bus.services.contracts;

import com.avengers.bus.models.inputModels.ActivateData;

public interface RouteModifier {
	public boolean generateRoute(int routeId, String source, String destination);

	public boolean deactivateRoute(int routeNumber, String routeSource, String routeDestination);

	public boolean activateRoute(int routeNumber, String routeSource, String routeDestination);

	public boolean activateNewRoute(ActivateData data);
}
