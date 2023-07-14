package com.avengers.bus.services.contracts;

import java.util.List;

import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.inputModels.SearchBusInput;

public interface BusListService {
	// This will return all the buses based on user specifications
	public List<BusSearchListDto> getBusList(SearchBusInput sbi);
}
