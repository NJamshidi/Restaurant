package com.restaurant.my;

public class Manager {
	private Restaurant restaurant;

	public Manager(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void addToMenu(Meal meal) {
		if (meal.getMenuType() == MenuType.DINNER)
			restaurant.addToDinnerMenu(meal);
		else
			restaurant.addToLaunchMenu(meal);
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void showCustomersInfo() {
		if (restaurant.getNumberOfCustomers() == 0) {
			System.out.println("No customer exists");
			return;
		}
		for (Customer customer : restaurant.getCustomers())
			if (customer != null)
				System.out.println(customer);
	}

	public void addCustomer(Customer customer) {
		restaurant.addCustomer(customer);
	}

	public void showMenu(MenuType menuType) {
		if (menuType == MenuType.LUNCH)
			restaurant.showLunchMenu();
		else
			restaurant.showDinnerMenu();
	}

	public void addCustomerOrders(Customer customer, String[] orderIds) {
		for (String id : orderIds) {
			Meal meal = restaurant.getMealById(Integer.parseInt(id));
			if (meal == null) {
				System.out.println("Meal with id: " + id + " is not exist");
				continue;
			}

			if (restaurant.prepareOrder(meal) == false) {
				System.out.println("Meal with id: " + id + " is finished!");
				continue;
			}
			Order order = new Order(meal.getId());
			customer.addOrder(order);
			System.out.println(meal.getName() + " has successfully added to your order.");
		}
	}

	public void showOrderDetails(Customer customer) {
		if (customer.getNumberOfOrders() == 0) {
			System.out.println("Orders is empty");
			return;
		}

		int sumOfprices = 0;
		double totalTax = 0;
		for (Order order : customer.getOrders())
			if (order != null) {
				Meal meal = restaurant.getMealById(order.getMealId());
				System.out.println(meal.getName() + " status: " + order.getStatus());
				if (order.getStatus() == OrderStatus.RESERVED) {
					sumOfprices += meal.getPrice();
					totalTax += restaurant.getMealTax(meal);
				}
			}

		double totalPrice = sumOfprices + totalTax;
		System.out.println("Total Price: " + totalPrice);
		System.out.println("Total Tax: " + totalTax);

	}

	public void cancelOrder(Customer customer, int orderId) {
		for (Order order : customer.getOrders())
			if (order != null && order.getMealId() == orderId) {
				order.cancelOrder();
				System.out.println("Order canceled!");
				return;
			}
		System.out.println("Order not exist");
	}
}
