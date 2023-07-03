package com.avengers.bus.services.contracts;

import java.util.List;

import com.avengers.bus.models.entityModels.Stations;

public interface StationService {
	// This will return all the stations available

	public List<Stations> listAll();
}
