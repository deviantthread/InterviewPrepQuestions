package com.john.leetcode.Nov2022.q200_299;

import com.john.datastructures.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

public class Question230 {
    public int kthSmallest(TreeNode root, int k) {

        AtomicInteger currNodeNum = new AtomicInteger(0);

        return inorderTraverse(root, k, currNodeNum);
    }

    private int inorderTraverse(TreeNode root, int k, AtomicInteger currNodeNum) {
        if (root == null) {
            return -1;
        }

        // found it in my left
        int found = inorderTraverse(root.left, k, currNodeNum);
        if (found >= 0) {
            return found;
        }

        // found it
        if (currNodeNum.incrementAndGet() == k) {
            return root.val;
        }

        // found it in my right
        found = inorderTraverse(root.right, k, currNodeNum);
        if (found >= 0) {
            return found;
        }

        // didn't find it yet. recurse up
        return -1;
    }
}
