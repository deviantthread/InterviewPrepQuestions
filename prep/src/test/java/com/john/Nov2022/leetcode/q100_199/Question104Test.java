package com.john.Nov2022.leetcode.q100_199;

import com.john.datastructures.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Question104Test {
    private Question104 classUnderTest = new Question104();

    @Test
    public void testExample1() {

        TreeNode root = TreeNode.create(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        int expected = 3;

        Assert.assertEquals(expected, classUnderTest.maxDepth(root));
    }

    @Test
    public void testExample2() {

        TreeNode root = TreeNode.create(new Integer[] { 1, null, 2 });
        int expected = 2;

        Assert.assertEquals(expected, classUnderTest.maxDepth(root));
    }
}