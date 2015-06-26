package com.john.leetcode;

import java.util.Stack;

public class Question173 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(20);
        TreeNode.printNodes(root, "original");

        BSTIterator bstIterator = new Question173().new BSTIterator(null);

        while (bstIterator.hasNext()) {
            System.out.print(bstIterator.next() + ", ");
        }
    }

    public class BSTIterator {

        private final Stack<NodeStatus> stack = new Stack<NodeStatus>();
        private NodeStatus curr = null;

        public BSTIterator(TreeNode root) {
            if (root != null) {
                stack.push(new NodeStatus(root));
            }
            curr = getNextReady();
        }

        public NodeStatus getNextReady() {
            while (!stack.isEmpty()) {
                NodeStatus peek = stack.peek();
                if (peek.node.left != null && !peek.haveGoneLeft) {
                    stack.push(new NodeStatus(peek.node.left));
                    peek.haveGoneLeft = true;
                } else if (!peek.haveBeenPrinted) {
                    peek.haveBeenPrinted = true;
                    return peek;
                } else if (peek.node.right != null && !peek.haveGoneRight) {
                    stack.push(new NodeStatus(peek.node.right));
                    peek.haveGoneRight = true;
                } else {
                    stack.pop();
                }
            }
            return null;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return curr != null;
        }

        /** @return the next smallest number */
        public int next() {
            NodeStatus prev = curr;
            curr = getNextReady();
            return prev.node.val;
        }
    }

    private static class NodeStatus {
        public boolean haveGoneRight;
        TreeNode node;
        boolean haveGoneLeft = false;
        boolean haveBeenPrinted = false;

        public NodeStatus(TreeNode root) {
            node = root;
        }

        @Override
        public String toString() {
            return String.valueOf(node.val);
        }
    }

}
