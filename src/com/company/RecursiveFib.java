package com.company;

public class RecursiveFib {
	public static void main(String args[]) {
		System.out.println(fib(5));
		System.out.println(fib(6));
		System.out.println(fib(40));
		System.out.println(fib(100));
	}

	public static int fib(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
