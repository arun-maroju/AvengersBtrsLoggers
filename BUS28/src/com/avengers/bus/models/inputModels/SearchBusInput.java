package com.avengers.bus.models.inputModels;

public class SearchBusInput {
	private String fssId;
	private String tssId;
	private int travelClass;
	private String date;

	@Override
	public String toString() {
		return "SearchBusInput [fssId=" + fssId + ", tssId=" + tssId + ", travelClass=" + travelClass + ", date=" + date
				+ "]";
	}

	public String getFssId() {
		return fssId;
	}

	public void setFssId(String fssId) {
		this.fssId = fssId;
	}

	public String getTssId() {
		return tssId;
	}

	public void setTssId(String tssId) {
		this.tssId = tssId;
	}

	public int getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(int travelClass) {
		this.travelClass = travelClass;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
