package com.avengers.bus.models.viewModels;

public class UserCounts {

	private int bookedCount;

	private int travelCount;

	private double wallet;

	private String name;
	
	private int futureTravelCount;

	public UserCounts(int bookedCount, int travelCount, double wallet, String name,int futureTravelCount) {
		super();
		this.bookedCount = bookedCount;
		this.travelCount = travelCount;
		this.wallet = wallet;
		this.name = name;
		this.futureTravelCount=futureTravelCount;
	}

	public int getFutureTravelCount() {
		return futureTravelCount;
	}

	public void setFutureTravelCount(int futureTravelCount) {
		this.futureTravelCount = futureTravelCount;
	}

	public int getBookedCount() {
		return bookedCount;
	}

	public void setBookedCount(int bookedCount) {
		this.bookedCount = bookedCount;
	}

	public int getTravelCount() {
		return travelCount;
	}

	public void setTravelCount(int travelCount) {
		this.travelCount = travelCount;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
