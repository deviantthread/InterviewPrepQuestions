package com.john.Nov2022.leetcode.q100_199;

import com.john.datastructures.TreeNode;

public class Question104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
