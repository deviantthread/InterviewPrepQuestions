package com.john.Nov2022.leetcode.q101_150;

import com.john.datastructures.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Question101Test {
    private Question101 classUnderTest = new Question101();

    @Test
    public void testExample1() {

        TreeNode root = TreeNode.create("[1,2,2,3,4,4,3]");
        boolean expected = true;

        Assert.assertEquals(expected, classUnderTest.isSymmetric(root));
    }

    @Test
    public void testExample2() {

        TreeNode root = TreeNode.create("[1,2,2,null,3,null,3]");
        boolean expected = false;

        Assert.assertEquals(expected, classUnderTest.isSymmetric(root));
    }
}
