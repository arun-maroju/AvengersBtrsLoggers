package com.avengers.bus.models.inputModels;

public class PaymentDetails {
	private String payment_id;
	private String order_id;
	private int user_id;

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "PaymentDetails [payment_id=" + payment_id + ", order_id=" + order_id + ", user_id=" + user_id + "]";
	}

}
