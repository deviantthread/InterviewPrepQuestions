package com.john.randominterviews;

// source file

public class TrinaryTree {

	private Node root;

	// package private for unit tests
	Node getRoot() {
		return root;
	}

	public void insert(int val) {
		if (root == null) {
			root = new Node(val);
		} else {
			insertRecurse(root, val);
		}
	}

	private void insertRecurse(Node node, int valToAdd) {
		if (node.val < valToAdd) {
			if (node.right != null) {
				insertRecurse(node.right, valToAdd);
			} else {
				node.right = new Node(valToAdd);
			}
		} else if (node.val > valToAdd) {
			if (node.left != null) {
				insertRecurse(node.left, valToAdd);
			} else {
				node.left = new Node(valToAdd);
			}
		} else {
			Node oldMidHead = node.mid;
			Node newMidHead = new Node(valToAdd);
			newMidHead.mid = oldMidHead;
			node.mid = newMidHead;
		}
	}

	public void delete(int val) {
		ParentDeleteNodePair pair = findParent(root, val);

		boolean valExistsInTree = pair != null;
		if (valExistsInTree) {
			deleteNode(pair, true);
		}
	}

	private void deleteNode(ParentDeleteNodePair pair, boolean deleteMidIfPossible) {
		Node node = pair.nodeToDelete;
		boolean hasRight = node.right != null;
		boolean hasLeft = node.left != null;
		boolean isLeaf = !(hasRight || hasLeft);
		boolean hasExactlyOneChild = hasRight ^ hasLeft;

		if (node.mid != null && deleteMidIfPossible) {
			deleteMid(node);
		} else if (isLeaf) {
			deleteNoChild(pair);
		} else if (hasExactlyOneChild) {
			deleteOneChild(pair);
		} else {
			deleteTwoChildren(pair);
		}
	}

	private void deleteMid(Node node) {
		node.mid = node.mid.mid;
	}

	private void deleteNoChild(ParentDeleteNodePair pair) {
		Node parent = pair.parent;

		if (pair.isRoot()) {
			root = null;
		} else if (parent.right == pair.nodeToDelete) {
			parent.right = null;
		} else {
			parent.left = null;
		}
	}

	private void deleteOneChild(ParentDeleteNodePair pair) {
		Node parent = pair.parent;
		Node nodeToDelete = pair.nodeToDelete;
		Node child = nodeToDelete.right != null ? nodeToDelete.right : nodeToDelete.left;

		if (pair.isRoot()) {
			root = child;
		} else if (parent.right == pair.nodeToDelete) {
			parent.right = child;
		} else {
			parent.left = child;
		}

	}

	private void deleteTwoChildren(ParentDeleteNodePair pair) {
		ParentDeleteNodePair nextLargestPair = findNextLargest(pair.nodeToDelete);
		deleteNode(nextLargestPair, false);
		Node node = pair.nodeToDelete;
		Node replacementNode = nextLargestPair.nodeToDelete;

		node.val = replacementNode.val;
		node.mid = replacementNode.mid;
	}

	private ParentDeleteNodePair findNextLargest(Node node) {
		Node parent = node;
		Node curr = node.right;

		while (curr.left != null) {
			parent = curr;
			curr = curr.left;
		}
		return new ParentDeleteNodePair(parent, curr);
	}

	private ParentDeleteNodePair findParent(Node node, int val) {
		if (node == null) {
			return null;
		}

		if (node.left != null && node.left.val == val) {
			return new ParentDeleteNodePair(node, node.left);
		} else if (node.right != null && node.right.val == val) {
			return new ParentDeleteNodePair(node, node.right);
		}

		if (node.val < val) {
			return findParent(node.right, val);
		} else if (node.val > val) {
			return findParent(node.left, val);
		} else {
			return new ParentDeleteNodePair(null, node);
		}

	}

	private static class ParentDeleteNodePair {
		private final Node parent;
		private final Node nodeToDelete;

		public ParentDeleteNodePair(Node parent, Node nodeToDelete) {
			this.parent = parent;
			this.nodeToDelete = nodeToDelete;
		}

		public boolean isRoot() {
			return parent == null;
		}
	}

	static class Node {
		int val;
		Node left = null;
		Node right = null;
		Node mid = null;

		public Node(int val) {
			this.val = val;
		}

	}

}
