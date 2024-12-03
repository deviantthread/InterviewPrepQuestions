package com.john.Nov2022.leetcode.q200_299;

import com.john.datastructures.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Question230Test {
    private final Question230 classUnderTest = new Question230();

    @Test
    public void testExample1() {
        TreeNode root = TreeNode.create("[3,1,4,null,2]");
        int k = 1;
        int expected = 1;
        Assert.assertEquals(expected, classUnderTest.kthSmallest(root, k));
    }

    @Test
    public void testExample2() {
        TreeNode root = TreeNode.create("[5,3,6,2,4,null,null,1]");
        int k = 3;
        int expected = 3;
        Assert.assertEquals(expected, classUnderTest.kthSmallest(root, k));
    }

    @Test
    public void testExample3() {
        TreeNode root = TreeNode.create("[31,30,48,3,null,38,49,0,16,35,47,null,null,null,2,15,27,33,37,39,null,1,null,5,null,22,28,32,34,36,null,null,43,null,null,4,11,19,23,null,29,null,null,null,null,null,null,40,46,null,null,7,14,17,21,null,26,null,null,null,41,44,null,6,10,13,null,null,18,20,null,25,null,null,42,null,45,null,null,8,null,12,null,null,null,null,null,24,null,null,null,null,null,null,9]");

        int k = 1;
        int expected = 0;

        Assert.assertEquals(expected, classUnderTest.kthSmallest(root, k));
    }
}
