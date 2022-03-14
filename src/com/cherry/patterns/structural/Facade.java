package com.cherry.patterns.structural;

interface Menu {
	public void displayMenu();
}

class VegMenu implements Menu {
	@Override
	public void displayMenu() {
		System.out.println("Idly");
		System.out.println("Dosa");
		System.out.println("Vada");
	}

}

class NonVegMenu implements Menu {

	@Override
	public void displayMenu() {
		System.out.println("Chicken Biriyani");
		System.out.println("Tandoori");
	}

}

class HotleServiceStaff {
	private VegMenu vegMenu;
	private NonVegMenu nonVegMenu;

	public HotleServiceStaff() {
		vegMenu = new VegMenu();
		nonVegMenu = new NonVegMenu();
	}

	public void showVegMenu() {
		vegMenu.displayMenu();
	}

	public void showNonVegMenu() {
		nonVegMenu.displayMenu();
	}

	public void showVegNonVegMenu() {
		vegMenu.displayMenu();
		nonVegMenu.displayMenu();
	}

}

public class Facade {
	public static void main(String[] args) {
		HotleServiceStaff hotleServiceStaff = new HotleServiceStaff();
		System.out.println("--------------Veg Menu--------------");
		hotleServiceStaff.showVegMenu();
		System.out.println();
		System.out.println("------------Non Veg Menu------------");
		hotleServiceStaff.showNonVegMenu();
		System.out.println();
		System.out.println("---------Veg & Non Veg Menu---------");
		hotleServiceStaff.showVegNonVegMenu();
	}
}
