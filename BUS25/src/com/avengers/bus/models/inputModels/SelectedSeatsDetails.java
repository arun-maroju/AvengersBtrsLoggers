package com.avengers.bus.models.inputModels;

public class SelectedSeatsDetails {

	private String seatsData;
	private int seatsCount;

	public String getSeatsData() {
		return seatsData;
	}

	public void setSeatsData(String seatsData) {
		this.seatsData = seatsData;
	}

	public int getSeatsCount() {
		return seatsCount;
	}

	public void setSeatsCount(int seatsCount) {
		this.seatsCount = seatsCount;
	}

	@Override
	public String toString() {
		return "SelectedSeatsDetails [seatsData=" + seatsData + ", seatsCount=" + seatsCount + "]";
	}

}
