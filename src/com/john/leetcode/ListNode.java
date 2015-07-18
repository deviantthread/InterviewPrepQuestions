package com.john.leetcode;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "ListNode [" + val + "]";
	}

	public void print() {
		printNodes(this);
	}

	public void print(String msg) {
		printNodes(this, msg);
	}

	public static ListNode generateNodes(int nodes) {
		ListNode head = new ListNode(0);
		generateNodes(head, nodes);
		return head;
	}

	public static void generateNodes(ListNode head, int nodes) {
		ListNode curr = head;
		for (int i = head.val + 1; i < head.val + nodes; i++) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}
	}

	public static ListNode generateNodes(int[] values) {
		ListNode head = new ListNode(-1);
		ListNode curr = head;

		for (int value : values) {
			curr.next = new ListNode(value);
			curr = curr.next;
		}

		return head.next;
	}

	// 1->4->3->2->5->2
	public static ListNode generateNodes(String list) {
		ListNode head = new ListNode(-1);
		ListNode curr = head;
		for (char c : list.toCharArray()) {
			if (Character.isDigit(c)) {
				curr.next = new ListNode(Integer.parseInt(String.valueOf(c)));
				curr = curr.next;
			}
		}

		return head.next;
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("\n");
	}

	public static void printNodes(ListNode head, String msg) {
		System.out.println(msg);
		printNodes(head);
	}
}
