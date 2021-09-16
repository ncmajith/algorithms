package com.company;

public class FindPeakUsingDevideAndConquer {

	public static void main(String args[]) {
		int arr[] = new int[] { 1, 2, 1, 3, 5, 6, 4 };
		System.out.println(findPeak(arr));
//		System.out.println(findPeekByRecurssion(arr, 0, arr.length-1));
	}

	public static int findPeak(int arr[]) {
		int index = 0;
		int right = arr.length - 1;
		while (index < right) {
			int mid = (index + right) / 2;
			if (arr[mid + 1] > arr[mid]) {
				index = mid + 1;
			} else {
				right = mid;
			}
		}
		return index;
	}

//	public static int findPeekByRecurssion(int arr[], int left, int right) {
//		int mid = (left + right) / 2;
//		if (arr[mid + 1] > arr[mid]) {
//			return findPeekByRecurssion(arr, mid + 1, right);
//		} else if (arr[mid - 1] > arr[mid]) {
//			return findPeekByRecurssion(arr, left, mid);
//		}
//		return mid;
//	}
}
