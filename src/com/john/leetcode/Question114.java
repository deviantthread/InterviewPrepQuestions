package com.john.leetcode;

public class Question114 {

	public static void main(String[] args) {
		TreeNode root = TreeNode.generateTree("1|2,5|3,4,,6");
		root.print("org");
		new Question114().flatten(root);
		root.print("flattened");
	}

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flattenRecurse(root);
	}

	private TreeNode flattenRecurse(TreeNode node) {
		if (node.left == null && node.right == null) {
			return node;
		}

		if (node.left != null) {
			TreeNode leftTail = flattenRecurse(node.left);

			if (node.right == null) {
				node.right = node.left;
				node.left = null;
				return leftTail;
			} else {
				TreeNode rightTail = flattenRecurse(node.right);

				leftTail.right = node.right;
				node.right = node.left;
				node.left = null;
				return rightTail;
			}
		} else {
			TreeNode rightTail = flattenRecurse(node.right);
			return rightTail;
		}
	}
}
