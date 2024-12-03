package com.john.leetcode;

public class Question100 {

    public static void main(String[] args) {

        OldTreeNode pHead = new OldTreeNode(0);
        // pHead.left = new TreeNode(-1);
        // pHead.right = new TreeNode(1);

        OldTreeNode qHead = new OldTreeNode(0);
        // qHead.left = new TreeNode(-1);
        // qHead.right = new TreeNode(0);

        OldTreeNode.printNodes(pHead, "pHead");
        OldTreeNode.printNodes(qHead, "qHead");

        System.out.println(new Question100().isSameTree(pHead, qHead));

    }

    public boolean isSameTree(OldTreeNode p, OldTreeNode q) {
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
