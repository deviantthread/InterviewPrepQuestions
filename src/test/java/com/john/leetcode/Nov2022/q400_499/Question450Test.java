package com.john.leetcode.Nov2022.q400_499;

import com.john.datastructures.TreeNode;
import com.john.leetcode.Nov2022.q400_499.Question450;
import org.junit.Assert;
import org.junit.Test;

public class Question450Test {
    private final Question450 classUnderTest = new Question450();

    @Test
    public void testExample1() {
        TreeNode root = TreeNode.create("[5,3,6,2,4,null,7]");
        int key = 3;
        TreeNode expected = TreeNode.create("[5,4,6,2,null,null,7]");
        TreeNode actual = classUnderTest.deleteNode(root, key);
        Assert.assertEquals(expected, actual);
        //    Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
        //    One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
        //    Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
    }

    @Test
    public void testExample2() {
        TreeNode root = TreeNode.create("[5,3,6,2,4,null,7]");
        int key = 0;
        TreeNode expected = TreeNode.create("[5,3,6,2,4,null,7]");
        Assert.assertEquals(expected, classUnderTest.deleteNode(root, key));
        //    Explanation: The tree does not contain a node with value = 0.
    }

    @Test
    public void testExample3() {
        TreeNode root = TreeNode.create("[]");
        int key = 0;
        TreeNode expected = TreeNode.create("[]");
        Assert.assertEquals(expected, classUnderTest.deleteNode(root, key));
    }
}
