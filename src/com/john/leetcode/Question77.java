package com.john.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question77 {

	public static void main(String[] args) {
		List<List<Integer>> combine = new Question77().combine(2, 2);

		for (List<Integer> list : combine) {
			CollUtils.print(list);
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		combine(n, k, 1, ret, curr);
		return ret;
	}

	private void combine(int n, int k, Integer i, List<List<Integer>> ret, List<Integer> curr) {
		if (curr.size() == k) {
			List<Integer> copy = copy(curr);
			ret.add(copy);
			return;
		}

		for (; i <= n; i++) {
			curr.add(i);
			combine(n, k, i + 1, ret, curr);
			curr.remove(i);
		}
	}

	private List<Integer> copy(List<Integer> curr) {
		List<Integer> copy = new ArrayList<Integer>(curr.size());
		for (int i : curr) {
			copy.add(i);
		}
		return copy;
	}

}
