package com.john.leetcode.template.q700_799;

import com.john.datastructures.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Question700Test {
    private final Question700 classUnderTest = new Question700();

    @Test
    public void testExample1() {
        TreeNode root = TreeNode.create("[4,2,7,1,3]");
        int val = 2;
        TreeNode expected = TreeNode.create("[2,1,3]");
        Assert.assertEquals(expected, classUnderTest.searchBST(root, val));
    }

    @Test
    public void testExample2() {
        TreeNode root = TreeNode.create("[4,2,7,1,3]");
        int val = 5;
        TreeNode expected = TreeNode.create("[]");
        Assert.assertEquals(expected, classUnderTest.searchBST(root, val));
    }
}
