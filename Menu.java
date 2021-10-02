package com.restaurant.my;

public class Menu {
	private Meal[] meals;

	private int mealIndex;
	private int tax;

	public Menu(int tax) {
		this.tax = tax;
		meals = new Meal[10];
		mealIndex = 0;
	}

	public int getTax() {
		return tax;
	}

	public void add(Meal meal) {
		meals[mealIndex] = meal;
		mealIndex++;
	}

	public Meal[] getMeals() {
		return meals;
	}

}
