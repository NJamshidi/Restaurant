package com.restaurant.my;

public class Meal {
	private int id;
	private String name;
	private int price;
	private MenuType menuType;
	private MealType mealType;
	private int number;

	public Meal(int id, String name, int price, int number, MenuType menuType, MealType mealType) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.menuType = menuType;
		this.number = number;
		this.mealType = mealType;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public MealType getMealType() {
		return mealType;
	}

	public int getNumber() {
		return number;
	}

	public void decreaseNumber() {
		number--;
	}

	@Override
	public String toString() {
		return String.format("%d %s %d T", id, name, price);
	}

}
