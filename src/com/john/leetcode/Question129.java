package com.john.leetcode;

public class Question129 {

	public static void main(String[] args) {

		// TreeNode root = TreeNode.generateTree(10);
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(0);
		TreeNode.printNodes(root);
		System.out.println(new Question129().sumNumbers(root));
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		String curr = "";
		return sumNumbers(root, curr);
	}

	private int sumNumbers(TreeNode node, String curr) {
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
