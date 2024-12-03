package com.john.leetcode;

public class Question226 {

    public static void main(String[] args) {
        OldTreeNode root = new OldTreeNode(4);
        root.left = new OldTreeNode(2);
        root.right = new OldTreeNode(7);
        root.left.left = new OldTreeNode(1);
        root.left.right = new OldTreeNode(3);
        root.right.left = new OldTreeNode(6);
        root.right.right = new OldTreeNode(9);

        OldTreeNode.printNodes(root, "original");

        OldTreeNode inverted = new Question226().invertTree(root);

        OldTreeNode.printNodes(inverted, "inverted");
    }

    public OldTreeNode invertTree(OldTreeNode root) {
        if (root == null) {
            return null;
        }

        OldTreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
