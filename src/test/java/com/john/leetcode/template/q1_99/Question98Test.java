package com.john.leetcode.template.q1_99;

import com.john.datastructures.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Question98Test {
    private Question98 classUnderTest = new Question98();

    @Test
    public void testExample1() {
        TreeNode root = TreeNode.create("2,1,3");
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.isValidBST(root));
    }

    @Test
    public void testExample2() {
        TreeNode root = TreeNode.create("5,1,4,null,null,3,6");
        boolean expected = false;
        Assert.assertEquals(expected, classUnderTest.isValidBST(root));
        //    Explanation: The root node's value is 5 but its right child's value is 4.
    }
}
