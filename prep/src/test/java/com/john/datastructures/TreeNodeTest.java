package com.john.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class TreeNodeTest {

    @Test
    public void testCreate() {
        Integer[] input = { 1, null, 2, 3 };
        TreeNode root = TreeNode.create(input);

        Assert.assertEquals(1, root.val);
        Assert.assertNull(root.left);
        TreeNode right = root.right;

        Assert.assertEquals(2, right.val);
        Assert.assertNull(right.right);

        TreeNode rightLeft = right.left;
        Assert.assertEquals(3, rightLeft.val);

        Assert.assertNull(rightLeft.left);
        Assert.assertNull(rightLeft.right);
    }

    @Test
    public void testToArray() {
        Integer[] expected = { 1, null, 2, 3 };
        TreeNode root = TreeNode.create(expected);

        Integer[] output = root.toArray();

        Assert.assertArrayEquals(expected, output);
    }

    @Test
    public void testToArray2() {
        Integer[] expected = { 1, null, 2, 3, 5 };
        TreeNode root = TreeNode.create(expected);

        Integer[] output = root.toArray();

        Assert.assertArrayEquals(expected, output);
    }

    @Test
    public void testEquals() {
        Integer[] input = { 1, null, 2, 3 };
        TreeNode root = TreeNode.create(input);
        TreeNode root2 = TreeNode.create(input);

        Assert.assertTrue(TreeNode.equals(root, root2));
    }

    @Test
    public void testNotEqualsLength() {
        Integer[] input1 = { 1, null, 2, 3, 4 };
        Integer[] input2 = { 1, null, 2, 3 };
        TreeNode root = TreeNode.create(input1);
        TreeNode root2 = TreeNode.create(input2);

        Assert.assertFalse(TreeNode.equals(root, root2));
    }

    @Test
    public void testNotEqualsValue() {
        Integer[] input1 = { 1, null, 2, 3 };
        Integer[] input2 = { 1, null, 2, 4 };
        TreeNode root = TreeNode.create(input1);
        TreeNode root2 = TreeNode.create(input2);

        Assert.assertFalse(TreeNode.equals(root, root2));
    }
}