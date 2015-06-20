package com.john.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question102 {

    public static void main(String[] args) {
        TreeNode pHead = new TreeNode(0);
        pHead.left = new TreeNode(-1);
        pHead.right = new TreeNode(1);
        pHead.left.left = new TreeNode(5);
        pHead.left.right = new TreeNode(9);

        List<List<Integer>> levels = new Question102().levelOrder(pHead);
        for (List<Integer> level : levels) {
            for (int num : level) {
                System.out.print(num + ", ");

            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        levels.add(new ArrayList<Integer>());

        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        curr.add(root);

        while (!curr.isEmpty()) {
            TreeNode n = curr.remove();
            levels.get(levels.size() - 1).add(n.val);

            if (n.left != null) {
                children.add(n.left);
            }
            if (n.right != null) {
                children.add(n.right);
            }

            if (curr.isEmpty()) {
                if (!children.isEmpty()) {
                    levels.add(new ArrayList<Integer>());
                }
                Queue<TreeNode> tmp = curr;
                curr = children;
                children = tmp;
            }
        }

        return levels;
    }

}
