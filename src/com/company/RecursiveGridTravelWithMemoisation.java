package com.company;

public class RecursiveGridTravelWithMemoisation {
	public static void main(String args[]) {
		System.out.println(gridTravel(1,1));
		System.out.println(gridTravel(2,2));
		System.out.println(gridTravel(2,3));
		System.out.println(gridTravel(3,3));
		System.out.println(gridTravel(18,18));
	}

	public static int gridTravel(int m,int n) {
		if(m==1&&n==1)return 1;
		if(m==0||n==0) return 0;
		return gridTravel(m-1,n)+gridTravel(m,n-1);
	}
}
