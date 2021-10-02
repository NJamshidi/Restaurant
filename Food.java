package com.restaurant.my;

public class Food extends Meal {

	public Food(int id, String name, int number, int price, MenuType menuType) {
		super(id, name, price, number, menuType, MealType.FOOD);
	}

}
