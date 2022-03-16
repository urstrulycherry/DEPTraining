package com.cherry.patterns.structural;

class _Triangle {
	double base;
	double height;

	_Triangle(int base, int height) {
		// TODO Auto-generated constructor stub
		this.base = base;
		this.height = height;
	}
}

class _Rectangle {
	double length;
	double width;
}

class Calculator {

	double getArea(_Rectangle r) {
		// TODO Auto-generated method stub
		return r.length * r.width;

	}
}

class CalculatorAdapter {

	double getArea(_Triangle t) {
		Calculator c = new Calculator();
		_Rectangle r = new _Rectangle();
		r.length = 0.5 * t.base;
		r.width = t.height;
		return c.getArea(r);
	}
}

public class AdapterPatternExample {
	public static void main(String[] args) {
		System.out.println("*** Adapter Pattern Demo ***");
		CalculatorAdapter calculatorAdapter = new CalculatorAdapter();
		_Triangle t = new _Triangle(50, 4);
		System.out.print("Area of Triangle is " + calculatorAdapter.getArea(t) + " Square units");

	}
}
