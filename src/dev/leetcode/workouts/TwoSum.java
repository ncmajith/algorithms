package dev.leetcode.workouts;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 3 };
		System.out.println(twoSum(nums, 6));
	}

	public static int[] twoSum(int[] nums, int target) {
		if (nums.length == 0)
			return new int[] { 0 };
		else if (nums.length == 2)
			return new int[] { 0, 1 };
		int returnArr[] = new int[2];
		for (int index = 0; index < nums.length; index++) {
			for (int j = index + 1; j < nums.length; j++) {
				if (nums[index] + nums[j] == target) {
					returnArr[0] = index;
					returnArr[1] = j;
					break;
				}
			}
		}
		return returnArr;
	}
}
