package com.john.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question145 {

	public static void main(String[] args) {
		OldTreeNode root = OldTreeNode.generateTree("1|0,");
		OldTreeNode.printNodes(root);
		List<Integer> postorderTraversal = new Question145().postorderTraversal(root);
		List<Integer> postorderTraversalRec = new Question145().postorderTraversalRecursive(root);
		CollUtils.print(postorderTraversalRec, "recurse");
		CollUtils.print(postorderTraversal, "iter");
	}

	public List<Integer> postorderTraversal(OldTreeNode root) {
		return postOrderTraversalIterative(root);
	}

	public List<Integer> postorderTraversalRecursive(OldTreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		postorderTraversalRecursive(root, ret);
		return ret;
	}

	private List<Integer> postOrderTraversalIterative(OldTreeNode root) {
		Stack<OldTreeNode> stack = new Stack<OldTreeNode>();
		Stack<Integer> stack2 = new Stack<Integer>();
		if (root != null) {
			stack.push(root);
		}

		while (!stack.isEmpty()) {
			OldTreeNode node = stack.pop();

			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
			stack2.push(node.val);
		}

		List<Integer> ret = new ArrayList<Integer>();
		while (!stack2.isEmpty()) {
			ret.add(stack2.pop());
		}
		return ret;
	}

	// works
	private void postorderTraversalRecursive(OldTreeNode node, List<Integer> ret) {
		if (node == null) {
			return;
		}

		postorderTraversalRecursive(node.left, ret);
		postorderTraversalRecursive(node.right, ret);
		ret.add(node.val);
	}
}
