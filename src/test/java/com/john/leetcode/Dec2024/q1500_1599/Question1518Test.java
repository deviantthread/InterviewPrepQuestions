package com.john.leetcode.Dec2024.q1500_1599;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question1518Test {
    private final Question1518 classUnderTest = new Question1518();

    @Test
    public void testExample1() {

        int numBottles = 9;
        int numExchange = 3;
        int expected = 13;
        //    Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
        //    Number of water bottles you can drink: 9 + 3 + 1 = 13.

        Assert.assertEquals(expected, classUnderTest.numWaterBottles(numBottles, numExchange));
    }

    @Test
    public void testExample2() {

        int numBottles = 15;
        int numExchange = 4;
        int expected = 19;
        //    Explanation: You can exchange 4 empty bottles to get 1 full water bottle.
        //    Number of water bottles you can drink: 15 + 3 + 1 = 19.

        Assert.assertEquals(expected, classUnderTest.numWaterBottles(numBottles, numExchange));
    }
}
