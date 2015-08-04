package com.john.randominterviews;

public class TrinaryTree {

	private Node root;

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
		// find node
		// couldn't find node? its ok! just quit
		// did find node? well...
		// does node have a mid? kill one mid element
		// is node leaf? delete it from parent
		// does node have one child? link parent to that child, ie replace
		// parent->node link with parent->child link
		// does node have two children? now its complicated...
		// find min value in right subtree.
		// copy min value to current node, copy mid's to current node.
		// delete the (now duplicate) min node
		// also, might need to update root, keep that in mind

		ParentDeleteNodePair pair = findParent(root, val);
		// val doesn't exist in the tree
		boolean valExistsInTree = pair != null;
		if (valExistsInTree) {
			deleteNode(pair, true);
		}
	}

	private void deleteNode(ParentDeleteNodePair pair, boolean deleteMidIfPossible) {
		Node node = pair.nodeToDelete;
		boolean hasRight = node.right != null;
		boolean hasLeft = node.left != null;
		boolean isLeaf = !(hasRight && hasLeft);
		boolean hasExactlyOneChild = hasRight ^ hasLeft;

		if (node.mid != null) {
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
		// find min in right subtree.
		// save its val and mid's
		// call delete on that min val
		// set pair.nodeToDelete to val and mids
		ParentDeleteNodePair nextLargestPair = findMin(pair.nodeToDelete.right);
		deleteNode(nextLargestPair, false);
		Node node = pair.nodeToDelete;
		Node replacementNode = nextLargestPair.nodeToDelete;
		node.val = replacementNode.val;
		node.mid = replacementNode.mid;
	}

	private ParentDeleteNodePair findMin(Node node) {
		Node parent = null;
		Node curr = node;

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

	// maybe move this out to the test file?
	// for easy unit testing, to verify the tree is updated correctly
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		treeToSB(root, sb);

		return sb.toString();
	}

	private void treeToSB(Node node, StringBuilder sb) {
		if (node == null) {
			return;
		}
		treeToSB(node.left, sb);

		sb.append(node.val).append(",");
		Node midNode = node.mid;
		while (midNode != null) {
			sb.append(midNode.val).append(",");
			midNode = midNode.mid;
		}

		treeToSB(node.right, sb);
	}

	private static class Node {
		private int val;
		private Node left = null;
		private Node right = null;
		private Node mid = null;

		public Node(int val) {
			this.val = val;
		}
	}

	private static class ParentDeleteNodePair {
		private Node parent;
		private Node nodeToDelete;

		public ParentDeleteNodePair(Node parent, Node nodeToDelete) {
			this.parent = parent;
			this.nodeToDelete = nodeToDelete;
		}

		public boolean isRoot() {
			return parent == null;
		}
	}

}
