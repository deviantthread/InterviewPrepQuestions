package com.john.leetcode;

public class Question147 {

	public static void main(String[] args) {
		ListNode head = ListNode.generateNodes("271493");
		head.print("org");
		ListNode sortList = new Question147().insertionSortList(head);
		sortList.print("sorted");
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		ListNode currHead = head;

		while (head != null) {
			ListNode next = head.next;
			if (head.val < currHead.val) {
				addNode(preHead, head);
			} else {
				currHead.next = head;
				currHead = head;
			}
			head = next;
		}
		currHead.next = null;
		return preHead.next;
	}

	private void addNode(ListNode preHead, ListNode node) {
		while (preHead != null) {
			if (preHead.next.val > node.val) {
				ListNode next = preHead.next;
				preHead.next = node;
				node.next = next;
				break;
			}

			preHead = preHead.next;
		}
	}
}
