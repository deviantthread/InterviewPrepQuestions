package com.john.leetcode;

public class Question116 {

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left = new TreeLinkNode(2);
        TreeLinkNode right = new TreeLinkNode(3);
        root.left = left;
        root.right = right;
        left.left = new TreeLinkNode(4);
        left.right = new TreeLinkNode(5);
        right.left = new TreeLinkNode(6);
        right.right = new TreeLinkNode(7);

        new Question116().connect(root);

    }

    public void connect(TreeLinkNode root) {
        // one way to do this is with the normal BFS the tree using queues. if the queue is not empty, peek at the next
        // node in the queue, that is your next node

        // but that requires n/2 extra space for the queue. question says constant extra space
    }

    private static class TreeLinkNode extends TreeNode {
        TreeLinkNode next;

        public TreeLinkNode(int val) {
            super(val);
        }
    }
}
