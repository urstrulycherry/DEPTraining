package com.cherry.oops;

class Animal {
}

class Monkey extends Animal {
}

public class Examples {
	void m1(int i) {
		System.out.println("int-arg");
	}

	void m1(int... i) {
		System.out.println("var-arg");
	}

	void m1(float f) {
		System.out.println("float-arg");
	}

	void m1(String s) {
		System.out.println("String-arg");
	}

	void m1(Object o) {
		System.out.println("Object-arg");
	}

	void m1(StringBuffer sb) {
		System.out.println("SB-arg");
	}

	void m1(int i, float f) {
		System.out.println("int-float arg");
	}

	void m1(float f, int i) {
		System.out.println("float-int arg");
	}

	void m1(Animal a) {
		System.out.println("Animal-arg");
	}

	void m1(Monkey m) {
		System.out.println("Monkey-arg");
	}

	void m1(int i, char c, String... s) {
		System.out.println("int-char-varArg");
	}

	public static void main(String[] args) {
		Examples e = new Examples();
		e.m1(10);
		e.m1(1, 2, 3, 4, 5);
		e.m1(10f);
		e.m1(10, 'c', "hello", "world");

	}
}
