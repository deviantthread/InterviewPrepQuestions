package com.john.Nov2022.leetcode.q300_399;

import com.john.leetcode.inputhelp.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question338Test {
    private final Question338 classUnderTest = new Question338();

    @Test
    public void testExample1() {
        int n = 2;
        int[] expected = CollectionCreator.createArrayInt("[0,1,1]");
        Assert.assertArrayEquals(expected, classUnderTest.countBits(n));
        //    Explanation:
        //        0 --> 0
        //        1 --> 1
        //        2 --> 10
    }

    @Test
    public void testExample2() {
        int n = 5;
        int[] expected = CollectionCreator.createArrayInt("[0,1,1,2,1,2]");
        int[] actuals = classUnderTest.countBits(n);
        Assert.assertArrayEquals(expected, actuals);
        //    Explanation:
        //        0 --> 0
        //        1 --> 1
        //        2 --> 10
        //        3 --> 11
        //        4 --> 100
        //        5 --> 101
    }
}
