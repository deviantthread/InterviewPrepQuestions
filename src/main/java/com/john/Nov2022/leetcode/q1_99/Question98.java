package com.john.Nov2022.leetcode.q1_99;

import com.john.datastructures.TreeNode;

public class Question98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, null, root.val) &&
            isValidBST(root.right, root.val, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        } else if (min != null && root.val <= min) {
            return false;
        } else if (max != null && root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) &&
            isValidBST(root.right, root.val, max);
    }
}
