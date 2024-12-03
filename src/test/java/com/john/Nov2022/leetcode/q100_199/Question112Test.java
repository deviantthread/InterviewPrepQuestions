package com.john.Nov2022.leetcode.q100_199;

import com.john.datastructures.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Question112Test {
    private Question112 classUnderTest = new Question112();

    @Test
    public void testExample1() {
        TreeNode root = TreeNode.create("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        int targetSum = 22;
        boolean expected = true;
        //    Explanation: The root-to-leaf path with the target sum is shown.
        Assert.assertEquals(expected, classUnderTest.hasPathSum(root, targetSum));
    }

    @Test
    public void testExample2() {
        TreeNode root = TreeNode.create("[1,2,3]");
        int targetSum = 5;
        boolean expected = false;
        //    Explanation: There two root-to-leaf paths in the tree:
        //        (1 --> 2): The sum is 3.
        //        (1 --> 3): The sum is 4.
        //    There is no root-to-leaf path with sum = 5.
        Assert.assertEquals(expected, classUnderTest.hasPathSum(root, targetSum));
    }

    @Test
    public void testExample3() {
        TreeNode root = TreeNode.create("[]");
        int targetSum = 0;
        boolean expected = false;
        //    Explanation: Since the tree is empty, there are no root-to-leaf paths.
        Assert.assertEquals(expected, classUnderTest.hasPathSum(root, targetSum));
    }

    @Test
    public void testExample4() {
        TreeNode root = TreeNode.create("[1,2]");
        int targetSum = 1;
        boolean expected = false;
        //    Explanation: Since the tree is empty, there are no root-to-leaf paths.
        Assert.assertEquals(expected, classUnderTest.hasPathSum(root, targetSum));
    }
}