package com.avengers.bus.dao.contracts;

import java.util.List;

import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.inputModels.SearchBusInput;

public interface BusListDAO {
	// this will list any one kind of the buses list based on user specifications
	public List<BusSearchListDto> getBusList(SearchBusInput sbi);

	// this will list all the buses
	public List<BusSearchListDto> getBusListAll(SearchBusInput sbi);
}
