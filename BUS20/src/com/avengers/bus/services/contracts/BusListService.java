package com.avengers.bus.services.contracts;

import java.util.List;

import com.avengers.bus.models.dtoModels.BusSearchListDto;
import com.avengers.bus.models.inputModels.SearchBusInput;

public interface BusListService {
	public List<BusSearchListDto> getBusList(SearchBusInput sbi);
}
