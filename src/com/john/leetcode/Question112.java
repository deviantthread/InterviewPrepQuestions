package com.john.leetcode;

public class Question112 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		System.out.println(new Question112().hasPathSum(root, 1));

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return hasPathSum(root, sum, 0);
	}

	private boolean hasPathSum(TreeNode root, int sum, int i) {
		if (root.left == null && root.right == null) {
			return sum == (root.val + i);
		}

		boolean left = false;
		if (root.left != null) {
			left = hasPathSum(root.left, sum, i + root.val);
		}
		boolean right = false;
		if (root.right != null && !left) {
			right = hasPathSum(root.right, sum, i + root.val);
		}
		return left || right;
	}
}
