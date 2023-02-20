package com.john.leetcode;

public class Question98 {

    public static void main(String[] args) {
        OldTreeNode root = new OldTreeNode(0);
        // root.left = new TreeNode(3);
        // root.right = new TreeNode(20);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(2);
        // root.right.left = new TreeNode(15);
        // root.right.right = new TreeNode(27);
        OldTreeNode.printNodes(root);
        System.out.println(new Question98().isValidBST(root));
    }

    public boolean isValidBST(OldTreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(OldTreeNode node, Integer minValue, Integer maxValue) {
        if (node == null) {
            return true;
        } else if (minValue != null && node.val <= minValue) {
            return false;
        } else if (maxValue != null && node.val >= maxValue) {
            return false;
        }

        return isValidBST(node.left, minValue, node.val) && isValidBST(node.right, node.val, maxValue);
    }

}
