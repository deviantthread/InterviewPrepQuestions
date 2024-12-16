package com.john.leetcode.Dec2024.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question10Test {
    private final Question10 classUnderTest = new Question10();

    @Test
    public void testExample1() {
        String s = "aa";
        String p = "a";
        boolean expected = false;
        //        Explanation: "a" does not match the entire string "aa".

        Assert.assertEquals(expected, classUnderTest.isMatch(s, p));
    }

    @Test
    public void testExample2() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        //        Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

        Assert.assertEquals(expected, classUnderTest.isMatch(s, p));
    }

    @Test
    public void testExample3() {
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        //        Explanation: ".*" means "zero or more (*) of any character (.)".

        Assert.assertEquals(expected, classUnderTest.isMatch(s, p));
    }

    @Test
    public void testExample4() {
        String s = "aab";
        String p = "c*a*b";
        boolean expected = true;

        Assert.assertEquals(expected, classUnderTest.isMatch(s, p));
    }

    @Test
    public void testExample5() {
        String s = "aaa";
        String p = "ab*a*c*a";
        boolean expected = true;

        Assert.assertEquals(expected, classUnderTest.isMatch(s, p));
    }

    @Test
    public void testExample6() {
        String s = "aaca";
        String p = "ab*a*c*a";
        boolean expected = true;

        Assert.assertEquals(expected, classUnderTest.isMatch(s, p));
    }

    @Test
    public void testExample7() {
        String s = "a";
        String p = "ab*";
        boolean expected = true;

        Assert.assertEquals(expected, classUnderTest.isMatch(s, p));
    }

    @Test(timeout = 1_000)
    public void testExample8() {
        String s = "aaaaaaaaaaaaaaaaaaab";
        String p = "a*a*a*a*a*a*a*a*a*a*";
        boolean expected = false;

        Assert.assertEquals(expected, classUnderTest.isMatch(s, p));
    }
}