package com.avengers.bus.services.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.models.viewModels.AdminCounts;
import com.avengers.bus.services.contracts.AdminCountsService;
import com.avengers.bus.services.contracts.FetchCount;

@Component
public class AdminCountsServiceImpl implements AdminCountsService {
	private static final Logger logger = LoggerFactory.getLogger(AdminCountsServiceImpl.class);

	@Autowired
	FetchCount fc;

	@Override
	public AdminCounts getCounts() {
		logger.info(
				"Fetching UserCount,BusCount,Collection,ServiceCount,RouteCount,TripCount,PastTicketCollection and FutureTicketCollection in AdminDashBoard");
		AdminCounts ac = new AdminCounts(fc.getUserCount(), fc.getBusCount(), fc.getCollection(), fc.getServiceCount(),
				fc.getRouteCount(), fc.getTripCount(), fc.getPastTicketCollection(), fc.getFutureTicketCollection());

		return ac;
	}

}
