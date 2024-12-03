package com.john.leetcode.Dec2024.q100_199;

import org.junit.Assert;
import org.junit.Test;

public class Question125Test {
    private Question125 classUnderTest = new Question125();

    @Test
    public void testExample1() {
        String s = "A man, a plan, a canal: Panama";
        boolean expected = true;
        //    Explanation: "amanaplanacanalpanama" is a palindrome.
        Assert.assertEquals(expected, classUnderTest.isPalindrome(s));
    }

    @Test
    public void testExample2() {
        String s = "race a car";
        boolean expected = false;
        //    Explanation: "raceacar" is not a palindrome.
        Assert.assertEquals(expected, classUnderTest.isPalindrome(s));
    }

    @Test
    public void testExample3() {
        String s = " ";
        boolean expected = true;
        //    Explanation: s is an empty string "" after removing non-alphanumeric characters.
        Assert.assertEquals(expected, classUnderTest.isPalindrome(s));
        //    Since an empty string reads the same forward and backward, it is a palindrome.
    }

    @Test
    public void testExample4() {
        String s = "race car";
        boolean expected = true;
        //    Explanation: "racecar" is a palindrome.
        Assert.assertEquals(expected, classUnderTest.isPalindrome(s));
    }
}
