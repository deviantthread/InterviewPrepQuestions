package com.john.leetcode.Nov2022.q1_99;

import com.john.leetcode.Nov2022.q1_99.Question5;
import org.junit.Assert;
import org.junit.Test;

public class Question5Test {

    private final Question5 classUnderTest = new Question5();

    @Test
    public void testExample1() {
        String input = "babad";
        String expected = "aba";
        //        Explanation: "bab" is also a valid answer.

        Assert.assertEquals(expected, classUnderTest.longestPalindrome(input));
    }

    @Test
    public void testExample2() {
        String input = "cbbd";
        String expected = "bb";

        Assert.assertEquals(expected, classUnderTest.longestPalindrome(input));
    }
}