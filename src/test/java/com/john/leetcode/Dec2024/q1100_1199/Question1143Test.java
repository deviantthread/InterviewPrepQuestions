package com.john.leetcode.Dec2024.q1100_1199;

import org.junit.Assert;
import org.junit.Test;

public class Question1143Test {
    private final Question1143 classUnderTest = new Question1143();

    @Test
    public void testExample1() {
        String text1 = "abcde";
        String text2 = "ace";
        int expected = 3;
        Assert.assertEquals(expected, classUnderTest.longestCommonSubsequence(text1, text2));
        //    Explanation: The longest common subsequence is "ace" and its length is 3.
    }

    @Test
    public void testExample2() {
        String text1 = "abc";
        String text2 = "abc";
        int expected = 3;
        Assert.assertEquals(expected, classUnderTest.longestCommonSubsequence(text1, text2));
        //    Explanation: The longest common subsequence is "abc" and its length is 3.
    }

    @Test
    public void testExample3() {
        String text1 = "abc";
        String text2 = "def";
        int expected = 0;
        Assert.assertEquals(expected, classUnderTest.longestCommonSubsequence(text1, text2));
        //    Explanation: There is no such common subsequence, so the result is 0.
    }

    @Test
    public void testExample4() {
        String text1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            + "aaaaaaaaaaaaaaaaaaaaaa";
        String text2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int expected = 210;
        Assert.assertEquals(expected, classUnderTest.longestCommonSubsequence(text1, text2));
    }

    @Test
    public void testExample5() {
        String text1 = "yzebsbuxmtcfmtodclszgh";
        String text2 = "ejevmhcvshclydqrulwbyha";
        int expected = 6;
        Assert.assertEquals(expected, classUnderTest.longestCommonSubsequence(text1, text2));
    }
}
