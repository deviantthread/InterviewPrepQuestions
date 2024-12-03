package com.john.leetcode.Nov2022.q100_199;

import com.john.datastructures.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Question100Test {
    private Question100 classUnderTest = new Question100();

    @Test
    public void testExample1() {

        TreeNode p = TreeNode.create("[1,2,3]");
        TreeNode q = TreeNode.create("[1,2,3]");
        boolean expected = true;

        Assert.assertEquals(expected, classUnderTest.isSameTree(p, q));
    }

    @Test
    public void testExample2() {

        TreeNode p = TreeNode.create("[1,2]");
        TreeNode q = TreeNode.create("[1,null,2]");
        boolean expected = false;

        Assert.assertEquals(expected, classUnderTest.isSameTree(p, q));
    }

    @Test
    public void testExample3() {

        TreeNode p = TreeNode.create("[1,2,1]");
        TreeNode q = TreeNode.create("[1,1,2]");
        boolean expected = false;

        Assert.assertEquals(expected, classUnderTest.isSameTree(p, q));
    }
}