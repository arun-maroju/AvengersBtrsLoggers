package com.avengers.bus.services.contracts;

import java.util.List;

import com.avengers.bus.models.entityModels.BusTypes;

public interface BusTypeService {
	// This will return all the bus Types available
	public List<BusTypes> listAll();
}
