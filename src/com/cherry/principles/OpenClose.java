package com.cherry.principles;

import java.security.InvalidParameterException;

interface IOperation {
	double performOperation();
}

interface ICalculator {
	double calculate(IOperation operation);
}

class Addition implements IOperation {
	private double firstOperand;
	private double secondOperand;
	private double result = 0.0;

	public Addition(double firstOperand, double secondOperand) {
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}

	@Override
	public double performOperation() {
		result = firstOperand + secondOperand;
		return result;
	}
}

class SimpleCalculator implements ICalculator {
	@Override
	public double calculate(IOperation operation) {
		if (operation == null) {
			throw new InvalidParameterException("Invalid args");
		}

		return operation.performOperation();
	}
}

public class OpenClose {
	public static void main(String[] args) {
		SimpleCalculator calculator = new SimpleCalculator();
		System.out.println(calculator.calculate(new Addition(10, 20)));

	}
}
