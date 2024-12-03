package com.john.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question113 {

	public static void main(String[] args) {
		OldTreeNode root = new OldTreeNode(1);
		CollUtils.print(new Question113().pathSum(root, 1));
	}

	public List<List<Integer>> pathSum(OldTreeNode root, int sum) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		hasPathSum(root, sum, 0, ret, path);
		return ret;

	}

	private void hasPathSum(OldTreeNode root, int sum, int currSum, List<List<Integer>> ret, List<Integer> currPath) {
		currPath.add(root.val);
		if (root.left == null && root.right == null) {
			if (sum == (root.val + currSum)) {
				List<Integer> copy = new ArrayList<Integer>(currPath.size());
				for (Integer i : currPath) {
					copy.add(i);
				}
				ret.add(copy);
			}
		}

		if (root.left != null) {
			hasPathSum(root.left, sum, currSum + root.val, ret, currPath);
		}

		if (root.right != null) {
			hasPathSum(root.right, sum, currSum + root.val, ret, currPath);
		}
		currPath.remove(currPath.size() - 1);
	}
}
