package com.john.datastructures;

import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * input: [1, null, 2, 3] produces the tree
     *
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     */
    public static TreeNode create(Integer[] input) {
        if (ArrayUtils.isEmpty(input) || input[0] == null) {
            return null;
        }

        Queue<TreeNode> unprocessed = new LinkedList<>();
        TreeNode root = new TreeNode(input[0]);
        unprocessed.add(root);

        for (int i = 1; i < input.length; i += 2) {
            TreeNode topOfQueue = unprocessed.poll();

            if (input[i] != null) {
                TreeNode left = new TreeNode(input[i]);
                topOfQueue.left = left;
                unprocessed.add(left);
            }
            if (i + 1 < input.length && input[i + 1] != null) {
                TreeNode right = new TreeNode(input[i + 1]);
                topOfQueue.right = right;
                unprocessed.add(right);
            }
        }

        return root;
    }

    /**
     * input: "[1, null, 2, 3]" produces the tree
     *
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     */
    public static TreeNode create(String input) {
        List<String> strs = Splitter.on(",").omitEmptyStrings().splitToList(StringUtils.strip(input, "[]"));

        return create(strs.stream()
            .map(s -> s.equals("null") ? null : Integer.parseInt(s))
            .toArray(Integer[]::new));
    }

    // TODO:
    // printing

    public Integer[] toArray() {
        List<Integer> ret = new ArrayList<>();

        Queue<TreeNode> unprocessed = new LinkedList<>();
        unprocessed.add(this);

        while (!unprocessed.isEmpty()) {
            TreeNode node = unprocessed.poll();
            if (node == null) {
                ret.add(null);
                continue;
            }

            ret.add(node.val);

            // both not null?
            if (node.left != null && node.right != null) {
                unprocessed.add(node.left);
                unprocessed.add(node.right);
                // only one not null
            } else if (node.left != null || node.right != null) {
                if (node.left != null) {
                    unprocessed.add(node.left);
                    unprocessed.add(null);
                } else {
                    unprocessed.add(null);
                    unprocessed.add(node.right);
                }
            }
        }

        if (ret.get(ret.size() - 1) == null) {
            ret.remove(ret.size() - 1);
        }

        return ret.toArray(new Integer[0]);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TreeNode)) {
            return false;
        }

        return TreeNode.equals(this, (TreeNode) obj);
    }

    public static boolean equals(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }

        Integer[] tree1 = treeNode1.toArray();
        Integer[] tree2 = treeNode2.toArray();

        if (tree1.length != tree2.length) {
            return false;
        }

        for (int i = 0; i < tree1.length; i++) {
            if (tree1[i] == null) {
                //if one is null and the other isn't, not equal
                if (tree2[i] != null) {
                    return false;
                }
                // if any digit is not equal, not equal
            } else if (!tree1[i].equals(tree2[i])) {
                return false;
            }
        }

        return true;
    }

    //TODO: write this
    //    @Override
    //    public String toString() {
    //
    //    }
}
