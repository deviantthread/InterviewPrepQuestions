package com.john.leetcode;

public class Question101 {

    public static void main(String[] args) {
        OldTreeNode root = new OldTreeNode(1);
        root.left = new OldTreeNode(2);
        root.right = new OldTreeNode(2);
        root.left.left = new OldTreeNode(3);
        root.left.right = new OldTreeNode(4);
        root.right.left = new OldTreeNode(4);
        root.right.right = new OldTreeNode(3);

        OldTreeNode.printNodes(root);

        System.out.println(new Question101().isSymmetric(root));
    }

    public boolean isSymmetric(OldTreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(OldTreeNode left, OldTreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
