package com.cherry.patterns.structural;

import java.util.ArrayList;
import java.util.List;

interface Component {
	void showPrice();
}

class Leaf implements Component {
	String name;
	int price;

	public Leaf(String name, int price) {
		this.name = name;
		this.price = price;
	}

	int returnPrice() {
		return price;
	}

	@Override
	public void showPrice() {
		System.out.println("Name: " + name + ", Price: " + price);
	}

}

class Group implements Component {
	String name;
	List<Component> group = new ArrayList<Component>();

	void addComponent(Component component) {
		group.add(component);
	}

	public Group(String name) {
		this.name = name;
	}

	@Override
	public void showPrice() {

		for (Component component : group) {
			component.showPrice();
		}

	}

}

public class Composite {
	public static void main(String[] args) {
		Component mouse = new Leaf("Mouse", 399);
		Component keyboard = new Leaf("Keyboard", 699);
		Component monitor = new Leaf("Monitor", 7999);
		Component ram = new Leaf("Ram", 3989);
		Component hdd = new Leaf("HDD", 4129);
		Component cpu = new Leaf("CPU", 15999);

		Group pp = new Group("peripheral");
		pp.addComponent(mouse);
		pp.addComponent(keyboard);
		pp.addComponent(monitor);

		Group motherBoard = new Group("Mother Board");
		motherBoard.addComponent(ram);
		motherBoard.addComponent(cpu);

		Group cb = new Group("Cabinet");
		cb.addComponent(hdd);
		cb.addComponent(motherBoard);

		Group pc = new Group("Computer");
		pc.addComponent(pp);
		pc.addComponent(cb);

		motherBoard.showPrice();

	}
}
