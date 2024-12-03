package com.john.leetcode.Nov2022.q100_199;

import org.junit.Assert;
import org.junit.Test;

public class Question165Test {
    private Question165 classUnderTest = new Question165();

    @Test
    public void testExample1() {
        String version1 = "1.01";
        String version2 = "1.001";
        int expected = 0;
        //    Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".

        Assert.assertEquals(expected, classUnderTest.compareVersion(version1, version2));
    }

    @Test
    public void testExample2() {
        String version1 = "1.0";
        String version2 = "1.0.0";
        int expected = 0;
        //    Explanation: version1 does not specify revision 2, which means it is treated as "0".

        Assert.assertEquals(expected, classUnderTest.compareVersion(version1, version2));
    }

    @Test
    public void testExample3() {
        String version1 = "0.1";
        String version2 = "1.1";
        int expected = -1;
        //    Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.

        Assert.assertEquals(expected, classUnderTest.compareVersion(version1, version2));
    }
}
