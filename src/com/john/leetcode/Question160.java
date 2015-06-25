package com.john.leetcode;

public class Question160 {

	public static void main(String[] args) {

		ListNode headA = new ListNode("A0");
		ListNode headB = new ListNode("B0");
		ListNode headC = new ListNode("C0");

		ListNode currA = headA;
		ListNode currB = headB;
		ListNode currC = headC;
		for (int i = 1; i < 5; i++) {
			currB.next = new ListNode("B" + i);
			currB = currB.next;
			currC.next = new ListNode("C" + i);
			currC = currC.next;
		}
		for (int i = 1; i < 50; i++) {
			currA.next = new ListNode("A" + i);
			currA = currA.next;
		}

		currA.next = headC;
		currB.next = headC;
		currA = headA;
		while (currA != null) {
			System.out.print(currA.val + "->");
			currA = currA.next;
		}
		System.out.println();
		currB = headB;
		while (currB != null) {
			System.out.print(currB.val + "->");
			currB = currB.next;
		}
		System.out.println();
		ListNode intersectionNode = new Question160().getIntersectionNode(
				headA, headB);
		System.out.println();
		System.out.println(intersectionNode.val);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		int lenA = getLength(headA);
		int lenB = getLength(headB);

		if (lenA > lenB) {
			while (lenA > lenB) {
				headA = headA.next;
				lenA--;
			}
		} else if (lenB > lenA) {
			while (lenB > lenA) {
				headB = headB.next;
				lenB--;
			}
		}

		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	private int getLength(ListNode headB) {
		int count = 0;
		while (headB != null) {
			count++;
			headB = headB.next;
		}

		return count;
	}

	public static class ListNode {
		String val;
		ListNode next;

		ListNode(String x) {
			val = x;
			next = null;
		}
	}

}
