package com.john.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.google.common.base.Splitter;

public class OldTreeNode {

	public int val;
	public OldTreeNode left;
	public OldTreeNode right;

	public OldTreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeNode [" + val + "]";
	}

	public void print() {
		printNodes(this);
	}

	public void print(String msg) {
		printNodes(this, msg);
	}

	// public static void generateNodes(TreeNode head, int nodes) {
	// TreeNode curr = head;
	// for (int i = head.val + 1; i < head.val + nodes + 1; i++) {
	// curr.next = new TreeNode(i);
	// curr = curr.next;
	// }
	// }

	public static void printNodes(OldTreeNode head, String msg) {
		System.out.println(msg);
		printNodes(head);
	}

	public static void printNodes(OldTreeNode head) {
		if (head == null) {
			return;
		}

		Queue<OldTreeNode> curr = new LinkedList<OldTreeNode>();
		Queue<OldTreeNode> children = new LinkedList<OldTreeNode>();
		String nextLine = "\n";
		curr.add(head);

		while (!curr.isEmpty()) {
			OldTreeNode n = curr.remove();
			System.out.print(n.val + "   ");

			if (n.left != null) {
				children.add(n.left);
				nextLine += "/   ";
			} else {
				nextLine += " ";
			}

			if (n.right != null) {
				children.add(n.right);
				nextLine += "\\\t";
			} else {
				nextLine += " ";
			}

			if (curr.isEmpty()) {
				System.out.println(nextLine);
				nextLine = "\n";
				Queue<OldTreeNode> tmp = curr;
				curr = children;
				children = tmp;
			}
		}

		System.out.println();
	}

	public static void printNodes2(OldTreeNode head) {
		// to do this better, use an algorithm similar to this:
		// get the height h
		// each node gets three characters, ' 1 ', or ' 10'
		// the bottom line will require (2^h)*3 characters to print.
		// every line needs to figure out how much spaces to prepend
	}

	/**
	 * pass in "10|5,15|3,7,,17". '|' for level separators, ',' for element
	 * separator
	 */
	public static OldTreeNode generateTree(String tree) {
		Iterable<String> levels = Splitter.on('|').split(tree);
		Iterator<String> levelsIter = levels.iterator();
		OldTreeNode root = new OldTreeNode(Integer.parseInt(levelsIter.next()));
		Queue<OldTreeNode> q = new LinkedList<OldTreeNode>();
		q.add(root);

		while (levelsIter.hasNext()) {
			String level = levelsIter.next();
			Iterable<String> nodeVals = Splitter.on(',').split(level);
			Iterator<String> nodeValsIter = nodeVals.iterator();
			while (nodeValsIter.hasNext()) {
				OldTreeNode node = q.poll();
				String leftVal = nodeValsIter.next();
				if (!leftVal.equals("")) {
					node.left = new OldTreeNode(Integer.parseInt(leftVal));
					q.add(node.left);
				}
				if (nodeValsIter.hasNext()) {
					String rightVal = nodeValsIter.next();
					if (!rightVal.equals("")) {
						node.right = new OldTreeNode(Integer.parseInt(rightVal));
						q.add(node.right);
					}
				}
			}
		}

		return root;
	}
}
