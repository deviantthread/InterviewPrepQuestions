package com.john.Nov2022.leetcode.q1_99;

import com.google.common.collect.Lists;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question22Test {
    private Question22 classUnderTest = new Question22();

    @Test
    public void testExample1() {
        int n = 3;
        List<String> expected = Lists.newArrayList("((()))", "(()())", "(())()", "()(())", "()()()");
        expected.sort(String::compareTo);
        List<String> actual = classUnderTest.generateParenthesis(n);
        actual.sort(String::compareTo);
        ListAssert.assertListEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int n = 1;
        List<String> expected = Lists.newArrayList("()");
        ListAssert.assertListEquals(expected, classUnderTest.generateParenthesis(n));
    }
}
