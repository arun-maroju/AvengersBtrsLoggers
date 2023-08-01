package com.avengers.bus.models.inputModels;

public class InterStop {
	private int tripNo;
    private String stop;
    private int stopIndex;
    private String stopTime;
	public int getTripNo() {
		return tripNo;
	}
	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}
	public String getStop() {
		return stop;
	}
	public void setStop(String stop) {
		this.stop = stop;
	}
	public int getStopIndex() {
		return stopIndex;
	}
	public void setStopIndex(int stopIndex) {
		this.stopIndex = stopIndex;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	@Override
	public String toString() {
		return "InterStop [tripNo=" + tripNo + ", stop=" + stop + ", stopIndex=" + stopIndex + ", stopTime=" + stopTime
				+ "]";
	}
    
    
}
