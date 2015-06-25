package com.john.leetcode;

public class Question143 {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode curr = head;
		for (int i = 2; i < 4; i++) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		ListNode n = head;
		System.out.println("original");
		while (n != null) {
			System.out.print(n.val + "->");
			n = n.next;
		}

		new Question143().reorderList(head);
		System.out.println("\nfinished");
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public void reorderList(ListNode head) {
		int len = getLength(head);
		if (len < 2) {
			return;
		}

		int count = 0;
		ListNode secondHalf = head;
		ListNode endOfFirstHalf = null;
		while (count < (len / 2)) {
			endOfFirstHalf = secondHalf;
			secondHalf = secondHalf.next;
			count++;
		}
		endOfFirstHalf.next = null;

		secondHalf = reverse(secondHalf);
		ListNode firstHalf = head.next;
		ListNode ret = head;

		while (firstHalf != null && secondHalf != null) {
			ret.next = secondHalf;
			ret = ret.next;
			secondHalf = secondHalf.next;

			ret.next = firstHalf;
			ret = ret.next;
			firstHalf = firstHalf.next;
		}

		ret.next = secondHalf;
	}

	private int getLength(ListNode head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = curr.next;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
