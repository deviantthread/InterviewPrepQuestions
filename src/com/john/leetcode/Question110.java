package com.john.leetcode;

public class Question110 {

	public static void main(String[] args) {
		TreeNode root = TreeNode.generateTree("1|2,3|4,,,|4,,,,,,");
		root.print("org");
		System.out.println("isBalanced: " + new Question110().isBalanced(root));
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isBalanced(root, 0) != -1;
	}

	private int isBalanced(TreeNode node, int depth) {
		if (node == null) {
			return depth - 1;
		}

		int leftHeight = isBalanced(node.left, depth + 1);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = isBalanced(node.right, depth + 1);
		if (rightHeight == -1) {
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight);
	}
}
