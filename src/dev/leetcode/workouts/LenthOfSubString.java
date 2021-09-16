package dev.leetcode.workouts;

public class LenthOfSubString {
	public static void main(String args[]) {
		System.out.println(lengthOfLongestSubstring("au"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty() || s.length() == 0)
			return 0;
		else if (s.length() == 1)
			return 1;
		StringBuilder stringResponse = new StringBuilder();
		int lenght = s.length(), count = 0, two = 1;
//		for (char letter : arr) {
//			if (stringResponse.toString().contains(letter + "")) {
//				if (lenght < count)
//					lenght = count;
//				stringResponse = new StringBuilder();
//				count = 0;
//			}
//			stringResponse.append(letter);
//			count++;
//		}
		int newCout = 0;
		int lenghtOfItem = 0;
		int returnValue = 0;
		while (count < lenght) {
			String subString = s.substring(count, two);
			if (subString.contains(s.charAt(count) + ""))
				newCout++;
			if (newCout > 1) {
				returnValue = subString.length() - 1;
				newCout = 0;
				lenghtOfItem = 0;
			}
			if (two == lenght) {
				count++;
				two = count + 1;
			} else {
				two++;
			}
			lenghtOfItem++;
		}
		return returnValue;
	}
	
	public static int countChars(String input) {
		
		char[] arr=input.toCharArray();
		char temp=arr[0];
		int cout=0;
		for(char ar:arr) {
			if(ar==temp) {
				cout++;
			}else {
				cout=0;
			}
		}
		return 0;
	}

}
