package com.john.randominterviews;

import org.junit.Assert;
import org.junit.Test;

public class TrinaryTreeTest {
	@Test
	public void testInsertAllUnique() {
		TrinaryTree tree = new TrinaryTree();

		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(7);

		Assert.assertEquals("3,5,7,15,", tree.toString());
	}

	@Test
	public void testInsertMid() {
		TrinaryTree tree = new TrinaryTree();

		tree.insert(5);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);

		Assert.assertEquals("3,5,5,7,", tree.toString());
	}

	@Test
	public void testDeleteMid() {
		TrinaryTree tree = new TrinaryTree();

		tree.insert(1);
		tree.insert(3);
		tree.insert(3);
		tree.insert(4);
		Assert.assertEquals("1,3,3,4,", tree.toString());

		tree.delete(3);

		Assert.assertEquals("1,3,4,", tree.toString());
	}

	@Test
	public void testDeleteLeaf() {
		TrinaryTree tree = new TrinaryTree();

		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		Assert.assertEquals("1,2,3,4,", tree.toString());

		tree.delete(4);

		Assert.assertEquals("1,2,3,", tree.toString());
	}

	@Test
	public void testDeleteOneChild() {
		TrinaryTree tree = new TrinaryTree();

		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		Assert.assertEquals("1,2,3,4,", tree.toString());

		tree.delete(3);

		Assert.assertEquals("1,2,4,", tree.toString());
	}

	@Test
	public void testDeleteTwoChildren() {
		TrinaryTree tree = new TrinaryTree();

		tree.insert(10);
		tree.insert(5);
		tree.insert(1);
		tree.insert(7);
		Assert.assertEquals("1,5,7,10,", tree.toString());

		tree.delete(5);

		Assert.assertEquals("1,7,10,", tree.toString());
	}

	@Test
	public void testDeleteRootNoChild() {
		TrinaryTree tree = new TrinaryTree();

		tree.insert(10);
		Assert.assertEquals("10,", tree.toString());

		tree.delete(10);

		Assert.assertEquals("", tree.toString());
	}

	@Test
	public void testDeleteRootOneChild() {
		TrinaryTree tree = new TrinaryTree();

		tree.insert(10);
		tree.insert(5);
		Assert.assertEquals("5,10,", tree.toString());

		tree.delete(10);

		Assert.assertEquals("5,", tree.toString());
	}

	@Test
	public void testDeleteRootTwoChildren() {
		TrinaryTree tree = new TrinaryTree();

		tree.insert(10);
		tree.insert(5);
		tree.insert(1);
		tree.insert(7);
		Assert.assertEquals("1,5,7,10,", tree.toString());

		tree.delete(10);

		Assert.assertEquals("1,5,7,", tree.toString());
	}

	@Test
	public void testDeleteNonExistent() {
		TrinaryTree tree = new TrinaryTree();

		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		Assert.assertEquals("1,2,3,4,", tree.toString());

		tree.delete(500);

		Assert.assertEquals("1,2,3,4,", tree.toString());
	}

}
