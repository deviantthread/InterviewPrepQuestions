package com.john.leetcode.Nov2022.q700_799;

import com.john.datastructures.TreeNode;

public class Question700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
