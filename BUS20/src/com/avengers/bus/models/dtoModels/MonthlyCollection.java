package com.avengers.bus.models.dtoModels;

public class MonthlyCollection {
	private String month;
	private double collection;

	public MonthlyCollection(String month, double collection) {
		super();
		this.month = month;
		this.collection = collection;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getCollection() {
		return collection;
	}

	public void setCollection(double collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "MonthlyCollection [month=" + month + ", collection=" + collection + "]";
	}

}
