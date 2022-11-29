package com.john.Nov2022.leetcode.q101_150;

import com.john.datastructures.TreeNode;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class Question144Test {

    private Question144 classUnderTest = new Question144();

    @Test
    public void testExample1() {
        Integer[] input = { 1, null, 2, 3 };
        Integer[] expected = { 1, 2, 3 };

        TreeNode treeInput = TreeNode.create(input);

        List<Integer> output = classUnderTest.preorderTraversal(treeInput);
        Assert.assertArrayEquals(expected, output.toArray(new Integer[0]));
    }

    @Test
    public void testExample2() {
        Integer[] input = {};
        Integer[] expected = {};

        TreeNode treeInput = TreeNode.create(input);

        List<Integer> output = classUnderTest.preorderTraversal(treeInput);

        Assert.assertArrayEquals(expected, output.toArray(new Integer[0]));
    }

    @Test
    public void testExample3() {
        Integer[] input = { 1 };
        Integer[] expected = { 1 };

        TreeNode treeInput = TreeNode.create(input);

        List<Integer> output = classUnderTest.preorderTraversal(treeInput);

        Assert.assertArrayEquals(expected, output.toArray(new Integer[0]));
    }

    @Test
    public void testExample4() {
        Integer[] input = { 1, 4, 3, 2 };
        Integer[] expected = { 1, 4, 2, 3 };

        TreeNode treeInput = TreeNode.create(input);

        List<Integer> output = classUnderTest.preorderTraversal(treeInput);

        Assert.assertArrayEquals(expected, output.toArray(new Integer[0]));
    }
}