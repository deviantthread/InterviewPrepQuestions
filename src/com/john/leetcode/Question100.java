package com.john.leetcode;

public class Question100 {

    public static void main(String[] args) {

        TreeNode pHead = new TreeNode(0);
        // pHead.left = new TreeNode(-1);
        // pHead.right = new TreeNode(1);

        TreeNode qHead = new TreeNode(0);
        // qHead.left = new TreeNode(-1);
        // qHead.right = new TreeNode(0);

        TreeNode.printNodes(pHead, "pHead");
        TreeNode.printNodes(qHead, "qHead");

        System.out.println(new Question100().isSameTree(pHead, qHead));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
