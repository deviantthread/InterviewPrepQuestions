package com.john.Nov2022.leetcode.q1_99;

import com.john.datastructures.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Question94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        inorderTraversalRecurse(root, result);

        return result;
    }

    private void inorderTraversalRecurse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversalRecurse(root.left, result);
        result.add(root.val);
        inorderTraversalRecurse(root.right, result);
    }
}
