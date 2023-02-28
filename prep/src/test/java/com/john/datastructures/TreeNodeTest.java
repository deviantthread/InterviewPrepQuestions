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

    @Test
    public void testPrintlnSmallTree() {
        TreeNode root = TreeNode.create("[5,2,7]");
        root.println();
    }

    @Test
    public void testPrintlnMediumTree() {
        TreeNode root = TreeNode.create("[5,3,6,2,4,null,null,1]");
        root.println();
    }
    @Test
    public void testPrintlnMediumFullTree() {
        TreeNode root = TreeNode.create("[10,4,15,2,6,12,20,1,3,5,7]");
        root.println();
    }

    @Test
    public void testPrintlnLargeTree() {
        TreeNode root = TreeNode.create("[31,30,48,3,null,38,49,0,16,35,47,null,null,null,2,15,27,33,37,39,null,1,null,5,null,22,28,32,34,36,null,null,43,null,null,4,11,19,23,null,29,null,null,null,null,null,null,40,46,null,null,7,14,17,21,null,26,null,null,null,41,44,null,6,10,13,null,null,18,20,null,25,null,null,42,null,45,null,null,8,null,12,null,null,null,null,null,24,null,null,null,null,null,null,9]");
        root.println();
    }
}