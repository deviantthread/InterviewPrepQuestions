package com.john.leetcode.template.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question32Test {
    private Question32 classUnderTest = new Question32();

    @Test
    public void testExample1() {
        String s = "(()";
        int expected = 2;
        //    Explanation: The longest valid parentheses substring is "()".
        Assert.assertEquals(expected, classUnderTest.longestValidParentheses(s));
    }

    @Test
    public void testExample2() {
        String s = ")()())";
        int expected = 4;
        //    Explanation: The longest valid parentheses substring is "()()".
        Assert.assertEquals(expected, classUnderTest.longestValidParentheses(s));
    }

    @Test
    public void testExample3() {
        String s = "";
        int expected = 0;
        Assert.assertEquals(expected, classUnderTest.longestValidParentheses(s));
    }
}
