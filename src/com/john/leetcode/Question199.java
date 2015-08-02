package com.john.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question199 {

	public static void main(String[] args) {
		TreeNode tree = TreeNode.generateTree("1|2,3|,5,,4");
		List<Integer> rightSideView = new Question199().rightSideView(tree);
		CollUtils.print(rightSideView);
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightSide = new ArrayList<Integer>();
		if (root == null) {
			return rightSide;
		}

		Queue<TreeNode> curr = new LinkedList<TreeNode>();
		Queue<TreeNode> children = new LinkedList<TreeNode>();
		curr.add(root);

		while (!curr.isEmpty()) {
			TreeNode node = curr.remove();

			if (node.left != null) {
				children.add(node.left);
			}
			if (node.right != null) {
				children.add(node.right);
			}

			if (curr.isEmpty()) {
				rightSide.add(node.val);
				Queue<TreeNode> tmp = curr;
				curr = children;
				children = tmp;
			}
		}

		return rightSide;
	}

}
