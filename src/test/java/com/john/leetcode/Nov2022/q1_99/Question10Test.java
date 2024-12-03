package com.john.leetcode.Nov2022.q1_99;

import com.john.leetcode.Nov2022.q1_99.Question10;
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
}