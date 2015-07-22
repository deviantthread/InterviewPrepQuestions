package com.john.leetcode;

import java.util.LinkedList;

public class Question239 {

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		CollUtils.print(nums, "nums");
		int[] ret = new Question239().maxSlidingWindow(nums, k);
		CollUtils.print(ret, "ret");
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		LinkedList<IntPos> list = new LinkedList<IntPos>();
		int[] ret = new int[nums.length];
		int retIdx = 0;
		int i = 0;
		for (i = 0; i < k; i++) {
			int num = nums[i];
			if (list.isEmpty() || list.getFirst().val < num) {
				list.addFirst(new IntPos(i, num));
			}
		}

		for (; i < nums.length; i++) {
			if (!list.isEmpty() && k > i - list.getLast().pos) {
				list.removeLast();
			}

			int num = nums[i];
			if (list.isEmpty() || list.getFirst().val < num) {
				list.addFirst(new IntPos(i, num));
			}
			ret[retIdx++] = list.getFirst().val;
		}

		return ret;
	}

	private static class IntPos {
		int pos = -1;
		int val = -1;

		IntPos(int pos, int val) {
			this.pos = pos;
			this.val = val;
		}
	}

}
