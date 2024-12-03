package com.john.leetcode;

public class Question203 {
	public static void main(String[] args) {
		ListNode head = ListNode.generateNodes("34353637");
		head.print("org");
		ListNode newHead = new Question203().removeElements(head, 3);
		newHead.print("removed");
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode preHead = new ListNode(-1);
		preHead.next = head;

		ListNode node = preHead;
		while (node.next != null) {
			if (node.next.val == val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}

		return preHead.next;
	}
}
