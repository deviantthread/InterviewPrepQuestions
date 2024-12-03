package com.john.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question103 {

    public static void main(String[] args) {
        OldTreeNode pHead = new OldTreeNode(1);
        pHead.left = new OldTreeNode(2);
        pHead.right = new OldTreeNode(3);
        pHead.left.left = new OldTreeNode(4);
        // pHead.left.right = new TreeNode(2);
        // pHead.right.left = new TreeNode(15);
        pHead.right.right = new OldTreeNode(5);

        List<List<Integer>> levels = new Question103().zigzagLevelOrder(pHead);
        for (List<Integer> level : levels) {
            for (int num : level) {
                System.out.print(num + ", ");

            }
            System.out.println();
        }
    }

    public List<List<Integer>> zigzagLevelOrder(OldTreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        levels.add(new LinkedList<Integer>());

        Queue<OldTreeNode> curr = new LinkedList<OldTreeNode>();
        Queue<OldTreeNode> children = new LinkedList<OldTreeNode>();
        curr.add(root);
        boolean forward = true;

        while (!curr.isEmpty()) {
            OldTreeNode n = curr.remove();
            List<Integer> level = levels.get(levels.size() - 1);
            if (forward) {
                level.add(n.val);
            } else {
                level.add(0, n.val);
            }

            if (n.left != null) {
                children.add(n.left);
            }
            if (n.right != null) {
                children.add(n.right);
            }

            if (curr.isEmpty()) {
                forward = !forward;
                if (!children.isEmpty()) {
                    levels.add(new ArrayList<Integer>());
                }

                Queue<OldTreeNode> tmp = curr;
                curr = children;
                children = tmp;
            }
        }

        return levels;
    }

}
