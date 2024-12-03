package com.john.leetcode.Nov2022.q100_199;

import com.john.datastructures.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> ret = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> children = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left != null) {
                children.offer(curr.left);
            }
            if (curr.right != null) {
                children.offer(curr.right);
            }

            // right most element, append to list and move to next line
            if (q.isEmpty()) {
                ret.add(curr.val);
                q = children;
                children = new LinkedList<>();
            }
        }

        return ret;
    }
}
