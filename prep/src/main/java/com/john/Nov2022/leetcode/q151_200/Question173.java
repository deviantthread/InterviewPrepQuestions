package com.john.Nov2022.leetcode.q151_200;

import com.john.datastructures.TreeNode;
import java.util.Stack;

public class Question173 {
    static class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            updateLowestNode(root);
        }

        public int next() {
            TreeNode top = stack.pop();
            updateLowestNode(top.right);

            return top.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void updateLowestNode(TreeNode root) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
        }
    }
}
