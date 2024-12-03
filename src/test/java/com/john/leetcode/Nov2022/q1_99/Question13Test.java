package com.john.leetcode.Nov2022.q1_99;

import com.john.leetcode.Nov2022.q1_99.Question13;
import org.junit.Assert;
import org.junit.Test;

public class Question13Test {

    Question13 classUnderTest = new Question13();

    @Test
    public void testExample1() {
        String input = "III";
        int expected = 3;
        //    Explanation: III = 3.

        Assert.assertEquals(expected, classUnderTest.romanToInt(input));
    }

    @Test
    public void testExample2() {
        String input = "LVIII";
        int expected = 58;
        //    Explanation: L = 50, V= 5, III = 3.

        Assert.assertEquals(expected, classUnderTest.romanToInt(input));
    }

    @Test
    public void testExample3() {
        String input = "MCMXCIV";
        int expected = 1994;
        //    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

        Assert.assertEquals(expected, classUnderTest.romanToInt(input));
    }

    @Test
    public void testExample4() {
        String input = "";
        int expected = 0;

        Assert.assertEquals(expected, classUnderTest.romanToInt(input));
    }
}