package com.john.Nov2022.leetcode.q1_50;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Question6Test {
    private final Question6 classUnderTest = new Question6();

    @Test
    public void testExample1() {
        String input = "PAYPALISHIRING";
        int numRows = 3;
        String output = "PAHNAPLSIIGYIR";

        Assert.assertEquals(output, classUnderTest.convert(input, numRows));
    }

    @Test
    public void testExample2() {
        String input = "PAYPALISHIRING";
        int numRows = 4;
        String output = "PINALSIGYAHRPI";
        //        Explanation:
        //        P     I    N
        //        A   L S  I G
        //        Y A   H R
        //        P     I
        Assert.assertEquals(output, classUnderTest.convert(input, numRows));
    }

    @Test
    public void testExample3() {
        String input = "A";
        int numRows = 1;
        String output = "A";

        Assert.assertEquals(output, classUnderTest.convert(input, numRows));
    }
}