package com.restaurant.my;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Restaurant restaurant = new Restaurant();
		Manager manager = new Manager(restaurant);
		while (true) {
			showFirstPage();
			int selection = input.nextInt();
			switch (selection) {
			case 1: {
				managerPageWhile: while (true) {
					showManagerPage();
					selection = input.nextInt();
					switch (selection) {
					case 1: {
						MenuType menuType = MenuType.DINNER;
						System.out.println("Select: 1- drink   2- food");
						System.out.print("> ");
						selection = input.nextInt();
						System.out.print("Enter id > ");
						int id = input.nextInt();
						System.out.print("Enter name > ");
						String name = input.next();
						System.out.print("Enter price > ");
						int price = input.nextInt();
						System.out.print("Enter number > ");
						int number = input.nextInt();
						Meal meal = null;
						if (selection == 1)
							meal = new Drink(id, name, price, number, menuType);
						else
							meal = new Food(id, name, price, number, menuType);
						manager.addToMenu(meal);
					}
						break;
					case 2: {
						MenuType menuType = MenuType.LUNCH;
						System.out.println("Select: 1- drink   2- food");
						System.out.print("> ");
						selection = input.nextInt();
						System.out.print("Enter id > ");
						int id = input.nextInt();
						System.out.print("Enter name > ");
						String name = input.next();
						System.out.print("Enter price > ");
						int price = input.nextInt();
						System.out.print("Enter number > ");
						int number = input.nextInt();
						Meal meal = null;
						if (selection == 1)
							meal = new Drink(id, name, price, number, menuType);
						else
							meal = new Food(id, name, price, number, menuType);
						manager.addToMenu(meal);
					}
						break;
					case 3: {
						manager.showCustomersInfo();
					}
						break;
					case 4:
						break managerPageWhile;
					default:
						System.out.println("Invalid selection!");
					}// swtich manager
				} // while manager
			} // case 1 main menu
				break;
			case 2: {
				System.out.print("Enter name > ");
				String name = input.next();
				System.out.print("Enter family > ");
				String family = input.next();
				System.out.print("Enter phone number > ");
				String phoneNumber = input.next();
				System.out.print("Enter gender (Male/Female) > ");
				String strGender = input.next(); // m, Male, FEMALE, female, F, f, male
				Gender gender = strGender.toLowerCase().contains("f") ? Gender.FEMALE : Gender.MALE;
				Customer customer = new Customer(name, family, phoneNumber, gender);
				manager.addCustomer(customer);

				customerPageWhile: while (true) {
					showCustomerPage();
					selection = input.nextInt();
					switch (selection) {
					case 1: {
						System.out.println("Select: 1- launch   2- dinner");
						System.out.print("> ");
						selection = input.nextInt();
						MenuType menuType = selection == 1 ? MenuType.LUNCH : MenuType.DINNER;
						manager.showMenu(menuType);
						System.out.println("Which one do you want to order? (Enter ID with spaces)");
						input.nextLine();
						String strOrdersIdsLine = input.nextLine();
						String[] strOrdersIds = strOrdersIdsLine.split(" ");
						manager.addCustomerOrders(customer, strOrdersIds);
					}
						break;
					case 2: {
						manager.showOrderDetails(customer);
					}
						break;
					case 3: {
						if (customer.getNumberOfOrders() == 0)
							System.out.println("Orders is empty");
						else {
							for (Order order : customer.getOrders())
								if (order != null && order.getStatus() == OrderStatus.RESERVED)
									System.out.println(order.getMealId());
							System.err.print("Select an order id to cancel > ");
							int orderId = input.nextInt();
							manager.cancelOrder(customer, orderId);
						}
					}
						break;
					case 4:
						break customerPageWhile;
					default:
						System.out.println("Invalid selection");
					}// switch customer
				} // while customer
			} // case 2 main menu
				break;
			case 3:

				input.close();
				return;
			default:
				System.out.println("Invalid input!");
			}
		}
	}

	public static void showFirstPage() {
		System.out.println("***Welcome to restaurant system***");
		System.out.println(" 1) login as manager");
		System.out.println(" 2) login as customer");
		System.out.println(" 3) Exit");
		System.out.print("> ");
	}

	public static void showManagerPage() {
		System.out.println("***Manager Page***");
		System.out.println(" 1) Add to dinner menu");
		System.out.println(" 2) Add to launch menu");
		System.out.println(" 3) Customer Info");
		System.out.println(" 4) Back to main page");
		System.out.print("> ");
	}

	public static void showCustomerPage() {
		System.out.println("***Customer Page***");
		System.out.println(" 1) Add new order");
		System.out.println(" 2) Show orders detail");
		System.out.println(" 3) Cancel an order");
		System.out.println(" 4) Back to main page");
		System.out.print("> ");
	}
}
