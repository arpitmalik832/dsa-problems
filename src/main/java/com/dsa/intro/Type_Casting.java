package com.dsa.intro;

public class Type_Casting {
	public static void main(String[] args) {
		// Implicit typecasting
		int a = 10000;
		long y = a; // int tp long -> small to big -> no data loss
		System.out.println(y);

		// Explicit typecasting
		long h = 9000;
		int d = (int) h; // long -> int
		System.out.println(d);

		long v = 1000000000000l; // long to long
		int p = (int) v;
		System.out.println(p);
	}
}
