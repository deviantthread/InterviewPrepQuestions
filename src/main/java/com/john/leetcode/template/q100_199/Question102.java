package com.john.leetcode.template.q100_199;

import com.john.datastructures.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> children = new LinkedList<>();
        q.offer(root);

        List<Integer> level = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            level.add(curr.val);

            if (curr.left != null) {
                children.offer(curr.left);
            }
            if (curr.right != null) {
                children.offer(curr.right);
            }

            if (q.isEmpty() && !children.isEmpty()) {
                q = children;
                children = new LinkedList<>();
                ret.add(level);
                level = new ArrayList<>();
            }
        }

        if (!level.isEmpty()) {
            ret.add(level);
        }

        return ret;
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ret = new ArrayList<>();

        dfs(ret, root, 0);

        return ret;
    }

    private void dfs(List<List<Integer>> ret, TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (ret.size() <= depth) {
            ret.add(new ArrayList<>());
        }

        ret.get(depth).add(root.val);

        dfs(ret, root.left, depth + 1);
        dfs(ret, root.right, depth + 1);
    }
}
