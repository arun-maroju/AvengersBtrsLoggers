package com.avengers.bus.dao.contracts;

import java.util.List;

import com.avengers.bus.models.entityModels.BusTypes;
import com.avengers.bus.models.entityModels.SeatsBookedForOneService;
import com.avengers.bus.models.entityModels.Stations;

public interface BusSearchDAO {

	// getting already booked seats for one particular service
	public List<SeatsBookedForOneService> getBookedSeats(int service_id);

	// getting all the bus types
	public List<BusTypes> getAllBusTypes();

	// getting all the bus stops available
	public List<Stations> getAllStations();

	Stations getStation(String stationCode);

}
