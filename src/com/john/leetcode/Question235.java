package com.john.leetcode;

public class Question235 {

    public static void main(String[] args) {

        OldTreeNode root = new OldTreeNode(6);
        OldTreeNode left = new OldTreeNode(2);
        root.left = left;
        left.left = new OldTreeNode(0);
        OldTreeNode leftRight = new OldTreeNode(4);
        left.right = leftRight;
        leftRight.left = new OldTreeNode(3);
        leftRight.right = new OldTreeNode(5);

        OldTreeNode right = new OldTreeNode(8);
        root.right = right;
        right.left = new OldTreeNode(7);
        right.right = new OldTreeNode(9);

        OldTreeNode.printNodes(root);

        OldTreeNode p = left;
        OldTreeNode q = left.right;
        System.out.println(new Question235().lowestCommonAncestor(root, p, q));

    }

    // it's a BST, its sorted, no need to check the rest of the tree
    public OldTreeNode lowestCommonAncestor(OldTreeNode root, OldTreeNode p, OldTreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        boolean pLeft = root.val > p.val;
        boolean qLeft = root.val > q.val;

        if (pLeft ^ qLeft) {
            return root;
        } else if (pLeft && qLeft) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public OldTreeNode lowestCommonAncestorSlow(OldTreeNode root, OldTreeNode p, OldTreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        boolean pLeft = nodeExists(root.left, p);
        boolean qLeft = nodeExists(root.left, q);

        if (pLeft ^ qLeft) {
            return root;
        } else if (pLeft && qLeft) {
            return lowestCommonAncestorSlow(root.left, p, q);
        } else {
            return lowestCommonAncestorSlow(root.right, p, q);
        }
    }

    private boolean nodeExists(OldTreeNode root, OldTreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return nodeExists(root.left, node) || nodeExists(root.right, node);
    }
}
