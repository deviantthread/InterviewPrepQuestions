package com.john.Nov2022.leetcode.q100_199;

import com.john.datastructures.TreeNode;

public class Question101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        }

        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}
