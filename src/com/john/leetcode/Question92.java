package com.john.leetcode;

public class Question92 {

	public static void main(String[] args) {
		ListNode head = ListNode.generateNodes("123456");
		head.print();
		ListNode reversed = new Question92().reverseBetween(head, 1, 5);
		reversed.print();
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode beforeHead = new ListNode(-1);
		beforeHead.next = head;
		ListNode beforeStart = beforeHead;
		for (int i = 1; i < m; i++) {
			beforeStart = beforeStart.next;
		}

		ListNode end = beforeStart.next;
		for (int i = m + 1; i <= n; i++) {
			end = end.next;
		}

		ListNode secondHalf = end.next;
		end.next = null;
		ListNode start = beforeStart.next;
		reverse(start);
		beforeStart.next = end;
		start.next = secondHalf;
		if (start != head) {
			return head;
		} else {
			return end;
		}
	}

	private void reverse(ListNode start) {
		ListNode prev = null;
		ListNode curr = start;
		ListNode next = curr.next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
	}

}
