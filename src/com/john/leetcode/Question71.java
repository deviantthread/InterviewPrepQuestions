package com.john.leetcode;

public class Question71 {

	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		System.out.println(new Question71().simplifyPath(path));
	}

	public String simplifyPath(String path) {
		Node head = createList(path);

		head = removeDotDot(head);

		return combineList(head);
	}

	private Node removeDotDot(Node head) {
		Node curr = head;
		while (curr != null) {
			if (curr.val.equals("..")) {
				Node prev = curr.prev.prev;
				if (prev != null) {
					prev.next = curr.next;
					curr = prev;
				} else {
					head = curr.next;
				}
			}

			curr = curr.next;
		}
		return head;
	}

	private String combineList(Node head) {
		String ret = "";
		while (head != null) {
			ret += head.val + "/";

			head = head.next;
		}

		return ret;
	}

	private Node createList(String path) {
		Node head = new Node();
		Node curr = head;

		String val = "";
		for (char c : path.toCharArray()) {
			if (c == '/') {
				if (!(val.equals(".") || val.equals(""))) {
					Node node = new Node();
					node.val = val;
					node.prev = curr;
					curr.next = node;
					curr = curr.next;
					val = "";
				}
			} else {
				val += c;
			}
		}

		return head.next;
	}

	private static class Node {
		Node next;
		Node prev;
		String val;
	}
}
