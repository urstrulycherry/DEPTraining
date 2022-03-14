package com.cherry.patterns.behavioral;

interface Chain {
	public void setNextChain(Chain nextChain);

	public void calculate(int a, int b, String calc);
}

class AddNumbers implements Chain {

	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	@Override
	public void calculate(int a, int b, String calc) {

		if (calc == "add") {

			System.out.print(a + " + " + b + " = " + (a + b));

		} else {

			nextInChain.calculate(a, b, calc);

		}

	}
}

class SubtractNumbers implements Chain {

	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	@Override
	public void calculate(int a, int b, String calc) {

		if (calc == "sub") {

			System.out.print(a + " - " + b + " = " + (a - b));

		} else {

			nextInChain.calculate(a, b, calc);

		}

	}

}

public class ChainOfResponsibility {
	public static void main(String[] args) {

		Chain add = new AddNumbers();
		Chain sub = new SubtractNumbers();

		add.setNextChain(sub);

		add.calculate(4, 2, "sub");

	}

}
