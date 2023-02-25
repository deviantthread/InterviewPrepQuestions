package com.john.Nov2022.leetcode.q1_50;

import static org.junit.Assert.*;

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