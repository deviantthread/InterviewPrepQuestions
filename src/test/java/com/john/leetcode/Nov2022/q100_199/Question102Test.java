package com.john.leetcode.Nov2022.q100_199;

import com.john.datastructures.TreeNode;
import com.john.utils.CollectionCreator;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question102Test {
    private Question102 classUnderTest = new Question102();

    @Test
    public void testExample1() {
        TreeNode root = TreeNode.create("[3,9,20,null,null,15,7]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[3],[9,20],[15,7]]");
        ListAssert.assertListEquals(expected, classUnderTest.levelOrder(root));
    }

    @Test
    public void testExample2() {
        TreeNode root = TreeNode.create("[1]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[1]]");
        ListAssert.assertListEquals(expected, classUnderTest.levelOrder(root));
    }

    @Test
    public void testExample3() {
        TreeNode root = TreeNode.create("[]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[]");
        ListAssert.assertListEquals(expected, classUnderTest.levelOrder(root));
    }
}
