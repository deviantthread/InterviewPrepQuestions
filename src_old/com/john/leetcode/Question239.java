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
        if (nums.length == 0) {
            return nums;
        }

        LinkedList<IntPos> list = new LinkedList<IntPos>();
        int[] ret = new int[nums.length - k + 1];
        int retIdx = 0;
        int i = 0;
        for (i = 0; i < k - 1; i++) {
            int num = nums[i];
            if (list.isEmpty() || list.getFirst().val < num) {
                list.addFirst(new IntPos(i, num));
            }
        }

        for (; i < nums.length; i++) {
            // delete out of range elements
            if (!list.isEmpty() && i - list.getLast().pos >= k) {
                list.removeLast();
            }

            // ran out of a max, find a new max in the last k elements
            if (list.isEmpty()) {
                for (int j = i - k + 1; j < i; j++) {
                    int num = nums[j];
                    if (list.isEmpty() || list.getFirst().val < num) {
                        list.addFirst(new IntPos(j, num));
                    }
                }
            }

            int num = nums[i];
            // if new element is the max, add it
            if (list.isEmpty() || list.getFirst().val < num) {
                list.addFirst(new IntPos(i, num));
            }

            // max is at head of list
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
