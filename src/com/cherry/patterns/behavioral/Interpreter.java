package com.cherry.patterns.behavioral;

interface Expression {
	String interpret(InterpreterContext ic);
}

class InterpreterContext {
	public String getBinaryFormat(int i) {
		return Integer.toBinaryString(i);
	}

	public String getHexadecimalFormat(int i) {
		return Integer.toHexString(i);
	}

	public String getOctalFormat(int i) {
		return Integer.toOctalString(i);
	}
}

class IntToBinaryExpression implements Expression {
	private int i;

	public IntToBinaryExpression(int c) {
		this.i = c;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getBinaryFormat(this.i);
	}

}

class IntToHexExpression implements Expression {
	private int i;

	public IntToHexExpression(int c) {
		this.i = c;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getHexadecimalFormat(i);
	}

}

class IntToOctExpression implements Expression {
	private int i;

	public IntToOctExpression(int c) {
		this.i = c;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getOctalFormat(i);
	}
}

public class Interpreter {
	public InterpreterContext ic;

	public Interpreter(InterpreterContext i) {
		this.ic = i;
	}

	public String interpret(String str) {
		Expression exp = null;
		if (str.contains("Hexadecimal")) {
			exp = new IntToHexExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		} else if (str.contains("Binary")) {
			exp = new IntToBinaryExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		} else if (str.contains("Octal")) {
			exp = new IntToOctExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		} else
			return null;
		return exp.interpret(ic);
	}

	public static void main(String args[]) {
		String str1 = "15 in Binary";
		String str2 = "15 in Hexadecimal";
		String str3 = "15 in Octal";
		Interpreter ec = new Interpreter(new InterpreterContext());
		System.out.println(str1 + ": " + ec.interpret(str1).toUpperCase());
		System.out.println(str2 + ": " + ec.interpret(str2).toUpperCase());
		System.out.println(str3 + ": " + ec.interpret(str3).toUpperCase());

	}
}
