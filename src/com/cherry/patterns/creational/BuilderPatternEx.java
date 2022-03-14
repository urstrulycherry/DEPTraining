package com.cherry.patterns.creational;

import java.util.LinkedList;

interface Builder {
	void buildBody();

	void insertWheels();

	void addHeadlights();

	Product getVehicle();
}

class Director {
	Builder builder;

	public Director() {
//		System.out.println("Director");
	}

	public void Construct(Builder builder) {
		this.builder = builder;
		builder.buildBody();
		builder.insertWheels();
		builder.addHeadlights();
	}
}

class Car implements Builder {
	private Product product;

	Car() {
		product = new Product();
	}

	@Override
	public void buildBody() {
		product.Add("This is a body of a car.");
	}

	@Override
	public void insertWheels() {
		product.Add("4 wheels are added.");
	}

	@Override
	public void addHeadlights() {
		product.Add("2 headlights are added.");
	}

	@Override
	public Product getVehicle() {
		return product;
	}
}

class MotorCycle implements Builder {
	private Product product;

	public MotorCycle() {
		product = new Product();
	}

	@Override
	public void buildBody() {
		product.Add("This is a body of a motorcycle.");
	}

	@Override
	public void insertWheels() {
		product.Add("2 wheels are added.");
	}

	@Override
	public void addHeadlights() {
		product.Add("1 headlights are added.");
	}

	@Override
	public Product getVehicle() {
		return product;
	}
}

class Product {
	private LinkedList<String> parts;

	public Product() {
		parts = new LinkedList<String>();
	}

	public void Add(String part) {
		parts.addLast(part);
	}

	public void Show() {
		System.out.println("Product completed as below:");
		for (int i = 0; i < parts.size(); i++) {
			System.out.println(parts.get(i));
		}
	}
}

class BuilderPatternEx {
	public static void main(String[] args) {
		System.out.println("** Builder Pattern Demo **");
		System.out.println("\n");

		Director director = new Director();

		Builder carBuilder = new Car();
		director.Construct(carBuilder);
		Product car = carBuilder.getVehicle();
		car.Show();

		System.out.println();

		Builder motorBuilder = new MotorCycle();
		director.Construct(motorBuilder);
		Product motor = motorBuilder.getVehicle();
		motor.Show();
	}
}