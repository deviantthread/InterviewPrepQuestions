package com.john.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question107 {

    public static void main(String[] args) {
        OldTreeNode root = new OldTreeNode(3);
        root.left = new OldTreeNode(9);
        root.right = new OldTreeNode(20);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(2);
        root.right.left = new OldTreeNode(15);
        root.right.right = new OldTreeNode(7);
        OldTreeNode.printNodes(root);

        List<List<Integer>> levels = new Question107().levelOrderBottom(root);
        for (List<Integer> level : levels) {
            for (int num : level) {
                System.out.print(num + ", ");

            }
            System.out.println();
        }

    }

    public List<List<Integer>> levelOrderBottom(OldTreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<OldTreeNode> curr = new LinkedList<OldTreeNode>();
        Queue<OldTreeNode> children = new LinkedList<OldTreeNode>();
        List<List<Integer>> levels = new LinkedList<List<Integer>>();
        levels.add(new ArrayList<Integer>());

        curr.add(root);
        while (!curr.isEmpty()) {
            OldTreeNode n = curr.remove();
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
                Queue<OldTreeNode> tmp = curr;
                curr = children;
                children = tmp;
            }

        }

        return levels;
    }

}
