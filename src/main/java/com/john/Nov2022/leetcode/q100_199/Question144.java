package com.john.Nov2022.leetcode.q100_199;

import com.john.datastructures.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Question144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        preorderTraversalRecurse(root, ret);

        return ret;
    }

    private void preorderTraversalRecurse(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        }
        ret.add(node.val);
        preorderTraversalRecurse(node.left, ret);
        preorderTraversalRecurse(node.right, ret);
    }
}
