package com.john.leetcode.Dec2024.q100_199;

import org.junit.Assert;
import org.junit.Test;

public class Question168Test {
    private Question168 classUnderTest = new Question168();

    @Test
    public void testExample1() {
        int columnNumber = 1;
        String expected = "A";
        Assert.assertEquals(expected, classUnderTest.convertToTitle(columnNumber));
    }

    @Test
    public void testExample2() {
        int columnNumber = 28;
        String expected = "AB";
        Assert.assertEquals(expected, classUnderTest.convertToTitle(columnNumber));
    }

    @Test
    public void testExample3() {
        int columnNumber = 701;
        String expected = "ZY";
        Assert.assertEquals(expected, classUnderTest.convertToTitle(columnNumber));
    }
}
