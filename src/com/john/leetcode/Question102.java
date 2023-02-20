package com.john.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question102 {

    public static void main(String[] args) {
        OldTreeNode pHead = new OldTreeNode(0);
        pHead.left = new OldTreeNode(-1);
        pHead.right = new OldTreeNode(1);
        pHead.left.left = new OldTreeNode(5);
        pHead.left.right = new OldTreeNode(9);

        List<List<Integer>> levels = new Question102().levelOrder(pHead);
        for (List<Integer> level : levels) {
            for (int num : level) {
                System.out.print(num + ", ");

            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(OldTreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        levels.add(new ArrayList<Integer>());

        Queue<OldTreeNode> curr = new LinkedList<OldTreeNode>();
        Queue<OldTreeNode> children = new LinkedList<OldTreeNode>();
        curr.add(root);

        while (!curr.isEmpty()) {
            OldTreeNode n = curr.remove();
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
                Queue<OldTreeNode> tmp = curr;
                curr = children;
                children = tmp;
            }
        }

        return levels;
    }

}
