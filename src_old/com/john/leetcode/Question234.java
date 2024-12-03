package com.john.leetcode;

public class Question234 {

	public static void main(String[] args) {
		ListNode head = ListNode.generateNodes("1221");
		ListNode.printNodes(head);
		System.out.println(new Question234().isPalindrome(head));
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}

		int len = findLen(head);
		ListNode middle = getNode(head, len / 2);
		ListNode secondHalf = reverse(middle);

		return compareHalves(head, secondHalf);
	}

	private boolean compareHalves(ListNode head, ListNode secondHalf) {
		while (secondHalf != null) {
			if (head.val != secondHalf.val) {
				return false;
			}
			head = head.next;
			secondHalf = secondHalf.next;
		}
		return true;
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

	private ListNode getNode(ListNode head, int len) {
		while (len > 0) {
			head = head.next;
			len--;
		}
		return head;
	}

	private int findLen(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}

}
