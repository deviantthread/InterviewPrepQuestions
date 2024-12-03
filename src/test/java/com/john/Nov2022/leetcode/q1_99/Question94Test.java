package com.john.Nov2022.leetcode.q1_99;

import com.john.datastructures.ListUtils;
import com.john.datastructures.TreeNode;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question94Test {
    private Question94 classUnderTest = new Question94();

    @Test
    public void testExample1() {

        TreeNode root = TreeNode.create("[1,null,2,3]");
        List<Integer> expected = ListUtils.create("[1,3,2]");

        ListAssert.assertListEquals(expected, classUnderTest.inorderTraversal(root));
    }

    @Test
    public void testExample2() {

        TreeNode root = TreeNode.create("[]");
        List<Integer> expected = ListUtils.create("[]");

        ListAssert.assertListEquals(expected, classUnderTest.inorderTraversal(root));
    }

    @Test
    public void testExample3() {

        TreeNode root = TreeNode.create("[1]");
        List<Integer> expected = ListUtils.create("[1]");

        ListAssert.assertListEquals(expected, classUnderTest.inorderTraversal(root));
    }
}