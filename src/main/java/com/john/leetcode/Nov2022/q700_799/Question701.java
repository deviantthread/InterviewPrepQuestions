package com.john.leetcode.Nov2022.q700_799;

import com.john.datastructures.TreeNode;

public class Question701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        insertNode(root, val);

        return root;
    }

    private void insertNode(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertNode(root.right, val);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertNode(root.left, val);
            }
        }
    }
}
