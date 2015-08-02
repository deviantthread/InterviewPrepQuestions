package com.john.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question99 {

	public static void main(String[] args) {
		// TreeNode root = TreeNode.generateTree("10|5,15|3,7,,17");
		// root.print();

		TreeNode root = TreeNode.generateTree("0|1");
		root.print("org");
		new Question99().recoverTree(root);
		root.print("fixed");
	}

	public void recoverTree(TreeNode root) {
		List<TreeNode> badNodes = new ArrayList<TreeNode>();
		boolean isRootGood = isRootGood(root);

		if (isRootGood) {
			findBadNodes(root, badNodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
		} else {
			badNodes.add(root);
			findBadNodes(root.left, badNodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
			findBadNodes(root.right, badNodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		int tmp = badNodes.get(0).val;
		badNodes.get(0).val = badNodes.get(1).val;
		badNodes.get(1).val = tmp;
	}

	private boolean isRootGood(TreeNode root) {
		boolean rootGood = checkNode(root);

		if (rootGood) {
			return true;
		} else {
			boolean right = checkNode(root.right);
			boolean left = checkNode(root.left);
			return !(right || left);
		}

	}

	private boolean checkNode(TreeNode node) {
		if (node == null) {
			return true;
		}
		boolean goodRight = node.right != null && node.val < node.right.val;
		boolean goodLeft = node.left != null && node.val >= node.left.val;
		return goodRight && goodLeft;
	}

	private void findBadNodes(TreeNode node, List<TreeNode> badNodes, int minValue, int maxValue) {
		if (node == null || badNodes.size() == 2) {
			return;
		}
		boolean badNode = node.val > maxValue || node.val < minValue;
		if (badNode) {
			badNodes.add(node);
			findBadNodes(node.left, badNodes, minValue, maxValue);
			findBadNodes(node.right, badNodes, minValue, maxValue);
		} else {
			findBadNodes(node.left, badNodes, minValue, node.val);
			findBadNodes(node.right, badNodes, node.val, maxValue);
		}
	}

}
