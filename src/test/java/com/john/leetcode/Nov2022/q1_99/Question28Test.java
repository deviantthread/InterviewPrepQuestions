package com.john.leetcode.Nov2022.q1_99;

import com.john.leetcode.Nov2022.q1_99.Question28;
import org.junit.Assert;
import org.junit.Test;

public class Question28Test {
    private Question28 classUnderTest = new Question28();

    @Test
    public void testExample1() {
        String haystack = "sadbutsad";
        String needle = "sad";
        int expected = 0;
        //    Explanation: "sad" occurs at index 0 and 6.
        //    The first occurrence is at index 0, so we return 0.
        Assert.assertEquals(expected, classUnderTest.strStr(haystack, needle));
    }

    @Test
    public void testExample2() {
        String haystack = "leetcode";
        String needle = "leeto";
        int expected = -1;
        //    Explanation: "leeto" did not occur in "leetcode", so we return -1.
        Assert.assertEquals(expected, classUnderTest.strStr(haystack, needle));
    }
}
