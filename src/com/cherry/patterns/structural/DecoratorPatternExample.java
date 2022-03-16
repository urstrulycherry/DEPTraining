package com.cherry.patterns.structural;

abstract class _Component {
	abstract void makeHouse();
}

abstract class AbstractDecorator extends _Component {
	_Component component;

	void setTheComponent(_Component c) {
		component = c;
	}

	@Override
	void makeHouse() {
		component.makeHouse();
	}
}

class ConcreteComponent extends _Component {

	@Override
	void makeHouse() {
		// TODO Auto-generated method stub
		System.out.println("Original House is complete. It is closed for modification.");

	}

}

class FloorDecorator extends AbstractDecorator {
	public FloorDecorator() {
		// TODO Auto-generated constructor stub
		System.out.println("____________________");
		System.out.println("Using a Floor decorator now");
	}

	@Override
	void makeHouse() {
		super.makeHouse();
		System.out.println("*** Floor decorator is in action ***");
		addFloor();
	}

	void addFloor() {
		System.out.println(" I am making an additional floor on top of it. ");
	}
}

class PaintDecorator extends AbstractDecorator {
	public PaintDecorator() {
		// TODO Auto-generated constructor stub
		System.out.println("____________________");
		System.out.println("Using a Paint decorator now");
	}

	@Override
	void makeHouse() {
		super.makeHouse();
		System.out.println("*** Paint decorator is in action now ***");
		paintTheHouse();
	}

	void paintTheHouse() {
		System.out.println("Painting is started.");
	}
}

public class DecoratorPatternExample {
	public static void main(String[] args) {
		System.out.println("*** Decorator Pattern Demo ***\n");

		ConcreteComponent concreteComponent = new ConcreteComponent();
		concreteComponent.makeHouse();

		FloorDecorator floorDecorator = new FloorDecorator();
		floorDecorator.setTheComponent(concreteComponent);
		floorDecorator.makeHouse();

		PaintDecorator paintDecorator = new PaintDecorator();
		paintDecorator.setTheComponent(floorDecorator);
		paintDecorator.makeHouse();

	}
}
