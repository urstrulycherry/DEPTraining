package com.cherry.patterns.creational;

abstract class BasicCar implements Cloneable {
	String modelname;
	int price;

	String getModelname() {
		return modelname;
	}

	void setModelname(String modelname) {
		this.modelname = modelname;
	}

	static int setPrice() {
		return 100000;
	}

	@Override
	public BasicCar clone() throws CloneNotSupportedException {
		return (BasicCar) super.clone();
	}
}

class Ford extends BasicCar {
	Ford(String m) {
		modelname = m;
		setPrice();
		if (m.equals("Ford Yellow")) {
			price = 561925;
		}
	}

	@Override
	public BasicCar clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Nano extends BasicCar {
	Nano(String m) {
		modelname = m;
		setPrice();
		if (m.equals("Green Nano")) {
			price = 189818;
		}
	}

	@Override
	public BasicCar clone() throws CloneNotSupportedException {
		return super.clone();

	}
}

public class PrototypePattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("*** Prototype Pattern Demo ***");
		BasicCar nano_base = new Nano("Green Nano");
		BasicCar ford_basic = new Ford("Ford Yellow");
		System.out.println();
		BasicCar bc1 = nano_base.clone();
		BasicCar bc2 = ford_basic.clone();

		System.out.println("Car is: " + bc1.modelname + " and it's price is Rs." + bc1.price);

		System.out.println("Car is: " + bc2.modelname + " and it's price is Rs." + bc2.price);
	}
}
