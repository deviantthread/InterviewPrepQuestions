package com.john.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeNode [" + val + "]";
	}

	// public static void generateNodes(TreeNode head, int nodes) {
	// TreeNode curr = head;
	// for (int i = head.val + 1; i < head.val + nodes + 1; i++) {
	// curr.next = new TreeNode(i);
	// curr = curr.next;
	// }
	// }

	public static void printNodes(TreeNode head, String msg) {
		System.out.println(msg);
		printNodes(head);
	}

	public static void printNodes(TreeNode head) {
		if (head == null) {
			return;
		}

		Queue<TreeNode> curr = new LinkedList<TreeNode>();
		Queue<TreeNode> children = new LinkedList<TreeNode>();
		String nextLine = "\n";
		curr.add(head);

		while (!curr.isEmpty()) {
			TreeNode n = curr.remove();
			System.out.print(n.val + "   ");

			if (n.left != null) {
				children.add(n.left);
				nextLine += "/   ";
			} else {
				nextLine += " ";
			}

			if (n.right != null) {
				children.add(n.right);
				nextLine += "\\\t";
			} else {
				nextLine += " ";
			}

			if (curr.isEmpty()) {
				System.out.println(nextLine);
				nextLine = "\n";
				Queue<TreeNode> tmp = curr;
				curr = children;
				children = tmp;
			}
		}

		System.out.println();
	}

	public static void printNodes2(TreeNode head) {
		if (head == null) {
			return;
		}

		Queue<TreeNode> curr = new LinkedList<TreeNode>();
		Queue<TreeNode> children = new LinkedList<TreeNode>();
		curr.add(head);

		while (!curr.isEmpty()) {
			TreeNode n = curr.remove();
			System.out.print(n.val + "  ");

			if (n.left != null) {
				children.add(n.left);
			}
			if (n.right != null) {
				children.add(n.right);
			}

			if (curr.isEmpty()) {
				System.out.println();
				Queue<TreeNode> tmp = curr;
				curr = children;
				children = tmp;
			}
		}

		System.out.println();
	}

	public static TreeNode generateTree(int i) {
		// TODO: implement for real
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);

		return root;
	}
}
