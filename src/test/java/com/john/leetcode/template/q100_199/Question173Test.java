package com.john.leetcode.template.q100_199;

import com.john.datastructures.TreeNode;
import com.john.leetcode.template.q100_199.Question173.BSTIterator;
import org.junit.Assert;
import org.junit.Test;

public class Question173Test {
    private Question173 classUnderTest = new Question173();

    @Test
    public void testExample1() {
        //    Input
        //["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
        //    [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
        //    Output
        //[null, 3, 7, true, 9, true, 15, true, 20, false]

        //    Explanation
        BSTIterator bSTIterator = new BSTIterator(TreeNode.create("[7, 3, 15, null, null, 9, 20]"));
        Assert.assertEquals(3, bSTIterator.next());    // return 3
        Assert.assertEquals(7, bSTIterator.next());    // return 7
        Assert.assertTrue(bSTIterator.hasNext()); // return True
        Assert.assertEquals(9, bSTIterator.next());    // return 9
        Assert.assertTrue(bSTIterator.hasNext()); // return True
        Assert.assertEquals(15, bSTIterator.next());    // return 15
        Assert.assertTrue(bSTIterator.hasNext()); // return True
        Assert.assertEquals(20, bSTIterator.next());    // return 20
        Assert.assertFalse(bSTIterator.hasNext()); // return False
    }
}