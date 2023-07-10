package com.avengers.bus.services.contracts;

import com.avengers.bus.models.viewModels.AdminCounts;

public interface AdminCountsService {
	// This will return all important counts for one user
	public AdminCounts getCounts();

}
