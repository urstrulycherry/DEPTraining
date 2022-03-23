package com.cherry.patterns.behavioral;

interface Shape {
	void print();

	boolean isNull();
}

class Triangle implements Shape {

	@Override
	public void print() {
		System.out.println("I am Triangle");
	}

	@Override
	public boolean isNull() {
		return false;
	}

}

class Rectangle implements Shape {

	@Override
	public void print() {
		System.out.println("I am Rectangle");
	}

	@Override
	public boolean isNull() {
		return false;
	}

}

class NullShape implements Shape {

	@Override
	public void print() {
		System.out.println("-_-");
	}

	@Override
	public boolean isNull() {
		return true;
	}

}

class ShapeFactory {
	static Shape getShape(String s) {
		if (s.equals("rect"))
			return new Rectangle();
		else if (s.equals("tri"))
			return new Triangle();
		else
			return new NullShape();
	}
}

public class Null {
	public static void main(String[] args) {
		ShapeFactory.getShape("tri").print();
		ShapeFactory.getShape("rect").print();
		ShapeFactory.getShape("circle").print();
	}
}
