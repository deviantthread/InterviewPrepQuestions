package com.john.Nov2022.leetcode.q1_50;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question7Test {
    private final Question7 classUnderTest = new Question7();

    @Test
    public void testExample1() {
        int input = 123;
        int expected = 321;

        assertEquals(expected, classUnderTest.reverse(input));
    }

    @Test
    public void testExample2() {
        int input = -123;
        int expected = -321;

        assertEquals(expected, classUnderTest.reverse(input));
    }

    @Test
    public void testExample3() {
        int input = 120;
        int expected = 21;

        assertEquals(expected, classUnderTest.reverse(input));
    }
}