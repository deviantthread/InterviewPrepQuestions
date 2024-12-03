package com.john.leetcode.Nov2022.q700_799;

import com.john.datastructures.TreeNode;
import com.john.leetcode.Nov2022.q700_799.Question701;
import org.junit.Assert;
import org.junit.Test;

public class Question701Test {
    private final Question701 classUnderTest = new Question701();

    @Test
    public void testExample1() {
        TreeNode root = TreeNode.create("[4,2,7,1,3]");
        int val = 5;
        TreeNode expected = TreeNode.create("[4,2,7,1,3,5]");
        Assert.assertEquals(expected, classUnderTest.insertIntoBST(root, val));
    }

    @Test
    public void testExample2() {
        TreeNode root = TreeNode.create("[40,20,60,10,30,50,70]");
        int val = 25;
        TreeNode expected = TreeNode.create("[40,20,60,10,30,50,70,null,null,25]");
        Assert.assertEquals(expected, classUnderTest.insertIntoBST(root, val));
    }

    @Test
    public void testExample3() {
        TreeNode root = TreeNode.create("[4,2,7,1,3,null,null,null,null,null,null]");
        int val = 5;
        TreeNode expected = TreeNode.create("[4,2,7,1,3,5]");
        Assert.assertEquals(expected, classUnderTest.insertIntoBST(root, val));
    }
}
