package com.john.leetcode.Dec2024.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question12Test {
    private Question12 classUnderTest = new Question12();

    @Test
    public void testExample1() {
        int num = 3;
        String expected = "III";
        //    Explanation: 3 is represented as 3 ones.
        Assert.assertEquals(expected, classUnderTest.intToRoman(num));
    }

    @Test
    public void testExample2() {
        int num = 58;
        String expected = "LVIII";
        //    Explanation: L = 50, V = 5, III = 3.
        Assert.assertEquals(expected, classUnderTest.intToRoman(num));
    }

    @Test
    public void testExample3() {
        int num = 1994;
        String expected = "MCMXCIV";
        //    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
        Assert.assertEquals(expected, classUnderTest.intToRoman(num));
    }
}
