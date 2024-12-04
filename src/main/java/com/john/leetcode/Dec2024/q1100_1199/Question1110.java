package com.john.leetcode.Dec2024.q1100_1199;

import com.john.datastructures.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deletedInts = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> result = new ArrayList<>();
        if (!deletedInts.contains(root.val)) {
            result.add(root);
        }
        delNodesRecurse(null, root, deletedInts, result);
        return result;
    }

    private void delNodesRecurse(TreeNode parent, TreeNode root, Set<Integer> deletedInts, List<TreeNode> result) {
        if (root == null) {
            return;
        }

        delNodesRecurse(root, root.left, deletedInts, result);
        delNodesRecurse(root, root.right, deletedInts, result);

        if (deletedInts.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            if (parent != null) {
                if (parent.left == root) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }
}
