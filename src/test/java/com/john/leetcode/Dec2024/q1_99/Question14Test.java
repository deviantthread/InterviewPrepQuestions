package com.john.leetcode.Dec2024.q1_99;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question14Test {
    private Question14 classUnderTest = new Question14();

    @Test
    public void Example1() {
        String[] strs = new String[] { "flower", "flow", "flight" };
        String expected = "fl";
        Assert.assertEquals(expected, classUnderTest.longestCommonPrefix(strs));
    }

    @Test
    public void Example2() {
        String[] strs = new String[] { "dog", "racecar", "car" };
        String expected = "";
        Assert.assertEquals(expected, classUnderTest.longestCommonPrefix(strs));
    }

    @Test
    public void Example3() {
        String[] strs = new String[] { "", "b" };
        String expected = "";
        Assert.assertEquals(expected, classUnderTest.longestCommonPrefix(strs));
    }

    @Test
    public void Example4() {
        String[] strs = new String[] { "" };
        String expected = "";
        Assert.assertEquals(expected, classUnderTest.longestCommonPrefix(strs));
    }
}
