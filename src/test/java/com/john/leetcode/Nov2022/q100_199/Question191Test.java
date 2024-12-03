package com.john.leetcode.Nov2022.q100_199;

import org.junit.Assert;
import org.junit.Test;

public class Question191Test {
    private Question191 classUnderTest = new Question191();

    @Test
    public void testExample1() {
        int n = Integer.parseInt("00000000000000000000000000001011", 2);
        int expected = 3;
        //    Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
        Assert.assertEquals(expected, classUnderTest.hammingWeight(n));
    }

    @Test
    public void testExample2() {
        int n = Integer.parseInt("00000000000000000000000010000000", 2);
        int expected = 1;
        //    Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
        Assert.assertEquals(expected, classUnderTest.hammingWeight(n));
    }

    @Test
    public void testExample3() {
        int n = -3; //Integer.parseInt("11111111111111111111111111111101", 2);
        int expected = 31;
        //    Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
        Assert.assertEquals(expected, classUnderTest.hammingWeight(n));
    }
}
