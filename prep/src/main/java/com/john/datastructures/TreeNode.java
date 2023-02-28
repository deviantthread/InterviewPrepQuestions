package com.john.datastructures;

import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

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
            .map(String::trim)
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

    public void println() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        int depth = findDepth(this);
        int maxLevelLen = (int) Math.pow(2, depth +1);
        List<List<String>> levels = IntStream.range(0, depth * 2 - 1)
            .mapToObj(i -> new ArrayList<String>())
            .collect(Collectors.toList());

        populateLevels(this, levels, 0, maxLevelLen / 2);

        String strTree = levels.stream()
            .map(levelList -> levelList.stream().reduce("", (a, b) -> a + b))
            .reduce("", (a, b) -> a + "\n" + b);

        return strTree;
    }

    private void populateLevels(TreeNode root, List<List<String>> levels, int currLevel, int leftPad) {
        levels.get(currLevel).add(StringUtils.leftPad(String.valueOf(root.val), leftPad, ' '));

        if (root.left != null) {
            levels.get(currLevel + 1).add(StringUtils.leftPad("/", leftPad - 1, ' '));
            populateLevels(root.left, levels, currLevel + 2, leftPad - 2);
        }

        if (root.right != null) {
            int pad = root.left != null ? 2 : leftPad + 1;
            levels.get(currLevel + 1).add(StringUtils.leftPad("\\", pad, ' '));
            populateLevels(root.right, levels, currLevel + 2, pad + 2);
        }
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
