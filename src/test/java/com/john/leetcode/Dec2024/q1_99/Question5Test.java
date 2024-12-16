package com.john.leetcode.Dec2024.q1_99;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;

public class Question5Test {

    private final Question5 classUnderTest = new Question5();

    @Test
    public void testExample1() {
        String input = "babad";

        assertThat(classUnderTest.longestPalindrome(input), anyOf(is("aba"), is("bab")));
    }

    @Test
    public void testExample2() {
        String input = "cbbd";
        String expected = "bb";

        Assert.assertEquals(expected, classUnderTest.longestPalindrome(input));
    }
}