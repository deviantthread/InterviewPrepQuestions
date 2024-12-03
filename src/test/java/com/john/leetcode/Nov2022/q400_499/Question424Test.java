package com.john.leetcode.Nov2022.q400_499;

import org.junit.Assert;
import org.junit.Test;

public class Question424Test {
    private final Question424 classUnderTest = new Question424();

    @Test
    public void testExample1() {
        String s = "ABAB";
        int k = 2;
        int expected = 4;
        //    Explanation: Replace the two 'A's with two 'B's or vice versa.
        Assert.assertEquals(expected, classUnderTest.characterReplacement(s, k));
    }

    @Test
    public void testExample2() {
        String s = "AABABBA";
        int k = 1;
        int expected = 4;
        //    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
        //    The substring "BBBB" has the longest repeating letters, which is 4.
        Assert.assertEquals(expected, classUnderTest.characterReplacement(s, k));
    }
}
