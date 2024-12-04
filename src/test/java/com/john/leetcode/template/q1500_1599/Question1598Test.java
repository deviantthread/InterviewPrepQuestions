package com.john.leetcode.template.q1500_1599;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question1598Test {
    private final Question1598 classUnderTest = new Question1598();

    @Test
    public void testExample1() {
        String[] logs = new String[] { "d1/", "d2/", "../", "d21/", "./" };
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.minOperations(logs));
        //    Explanation: Use this change folder operation "../" 2 times and go back to the main folder.
    }

    @Test
    public void testExample2() {
        String[] logs = new String[] { "d1/", "d2/", "./", "d3/", "../", "d31/" };
        int expected = 3;
        Assert.assertEquals(expected, classUnderTest.minOperations(logs));
    }

    @Test
    public void testExample3() {
        String[] logs = new String[] { "d1/", "../", "../", "../" };
        int expected = 0;
        Assert.assertEquals(expected, classUnderTest.minOperations(logs));
    }
}
