package com.john.leetcode.Nov2022.q100_199;

import com.john.datastructures.TreeNode;
import com.john.utils.CollectionCreator;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question199Test {
    private Question199 classUnderTest = new Question199();

    @Test
    public void testExample1() {
        TreeNode root = TreeNode.create("[1,2,3,null,5,null,4]");
        List<Integer> expected = CollectionCreator.createListInt("[1,3,4]");
        ListAssert.assertListEquals(expected, classUnderTest.rightSideView(root));
    }

    @Test
    public void testExample2() {
        TreeNode root = TreeNode.create("[1,null,3]");
        List<Integer> expected = CollectionCreator.createListInt("[1,3]");
        ListAssert.assertListEquals(expected, classUnderTest.rightSideView(root));
    }

    @Test
    public void testExample3() {
        TreeNode root = TreeNode.create("[]");
        List<Integer> expected = CollectionCreator.createListInt("[]");
        ListAssert.assertListEquals(expected, classUnderTest.rightSideView(root));
    }
}
