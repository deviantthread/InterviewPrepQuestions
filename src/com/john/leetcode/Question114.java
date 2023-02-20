package com.john.leetcode;

public class Question114 {

	public static void main(String[] args) {
		OldTreeNode root = OldTreeNode.generateTree("1|2,5|3,4,,6");
		root.print("org");
		new Question114().flatten(root);
		root.print("flattened");
	}

	public void flatten(OldTreeNode root) {
		if (root == null) {
			return;
		}
		flattenRecurse(root);
	}

	private OldTreeNode flattenRecurse(OldTreeNode node) {
		if (node.left == null && node.right == null) {
			return node;
		}

		if (node.left != null) {
			OldTreeNode leftTail = flattenRecurse(node.left);

			if (node.right == null) {
				node.right = node.left;
				node.left = null;
				return leftTail;
			} else {
				OldTreeNode rightTail = flattenRecurse(node.right);

				leftTail.right = node.right;
				node.right = node.left;
				node.left = null;
				return rightTail;
			}
		} else {
			OldTreeNode rightTail = flattenRecurse(node.right);
			return rightTail;
		}
	}
}
