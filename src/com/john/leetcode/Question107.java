package com.john.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question107 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeNode.printNodes(root);

        List<List<Integer>> levels = new Question107().levelOrderBottom(root);
        for (List<Integer> level : levels) {
            for (int num : level) {
                System.out.print(num + ", ");

            }
            System.out.println();
        }

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        List<List<Integer>> levels = new LinkedList<List<Integer>>();
        levels.add(new ArrayList<Integer>());

        curr.add(root);
        while (!curr.isEmpty()) {
            TreeNode n = curr.remove();
            levels.get(0).add(n.val);
            if (n.left != null) {
                children.add(n.left);
            }
            if (n.right != null) {
                children.add(n.right);
            }

            if (curr.isEmpty()) {
                if (!children.isEmpty()) {
                    levels.add(0, new ArrayList<Integer>());
                }
                Queue<TreeNode> tmp = curr;
                curr = children;
                children = tmp;
            }

        }

        return levels;
    }

}
