package com.cherry.patterns.behavioral;

interface IStrategy {
	float calculation(float a, float b);
}

class Addition implements IStrategy {
	@Override
	public float calculation(float a, float b) {
		return a + b;
	}
}

class Subtraction implements IStrategy {
	@Override
	public float calculation(float a, float b) {
		return a - b;
	}
}

class Context {

	private IStrategy strategy;

	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}

	public float executeStrategy(float num1, float num2) {
		return strategy.calculation(num1, num2);
	}
}

public class Strategy {
	public static void main(String[] args) {
		float f1 = 5.5f;
		float f2 = 2.3f;
		Context c = new Context(new Addition());
		System.out.println(c.executeStrategy(f1, f2));

		c = new Context(new Subtraction());
		System.out.println(c.executeStrategy(f1, f2));
	}
}
