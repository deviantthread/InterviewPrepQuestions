package com.john.leetcode;

public class Question129 {

	public static void main(String[] args) {

		// TreeNode root = TreeNode.generateTree(10);
		OldTreeNode root = new OldTreeNode(1);
		root.left = new OldTreeNode(2);
		root.right = new OldTreeNode(3);
		root.right.right = new OldTreeNode(0);
		OldTreeNode.printNodes(root);
		System.out.println(new Question129().sumNumbers(root));
	}

	public int sumNumbers(OldTreeNode root) {
		if (root == null) {
			return 0;
		}
		String curr = "";
		return sumNumbers(root, curr);
	}

	private int sumNumbers(OldTreeNode node, String curr) {
		String currVal = curr + String.valueOf(node.val);
		if (node.left == null && node.right == null) {
			return Integer.parseInt(currVal);
		}

		int left = 0;
		int right = 0;
		if (node.left != null) {
			left = sumNumbers(node.left, currVal);
		}
		if (node.right != null) {
			right = sumNumbers(node.right, currVal);
		}
		return left + right;
	}

}
