package com.john.Nov2022.leetcode.q51_100;

import com.john.leetcode.inputhelp.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question79Test {
    private Question79 classUnderTest = new Question79();

    @Test
    public void testExample1() {
        char[][] board = CollectionCreator.create2DArrayChar("[[A,B,C,E],[S,F,C,S],[A,D,E,E]]");
        String word = "ABCCED";
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.exist(board, word));
    }

    @Test
    public void testExample2() {
        char[][] board = CollectionCreator.create2DArrayChar("[[A,B,C,E],[S,F,C,S],[A,D,E,E]]");
        String word = "SEE";
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.exist(board, word));
    }

    @Test
    public void testExample3() {
        char[][] board = CollectionCreator.create2DArrayChar("[[A,B,C,E],[S,F,C,S],[A,D,E,E]]");
        String word = "ABCB";
        boolean expected = false;
        Assert.assertEquals(expected, classUnderTest.exist(board, word));
    }
}
