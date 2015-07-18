package com.john.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question23 {

	public static void main(String[] args) {
		ListNode o1 = ListNode.generateNodes("135");
		ListNode o2 = ListNode.generateNodes("2468");
		new Question23().mergeKLists(new ListNode[] {});
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}

		Comparator<? super ListNode> comparer = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return Integer.valueOf(o1.val).compareTo(o2.val);
			}
		};
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, comparer);
		for (ListNode node : lists) {
			if (node != null) {
				q.add(node);
			}
		}
		ListNode preHead = new ListNode(-1);
		ListNode curr = preHead;
		while (!q.isEmpty()) {
			ListNode node = q.remove();
			curr.next = node;
			curr = curr.next;
			if (node.next != null) {
				q.add(node.next);
			}
		}

		return preHead.next;
	}
}
