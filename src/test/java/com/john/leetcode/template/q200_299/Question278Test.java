package com.john.leetcode.template.q200_299;

import org.junit.Assert;
import org.junit.Test;

public class Question278Test {

    @Test
    public void testExample1() {
        int n = 5;
        int bad = 4;
        int expected = bad;
        Assert.assertEquals(expected, new Question278(bad).firstBadVersion(n));
        //    Explanation:
        //    call isBadVersion(3) -> false
        //    call isBadVersion(5) -> true
        //    call isBadVersion(4) -> true
        //    Then 4 is the first bad version.
    }

    @Test
    public void testExample2() {
        int n = 1;
        int bad = 1;
        int expected = bad;
        Assert.assertEquals(expected, new Question278(bad).firstBadVersion(n));
    }

    @Test
    public void testExample3() {
        int n = 3;
        int bad = 2;
        int expected = bad;
        Assert.assertEquals(expected, new Question278(bad).firstBadVersion(n));
    }
}
