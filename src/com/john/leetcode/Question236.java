package com.john.leetcode;

public class Question236 {

	public static void main(String[] args) {

	}

	public OldTreeNode lowestCommonAncestor(OldTreeNode root, OldTreeNode p, OldTreeNode q) {
		if (root == p || root == q) {
			return root;
		}

		boolean pLeft = containsNode(root.left, p);
		boolean qLeft = containsNode(root.left, q);

		if (pLeft ^ qLeft) {
			return root;
		} else if (pLeft && qLeft) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}
	}

	private boolean containsNode(OldTreeNode root, OldTreeNode node) {
		if (root == null) {
			return false;
		}
		if (root == node) {
			return true;
		}

		return containsNode(root.left, node) || containsNode(root.right, node);
	}

}
