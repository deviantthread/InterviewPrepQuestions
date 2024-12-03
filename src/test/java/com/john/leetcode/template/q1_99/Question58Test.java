package com.john.leetcode.template.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question58Test {
    private Question58 classUnderTest = new Question58();

    @Test
    public void testExample1() {

        String s = "Hello World";
        int expected = 5;
        //    Explanation: The last word is "World" with length 5.
        Assert.assertEquals(expected, classUnderTest.lengthOfLastWord(s));
    }

    @Test
    public void testExample2() {

        String s = "   fly me   to   the moon  ";
        int expected = 4;
        //    Explanation: The last word is "moon" with length 4.
        Assert.assertEquals(expected, classUnderTest.lengthOfLastWord(s));
    }

    @Test
    public void testExample3() {

        String s = "luffy is still joyboy";
        int expected = 6;
        //    Explanation: The last word is "joyboy" with length 6.
        Assert.assertEquals(expected, classUnderTest.lengthOfLastWord(s));
    }
}
