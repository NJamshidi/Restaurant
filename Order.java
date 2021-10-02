package com.restaurant.my;

public class Order {
	private int mealId;
	private OrderStatus status;

	public Order(int mealId) {
		this.mealId = mealId;
		status = OrderStatus.RESERVED;
	}

	public int getMealId() {
		return mealId;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void cancelOrder() {
		this.status = OrderStatus.CANCELED;
	}

}
