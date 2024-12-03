package com.john.leetcode.Nov2022.q1_99;

import com.john.leetcode.Nov2022.q1_99.Question20;
import org.junit.Assert;
import org.junit.Test;

public class Question20Test {

    private Question20 classUnderTest = new Question20();

    @Test
    public void testExample1() {

        String input = "()";
        boolean expected = true;

        Assert.assertEquals(expected, classUnderTest.isValid(input));
    }

    @Test
    public void testExample2() {

        String input = "()[]{}";
        boolean expected = true;

        Assert.assertEquals(expected, classUnderTest.isValid(input));
    }

    @Test
    public void testExample3() {

        String input = "(]";
        boolean expected = false;

        Assert.assertEquals(expected, classUnderTest.isValid(input));
    }
}