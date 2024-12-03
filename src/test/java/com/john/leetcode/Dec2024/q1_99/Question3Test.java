package com.john.leetcode.Dec2024.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question3Test {

    private Question3 question3 = new Question3();

    @Test
    public void testExample1() {
        String input = "abcabcbb";
        int expected = 3;

        Assert.assertEquals(expected, question3.lengthOfLongestSubstring(input));
    }

    @Test
    public void testExample2() {
        String input = "bbbbb";
        int expected = 1;

        Assert.assertEquals(expected, question3.lengthOfLongestSubstring(input));
    }

    @Test
    public void testExample3() {
        String input = "pwwkew";
        int expected = 3;

        Assert.assertEquals(expected, question3.lengthOfLongestSubstring(input));
    }

    @Test
    public void testExample4() {
        String input = "abba";
        int expected = 2;

        Assert.assertEquals(expected, question3.lengthOfLongestSubstring(input));
    }
}