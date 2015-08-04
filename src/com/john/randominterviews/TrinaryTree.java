package com.john.randominterviews;

public class TrinaryTree<T extends Comparable<T>> {

	private TreeNode<T> head;

	public void insert(T val) {
		if (head == null) {
			head = new TreeNode<T>(val);
		} else {
			insertRecurse(head, val);
		}
	}

	// this isn't balanced
	private void insertRecurse(TreeNode<T> node, T val) {
		if (node.val.compareTo(val) < 0) {
			if (node.right != null) {
				insertRecurse(node.right, val);
			} else {
				node.right = new TreeNode<T>(val);
			}
		} else if (node.val.compareTo(val) > 0) {
			if (node.left != null) {
				insertRecurse(node.left, val);
			} else {
				node.left = new TreeNode<T>(val);
			}
		} else {
			node.middleCount++;
		}
	}

	private static class TreeNode<T> {
		public TreeNode(T val) {
			this.val = val;
		}

		private TreeNode<T> left;
		private TreeNode<T> right;
		private T val;
		// middle count is a bad idea, T could be actual objects that we need to
		// keep
		private int middleCount = 0;
	}
}
