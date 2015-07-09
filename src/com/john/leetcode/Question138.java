package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question138 {

	public static void main(String[] args) {
		RandomListNode head = null;
		RandomListNode copy = new Question138().copyRandomList(head);
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode curr = head;
		RandomListNode copy = new RandomListNode(-1);
		RandomListNode copyCurr = copy;
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		// create copy of the linked list w/o random pointers yet
		while (curr != null) {
			copyCurr.next = new RandomListNode(curr.label);
			copyCurr = copyCurr.next;

			map.put(curr, copyCurr);
			curr = curr.next;
		}
		copy = copy.next;

		copyCurr = copy;
		curr = head;
		while (curr != null) {
			if (curr.random != null) {
				copyCurr.random = map.get(curr.random);
			}
			copyCurr = copyCurr.next;
			curr = curr.next;
		}

		return copy;
	}

	private static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

}
