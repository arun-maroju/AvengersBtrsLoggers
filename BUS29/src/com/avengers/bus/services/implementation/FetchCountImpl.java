package com.avengers.bus.services.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avengers.bus.dao.contracts.CountsDAO;
import com.avengers.bus.services.contracts.FetchCount;

@Service
@Transactional
@Component
public class FetchCountImpl implements FetchCount {
	private static final Logger logger = LoggerFactory.getLogger(FetchCountImpl.class);

	private CountsDAO cdao;

	public FetchCountImpl(CountsDAO cdao) {
		super();
		this.cdao = cdao;
	}

	public int getBusCount() {
		logger.info("Fetching Bus Count from Admin DashBoard:{}", cdao.busCount());
		return cdao.busCount();
	}

	public int getServiceCount() {
		logger.info("Fetching Service Count from Admin DashBoard:{}", cdao.serviceCount());
		return cdao.serviceCount();
	}

	public int getCollection() {
		logger.info("Fetching Total Collection from Admin DashBoard:{}", cdao.totalPayments());
		return cdao.totalPayments();
	}

	public int getUserCount() {
		logger.info("Fetching User Count from Admin DashBoard:{}", cdao.userCount());
		return cdao.userCount();
	}

	public int getRouteCount() {
		// TODO Auto-generated method stub
		logger.info("Fetching Route Count from Admin DashBoard:{}", cdao.routeCount());
		return cdao.routeCount();
	}

	public int getTripCount() {
		// TODO Auto-generated method stub
		logger.info("Fetching Trip Count from Admin DashBoard:{}", cdao.tripCount());
		return cdao.tripCount();
	}

	public int getPastTicketCollection() {
		logger.info("Fetching pastTicket Collection from Admin DashBoard:{}", cdao.pastTicketCollection());
		return cdao.pastTicketCollection();
	}

	public int getFutureTicketCollection() {
		logger.info("Fetching Future Ticket Collection from Admin DashBoard:{}", cdao.futureTicketCollection());
		return cdao.futureTicketCollection();
	}

}
