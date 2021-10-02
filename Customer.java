package com.restaurant.my;

public class Customer {
	private String name;
	private String family;
	private String phoneNumber;
	private Gender gender;
	private Order[] orders;
	private int orderIndex;

	public Customer(String name, String family, String phoneNumber, Gender gender) {
		this.name = name;
		this.family = family;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		orders = new Order[100];
		orderIndex = 0;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", name, family, phoneNumber, gender);
	}

	public void addOrder(Order order) {
		orders[orderIndex] = order;
		orderIndex++;
	}

	public Order[] getOrders() {
		return orders;
	}

	public int getNumberOfOrders() {
		return orderIndex;
	}

}
