package com.john.leetcode.template.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question71Test {
    private Question71 classUnderTest = new Question71();

    @Test
    public void testExample1() {
        String path = "/home/";
        String expected = "/home";
        //    Explanation: Note that there is no trailing slash after the last directory name.
        Assert.assertEquals(expected, classUnderTest.simplifyPath(path));
    }

    @Test
    public void testExample2() {
        String path = "/../";
        String expected = "/";
        //    Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
        Assert.assertEquals(expected, classUnderTest.simplifyPath(path));
    }

    @Test
    public void testExample3() {
        String path = "/home//foo/";
        String expected = "/home/foo";
        //    Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
        Assert.assertEquals(expected, classUnderTest.simplifyPath(path));
    }

    @Test
    public void testExample4() {
        String path = "/a/./b/../../c/";
        String expected = "/c";
        //    Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
        Assert.assertEquals(expected, classUnderTest.simplifyPath(path));
    }
}
