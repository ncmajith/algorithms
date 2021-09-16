package dev.leetcode.workouts;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class AdditonOfLikedList {
	public static void main(String args[]) {
		var li = new ListNode(9);
		AddNode(li, 9);
		AddNode(li, 9);
		AddNode(li, 9);
		AddNode(li, 9);
		AddNode(li, 9);
		AddNode(li, 9);

		var l2 = new ListNode(9);
		AddNode(l2, 9);
		AddNode(l2, 9);
		AddNode(l2, 9);

		var result = addTwoNumbers(li, l2);
		System.out.println(result);
	}

	public static void AddNode(ListNode list, int value) {
		var listNode = list;
		while (listNode.next != null) {
			listNode = listNode.next;
		}
		listNode.next = new ListNode(value);
	}

	static int sum = 0;
	static int carry = 0;

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode one = l1.next;
		ListNode two = l2.next;
		sumAndCarry(l1, l2);
		ListNode returnNode, tempNode;
		returnNode = tempNode = new ListNode(sum % 10);
		while (one != null || two != null) {
			sumAndCarry(one, two);
			if (returnNode == null)
				returnNode = new ListNode(sum % 10);
			returnNode.next = new ListNode(sum % 10);
			returnNode = returnNode.next;
			one = (one!=null)? one.next:null;
			two = (two!=null)? two.next:null;
		}
		if(carry>0) returnNode.next = new ListNode(carry);
		return tempNode;
	}

	public static void sumAndCarry(ListNode one, ListNode two) {
		int oneOp = (one != null) ? one.val : 0;
		int twoOp = (two != null) ? two.val : 0;
		sum = oneOp + twoOp + carry;
		carry = sum / 10;
	}
}
