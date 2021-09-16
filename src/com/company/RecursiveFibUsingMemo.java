package com.company;

import java.util.HashMap;
import java.util.Map;

public class RecursiveFibUsingMemo {
	public static void main(String args[]) {
		Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
		System.out.println(fib(5, memo));
		System.out.println(fib(6, memo));
		System.out.println(fib(50, memo));
		System.out.println(fib(100, memo));
	}

	public static int fib(int n, Map<Integer, Integer> memo) {
		if (memo.get(n) != null)
			return memo.get(n);
		if (n <= 2)
			return 1;
		memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
		return memo.get(n);
	}
}
