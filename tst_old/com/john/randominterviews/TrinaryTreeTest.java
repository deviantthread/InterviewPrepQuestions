package com.john.randominterviews;

// test file

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.john.randominterviews.TrinaryTree.Node;

//To run the unit tests add junit and hamcrest jars to your build path
//http://search.maven.org/remotecontent?filepath=junit/junit/4.12/junit-4.12.jar
//https://hamcrest.googlecode.com/files/hamcrest-all-1.3.jar
public class TrinaryTreeTest {

    private TrinaryTree classUnderTest = null;

    @Before
    public void setup() {
        // reset to a fresh tree before each test
        classUnderTest = new TrinaryTree();
    }

    @After
    public void isValidTrinaryTree() {
        // verify at the end of every test, the tree is in a valid state
        Assert.assertTrue(isValidTrinaryTree(classUnderTest.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testInsertAllUnique() {
        classUnderTest.insert(5);
        classUnderTest.insert(15);
        classUnderTest.insert(3);
        classUnderTest.insert(7);

        Assert.assertEquals("3,5,7,15,", convertTreeToString());
    }

    @Test
    public void testInsertMid() {
        classUnderTest.insert(5);
        classUnderTest.insert(3);
        classUnderTest.insert(7);
        classUnderTest.insert(5);

        Assert.assertEquals("3,5,5,7,", convertTreeToString());
    }

    @Test
    public void testDeleteMid() {
        classUnderTest.insert(1);
        classUnderTest.insert(3);
        classUnderTest.insert(3);
        classUnderTest.insert(4);
        Assert.assertEquals("1,3,3,4,", convertTreeToString());

        classUnderTest.delete(3);

        Assert.assertEquals("1,3,4,", convertTreeToString());
    }

    @Test
    public void testDeleteLeaf() {
        classUnderTest.insert(1);
        classUnderTest.insert(2);
        classUnderTest.insert(3);
        classUnderTest.insert(4);
        Assert.assertEquals("1,2,3,4,", convertTreeToString());

        classUnderTest.delete(4);

        Assert.assertEquals("1,2,3,", convertTreeToString());
    }

    @Test
    public void testDeleteOneChild() {
        classUnderTest.insert(1);
        classUnderTest.insert(2);
        classUnderTest.insert(3);
        classUnderTest.insert(4);
        Assert.assertEquals("1,2,3,4,", convertTreeToString());

        classUnderTest.delete(3);

        Assert.assertEquals("1,2,4,", convertTreeToString());
    }

    @Test
    public void testDeleteTwoChildren() {
        classUnderTest.insert(10);
        classUnderTest.insert(5);
        classUnderTest.insert(7);
        classUnderTest.insert(7);
        classUnderTest.insert(1);
        classUnderTest.insert(7);
        Assert.assertEquals("1,5,7,7,7,10,", convertTreeToString());

        classUnderTest.delete(5);

        Assert.assertEquals("1,7,7,7,10,", convertTreeToString());
    }

    @Test
    public void testDeleteTwoChildrenBigRightTree() {
        classUnderTest.insert(100);
        classUnderTest.insert(50);
        classUnderTest.insert(70);
        classUnderTest.insert(10);
        // 10 < 50 < big tree < 70
        classUnderTest.insert(60);
        classUnderTest.insert(56);
        classUnderTest.insert(58);
        classUnderTest.insert(68);
        classUnderTest.insert(51);

        Assert.assertEquals("10,50,51,56,58,60,68,70,100,", convertTreeToString());

        classUnderTest.delete(50);

        Assert.assertEquals("10,51,56,58,60,68,70,100,", convertTreeToString());
    }

    @Test
    public void testDeleteRootNoChild() {
        classUnderTest.insert(10);
        Assert.assertEquals("10,", convertTreeToString());

        classUnderTest.delete(10);

        Assert.assertEquals("", convertTreeToString());
    }

    @Test
    public void testDeleteRootOneChild() {
        classUnderTest.insert(10);
        classUnderTest.insert(5);
        Assert.assertEquals("5,10,", convertTreeToString());

        classUnderTest.delete(10);

        Assert.assertEquals("5,", convertTreeToString());
    }

    @Test
    public void testDeleteRootTwoChildren() {
        classUnderTest.insert(10);
        classUnderTest.insert(5);
        classUnderTest.insert(1);
        classUnderTest.insert(7);
        Assert.assertEquals("1,5,7,10,", convertTreeToString());

        classUnderTest.delete(10);

        Assert.assertEquals("1,5,7,", convertTreeToString());
    }

    @Test
    public void testDeleteNonExistent() {
        classUnderTest.insert(1);
        classUnderTest.insert(2);
        classUnderTest.insert(3);
        classUnderTest.insert(4);
        Assert.assertEquals("1,2,3,4,", convertTreeToString());

        classUnderTest.delete(500);

        Assert.assertEquals("1,2,3,4,", convertTreeToString());
    }

    @Test
    public void testDeleteBeforeInsert() {
        Assert.assertEquals("", convertTreeToString());

        classUnderTest.delete(3);

        Assert.assertEquals("", convertTreeToString());
        classUnderTest.insert(5);
        Assert.assertEquals("5,", convertTreeToString());
    }

    private String convertTreeToString() {
        StringBuilder sb = new StringBuilder();
        treeToSB(classUnderTest.getRoot(), sb);

        return sb.toString();
    }

    private void treeToSB(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        treeToSB(node.left, sb);

        sb.append(node.val).append(",");
        Node midNode = node.mid;
        while (midNode != null) {
            sb.append(midNode.val).append(",");
            midNode = midNode.mid;
        }

        treeToSB(node.right, sb);
    }

    private boolean isValidTrinaryTree(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.val > max || node.val < min) {
            return false;
        }

        if (!areAllMidsValid(node)) {
            return false;
        }

        return isValidTrinaryTree(node.left, min, node.val)
                && isValidTrinaryTree(node.right, node.val, max);
    }

    private boolean areAllMidsValid(Node node) {
        int val = node.val;
        Node mid = node.mid;

        while (mid != null) {
            if (mid.val != val || mid.left != null || mid.right != null) {
                return false;
            }
            mid = mid.mid;
        }

        return true;
    }

}
