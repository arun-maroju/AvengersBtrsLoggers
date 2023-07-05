package com.avengers.bus.utilities.exceptions;

public class SeatsAlreadyFilled extends Exception {

	String message;

	public SeatsAlreadyFilled(String message) {
		this.message = message;
		System.out.println(message);
	}

	public String getExceptionMessage() {
		return message;
	}
}
