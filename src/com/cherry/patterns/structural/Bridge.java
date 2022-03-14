package com.cherry.patterns.structural;

interface Shape {
	void shape();
}

class Triangle implements Shape {
	Color c;

	Triangle(Color c) {
		this.c = c;
	}

	@Override
	public void shape() {
		System.out.print("Triangle");
		c.getColor();
	}
}

class Rectangle implements Shape {
	Color c;

	Rectangle(Color c) {
		this.c = c;
	}

	@Override
	public void shape() {
		System.out.print("Rectangle");
		c.getColor();

	}
}

class Circle implements Shape {
	Color c;

	Circle(Color c) {
		this.c = c;
	}

	@Override
	public void shape() {
		System.out.print("Circle");
		c.getColor();
	}

}

interface Color {
	public void getColor();
}

class Blue implements Color {
	@Override
	public void getColor() {
		System.out.println(" in blue color");
	}
}

class Red implements Color {
	@Override
	public void getColor() {
		System.out.println(" in red color");
	}
}

public class Bridge {
	public static void main(String[] args) {
		Color red = new Red();
		Color blue = new Blue();
		Shape s1 = new Triangle(red);
		s1.shape();
		Shape s2 = new Rectangle(red);
		s2.shape();
		Shape s3 = new Circle(blue);
		s3.shape();

	}
}
