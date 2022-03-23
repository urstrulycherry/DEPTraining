package com.cherry.patterns.behavioral;

interface ShoppingCart {
	int visit(Computer computer);

	int visit(Printer printer);
}

interface Item {
	int accept(ShoppingCart visitor);
}

class ShoppingCartVisitor implements ShoppingCart {
	@Override
	public int visit(Computer computer) {
		int cost = 0;
		if (computer.getCost() > 200000) {
			cost = computer.getCost() - 1000;
		} else {
			cost = computer.getCost();
		}
		System.out.println("Computer Serial Number: " + computer.getSerialNo() + ",cost :" + cost);
		return cost;
	}

	@Override
	public int visit(Printer printer) {
		int cost = 0;
		if (printer.getCost() > 10000) {
			cost = printer.getCost() - 1500;
		} else {
			cost = printer.getCost();
		}
		System.out.println("Printer: " + printer.getSerialNo() + ",cost :" + cost);
		return cost;
	}
}

class Computer implements Item {
	private int cost;
	private String SerialNo;

	Computer(int cost, String SerialNo) {
		this.cost = cost;
		this.SerialNo = SerialNo;
	}

	@Override
	public int accept(ShoppingCart visitor) {
		return visitor.visit(this);
	}

	public int getCost() {
		return cost;
	}

	public String getSerialNo() {
		return SerialNo;
	}
}

class Printer implements Item {
	private int cost;
	private String SerialNo;

	Printer(int cost, String SerialNo) {
		this.cost = cost;
		this.SerialNo = SerialNo;
	}

	@Override
	public int accept(ShoppingCart visitor) {
		return visitor.visit(this);
	}

	public int getCost() {
		return cost;
	}

	public String getSerialNo() {
		return SerialNo;
	}
}

public class Visitor {
	public static void main(String[] args) {
		Item[] items = new Item[] { new Computer(200000, "basic101"), new Computer(300000, "advanced23"),
				new Printer(20000, "basic-p") };

		int totalCost = calculatePrice(items);
		System.out.println("Total Cost: " + totalCost);
	}

	static int calculatePrice(Item[] items) {
		ShoppingCart cart = new ShoppingCartVisitor();
		int sum = 0;
		for (Item item : items) {
			sum += item.accept(cart);
		}
		return sum;
	}
}
