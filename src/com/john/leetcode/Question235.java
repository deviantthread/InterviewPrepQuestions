package com.john.leetcode;

public class Question235 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        TreeNode left = new TreeNode(2);
        root.left = left;
        left.left = new TreeNode(0);
        TreeNode leftRight = new TreeNode(4);
        left.right = leftRight;
        leftRight.left = new TreeNode(3);
        leftRight.right = new TreeNode(5);

        TreeNode right = new TreeNode(8);
        root.right = right;
        right.left = new TreeNode(7);
        right.right = new TreeNode(9);

        TreeNode.printNodes(root);

        TreeNode p = left;
        TreeNode q = left.right;
        System.out.println(new Question235().lowestCommonAncestor(root, p, q));

    }

    // it's a BST, its sorted, no need to check the rest of the tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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

    public TreeNode lowestCommonAncestorSlow(TreeNode root, TreeNode p, TreeNode q) {
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

    private boolean nodeExists(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return nodeExists(root.left, node) || nodeExists(root.right, node);
    }
}
