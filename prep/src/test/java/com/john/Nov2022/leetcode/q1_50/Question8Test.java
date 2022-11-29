package com.john.Nov2022.leetcode.q1_50;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Question8Test {
    private final Question8 classUnderTest = new Question8();

    @Test
    public void testExample1() {
        //        Explanation: The underlined characters are what is read in, the caret is the current reader position.
        //        Step 1: "42" (no characters read because there is no leading whitespace)
        //         ^
        //        Step 2: "42" (no characters read because there is neither a '-' nor '+')
        //         ^
        //        Step 3: "42" ("42" is read in)
        //           ^
        //        The parsed integer is 42.
        //        Since 42 is in the range [-231, 231 - 1], the final result is 42.
        String input = "42";
        int expected = 42;

        Assert.assertEquals(expected, classUnderTest.myAtoi(input));
    }

    @Test
    public void testExample2() {
        //        Explanation:
        //        Step 1: "   -42" (leading whitespace is read and ignored)
        //            ^
        //        Step 2: "   -42" ('-' is read, so the result should be negative)
        //             ^
        //        Step 3: "   -42" ("42" is read in)
        //               ^
        //        The parsed integer is -42.
        //        Since -42 is in the range [-231, 231 - 1], the final result is -42.
        String input = "   -42";
        int expected = -42;

        Assert.assertEquals(expected, classUnderTest.myAtoi(input));
    }

    @Test
    public void testExample3() {
        //        Explanation:
        //        Step 1: "4193 with words" (no characters read because there is no leading whitespace)
        //         ^
        //        Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
        //         ^
        //        Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
        //             ^
        //        The parsed integer is 4193.
        //        Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
        String input = "4193 with words";
        int expected = 4193;

        Assert.assertEquals(expected, classUnderTest.myAtoi(input));
    }

    @Test
    public void testExample4() {
        String input = "-91283472332";
        int expected = Integer.MIN_VALUE;

        Assert.assertEquals(expected, classUnderTest.myAtoi(input));
    }

    @Test
    public void testExample5() {
        String input = "words and 987";
        int expected = 0;

        Assert.assertEquals(expected, classUnderTest.myAtoi(input));
    }
}