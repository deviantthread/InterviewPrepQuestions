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
		// reset to a fresh tree for each test
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

	// write 'is still binary tree principle held' method and add it in an
	// @After method

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
		treeToSB(node.getLeft(), sb);

		sb.append(node.getVal()).append(",");
		Node midNode = node.getMid();
		while (midNode != null) {
			sb.append(midNode.getVal()).append(",");
			midNode = midNode.getMid();
		}

		treeToSB(node.getRight(), sb);
	}

	private boolean isValidTrinaryTree(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.getVal() > max || node.getVal() < min) {
			return false;
		}

		if (!areAllMidsValid(node)) {
			return false;
		}

		return isValidTrinaryTree(node.getLeft(), min, node.getVal())
				&& isValidTrinaryTree(node.getRight(), node.getVal(), max);
	}

	private boolean areAllMidsValid(Node node) {
		int val = node.getVal();
		Node mid = node.getMid();

		while (mid != null) {
			if (mid.getVal() != val || mid.getLeft() != null || mid.getRight() != null) {
				return false;
			}
			mid = mid.getMid();
		}

		return true;
	}

}
