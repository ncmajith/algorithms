package com.company;

public class RecursiveExample {
	
	public static void main(String args[]) {
		System.out.println(factorial(5));
	}
	
	public static long factorial(int n) {
		System.out.println(n);
		  if (n == 0) {
		    return 1;
		  } else {
		    return n * factorial(n-1);
		  }
		}
}
