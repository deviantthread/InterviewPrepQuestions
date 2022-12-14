package com.john.Nov2022.leetcode.q101_150;

import com.john.datastructures.TreeNode;

public class Question112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, 0, targetSum);
    }

    private boolean hasPathSum(TreeNode root, int currentSum, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return (currentSum + root.val) == targetSum;
        }

        return hasPathSum(root.left, currentSum + root.val, targetSum) ||
            hasPathSum(root.right, currentSum + root.val, targetSum);
    }
}
