package com.john.leetcode;

public class Question111 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        // root.left.left = new TreeNode(2);
        System.out.print(new Question111().minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepth(root, 1);
    }

    private int minDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }

        int left = Integer.MAX_VALUE;
        if (root.left != null) {
            left = minDepth(root.left, depth + 1);
        }
        int right = Integer.MAX_VALUE;
        if (root.right != null) {
            right = minDepth(root.right, depth + 1);
        }

        return Math.min(left, right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
