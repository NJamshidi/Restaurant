package com.restaurant.my;

public class Restaurant {

	private Customer[] customers;
	private int customerIndex;
	private DinnerMenu dinnerMenu;
	private LunchMenu lunchMenu;

	public Restaurant() {
		customers = new Customer[1000];
		customerIndex = 0;
		dinnerMenu = new DinnerMenu();
		lunchMenu = new LunchMenu();
	}

	public void addToDinnerMenu(Meal meal) {
		dinnerMenu.add(meal);
	}

	public void addToLaunchMenu(Meal meal) {
		lunchMenu.add(meal);
	}

	public void addCustomer(Customer customer) {
		customers[customerIndex] = customer;
		customerIndex++;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public int getNumberOfCustomers() {
		return customerIndex;
	}

	public void showLunchMenu() {
		System.out.println(lunchMenu);
		System.out.println("Foods");
		for (Meal meal : lunchMenu.getMeals())
			if (meal != null && meal.getMealType() == MealType.FOOD)
				System.out.println(meal);

		System.out.println("Drinks");
		for (Meal meal : lunchMenu.getMeals())
			if (meal != null && meal.getMealType() == MealType.DRINK)
				System.out.println(meal);
	}

	public void showDinnerMenu() {
		System.out.println(dinnerMenu);
		System.out.println("Foods");
		for (Meal meal : dinnerMenu.getMeals())
			if (meal != null && meal.getMealType() == MealType.FOOD)
				System.out.println(meal);

		System.out.println("Drinks");
		for (Meal meal : dinnerMenu.getMeals())
			if (meal != null && meal.getMealType() == MealType.DRINK)
				System.out.println(meal);
	}

	public Meal getMealById(int id) {
		for (Meal meal : lunchMenu.getMeals())
			if (meal != null && meal.getId() == id)
				return meal;

		for (Meal meal : dinnerMenu.getMeals())
			if (meal != null && meal.getId() == id)
				return meal;
		return null;
	}

	public boolean prepareOrder(Meal meal) {
		if (meal.getNumber() > 0) {
			meal.decreaseNumber();
			return true;
		}
		return false;
	}

	public double getMealTax(Meal meal) {
		if (meal.getMenuType() == MenuType.LUNCH)
			return meal.getPrice() * lunchMenu.getTax() / 100d;
		return meal.getPrice() * dinnerMenu.getTax() / 100d;
	}

}
