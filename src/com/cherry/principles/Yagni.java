package com.cherry.principles;

/*
public class Calc{
   int sum(int a, int b){
	return a + b;
   }

   int sum(int a, int b, int c){
	return a + b;
   }
}

 */
public class Yagni {
	static int sum(int... values) {
		int res = 0;
		for (int value : values) {
			res += value;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(sum(1, 2, 3, 4));
		System.out.println(sum(12, 678, 45, 25, 25, 7));
	}
}
