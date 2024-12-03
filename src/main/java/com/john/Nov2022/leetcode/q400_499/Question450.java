package com.john.Nov2022.leetcode.q400_499;

import com.john.datastructures.TreeNode;

public class Question450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (!treeContains(root, key)) {
            return root;
        } else if (root.val == key) {
            return deleteRoot(root);
        }

        deleteNode(root, null, key);

        return root;
    }

    private boolean treeContains(TreeNode root, int key) {
        if (root == null) {
            return false;
        } else if (root.val == key) {
            return true;
        } else if (root.val < key) {
            return treeContains(root.right, key);
        } else {
            return treeContains(root.left, key);
        }
    }

    private TreeNode deleteRoot(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode newRoot = disconnectNewRoot(root.right, root);
            newRoot.left = root.left;
            if (root.right != newRoot) {
                newRoot.right = root.right;
            }

            return newRoot;
        }
    }

    private TreeNode disconnectNewRoot(TreeNode newRootCandidate, TreeNode parent) {
        if (newRootCandidate.left != null) {
            return disconnectNewRoot(newRootCandidate.left, newRootCandidate);
        }

        // we found our new root candidate, disconnect it and return it

        // we recursed down the tree a bit
        if (parent.left == newRootCandidate) {
            parent.left = newRootCandidate.right;
            newRootCandidate.right = null;
        } else {
            // we didn't need to recurse, it's root's right node. don't need to do anything
        }
        return newRootCandidate;
    }

    private void deleteNode(TreeNode node, TreeNode parent, int key) {
        if (node.val == key) {
            boolean isRightNode = parent.right == node;
            TreeNode newNode = deleteRoot(node);
            if (isRightNode) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
        } else if (node.val < key) {
            deleteNode(node.right, node, key);
        } else {
            deleteNode(node.left, node, key);
        }
    }
}
