package com.john.leetcode;

public class Question148 {

	public static void main(String[] args) {
		ListNode shuffled = ListNode.generateNodes("2177777734");
		shuffled.print("shuffled");
		ListNode sorted = new Question148().sortList(shuffled);
		sorted.print("sorted");
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		int len = getLen(head);
		ListNode newHead = sort(head, len);

		return newHead;
	}

	private ListNode sort(ListNode head, int len) {
		if (len == 1) {
			return head;
		} else if (len == 2) {
			ListNode next = head.next;
			head.next = null;
			ListNode afterEnd = next.next;
			next.next = null;

			ListNode newHead = merge(head, next);
			newHead.next.next = afterEnd;
			return newHead;
		}

		int halfLen = (len / 2);
		ListNode preSecondHalf = findNode(head, halfLen - 1);
		ListNode secondHalf = preSecondHalf.next;
		preSecondHalf.next = null;
		ListNode sortedFirstHalf = sort(head, halfLen);
		ListNode sortedSecondHalf = sort(secondHalf, len - halfLen);

		return merge(sortedFirstHalf, sortedSecondHalf);
	}

	private ListNode merge(ListNode sortedFirstHalf, ListNode sortedSecondHalf) {
		ListNode preHead = new ListNode(-1);
		ListNode curr = preHead;

		while (sortedFirstHalf != null && sortedSecondHalf != null) {
			if (sortedFirstHalf.val < sortedSecondHalf.val) {
				curr.next = sortedFirstHalf;
				sortedFirstHalf = sortedFirstHalf.next;
			} else {
				curr.next = sortedSecondHalf;
				sortedSecondHalf = sortedSecondHalf.next;
			}
			curr = curr.next;
		}
		if (sortedFirstHalf != null) {
			curr.next = sortedFirstHalf;
		} else if (sortedSecondHalf != null) {
			curr.next = sortedSecondHalf;
		}

		return preHead.next;
	}

	private ListNode findNode(ListNode head, int n) {
		for (int i = 0; i < n; i++) {
			head = head.next;
		}
		return head;
	}

	private int getLen(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
}
