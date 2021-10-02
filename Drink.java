package com.restaurant.my;

public class Drink extends Meal {

	public Drink(int id, String name, int price, int number, MenuType menuType) {
		super(id, name, price, number, menuType, MealType.DRINK);
	}

}
