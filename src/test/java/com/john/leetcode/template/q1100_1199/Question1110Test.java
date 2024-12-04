package com.john.leetcode.template.q1100_1199;

import com.john.datastructures.TreeNode;
import com.john.utils.CollectionCreator;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question1110Test {
    private final Question1110 classUnderTest = new Question1110();

    @Test
    public void testExample1() {
        TreeNode root = TreeNode.create("[1,2,3,4,5,6,7]");
        int[] to_delete = CollectionCreator.createArrayInt("[3,5]");
        List<TreeNode> expected = List.of(TreeNode.create("[1,2,null,4]"), TreeNode.create("[6]"), TreeNode.create("[7]"));
        ListAssert.assertListEquals(expected, classUnderTest.delNodes(root, to_delete));
    }

    @Test
    public void testExample2() {
        TreeNode root = TreeNode.create("[1,2,4,null,3]");
        int[] to_delete = CollectionCreator.createArrayInt("[3]");
        List<TreeNode> expected = List.of(TreeNode.create("[1,2,4]"));
        ListAssert.assertListEquals(expected, classUnderTest.delNodes(root, to_delete));
    }
}
