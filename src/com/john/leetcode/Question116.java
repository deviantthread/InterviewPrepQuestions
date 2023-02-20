package com.john.leetcode;

public class Question116 {

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode left = new TreeLinkNode(2);
		TreeLinkNode right = new TreeLinkNode(3);
		root.left = left;
		root.right = right;
		left.left = new TreeLinkNode(4);
		left.right = new TreeLinkNode(5);
		right.left = new TreeLinkNode(6);
		right.right = new TreeLinkNode(7);
		OldTreeNode.printNodes(root);
		new Question116().connect(root);
	}

	public void connect(TreeLinkNode root) {
		if (root == null || root.left == null) {
			return;
		}

		root.left.next = root.right;

		if (root.next != null) {
			root.right.next = root.next.left;
		}

		connect(root.left);
		connect(root.right);
	}

	private static class TreeLinkNode extends OldTreeNode {
		TreeLinkNode next;
		TreeLinkNode left;
		TreeLinkNode right;

		public TreeLinkNode(int x) {
			super(x);
		}

	}
}
