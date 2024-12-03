package com.john.leetcode.template.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question9Test {
    private final Question9 classUnderTest = new Question9();

    @Test
    public void testExample1() {
        int input = 121;
        boolean expected = true;
        //        Explanation: 121 reads as 121 from left to right and from right to left.

        Assert.assertEquals(expected, classUnderTest.isPalindrome(input));
    }

    @Test
    public void testExample2() {
        int input = -121;
        boolean expected = false;
        //        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

        Assert.assertEquals(expected, classUnderTest.isPalindrome(input));
    }

    @Test
    public void testExample3() {
        int input = 10;
        boolean expected = false;
        //        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

        Assert.assertEquals(expected, classUnderTest.isPalindrome(input));
    }

    @Test
    public void testExample4() {
        int input = 0;
        boolean expected = true;

        Assert.assertEquals(expected, classUnderTest.isPalindrome(input));
    }
}