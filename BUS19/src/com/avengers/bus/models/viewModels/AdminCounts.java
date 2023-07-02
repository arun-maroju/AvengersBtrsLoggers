package com.avengers.bus.models.viewModels;

public class AdminCounts {
	private int userCount;
	private int busCount;
	private int collection;
	private int serviceCount;
	private int routeCount;
	private int tripCount;
	private int pastTicketCollection;
	private int futureTicketCollection;

	public AdminCounts(int userCount, int busCount, int collection, int serviceCount, int routeCount, int tripCount,
			int pastTicketCollection, int futureTicketCollection) {
		super();
		this.userCount = userCount;
		this.busCount = busCount;
		this.collection = collection;
		this.serviceCount = serviceCount;
		this.routeCount = routeCount;
		this.tripCount = tripCount;
		this.pastTicketCollection = pastTicketCollection;
		this.futureTicketCollection = futureTicketCollection;
	}

	@Override
	public String toString() {
		return "AdminCounts [userCount=" + userCount + ", busCount=" + busCount + ", collection=" + collection
				+ ", serviceCount=" + serviceCount + ", routeCount=" + routeCount + ", tripCount=" + tripCount
				+ ", pastTicketCollection=" + pastTicketCollection + ", futureTicketCollection="
				+ futureTicketCollection + "]";
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public int getBusCount() {
		return busCount;
	}

	public void setBusCount(int busCount) {
		this.busCount = busCount;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	public int getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(int serviceCount) {
		this.serviceCount = serviceCount;
	}

	public int getRouteCount() {
		return routeCount;
	}

	public void setRouteCount(int routeCount) {
		this.routeCount = routeCount;
	}

	public int getTripCount() {
		return tripCount;
	}

	public void setTripCount(int tripCount) {
		this.tripCount = tripCount;
	}

	public int getPastTicketCollection() {
		return pastTicketCollection;
	}

	public void setPastTicketCollection(int pastTicketCollection) {
		this.pastTicketCollection = pastTicketCollection;
	}

	public int getFutureTicketCollection() {
		return futureTicketCollection;
	}

	public void setFutureTicketCollection(int futureTicketCollection) {
		this.futureTicketCollection = futureTicketCollection;
	}

}
