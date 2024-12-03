package com.john.Nov2022.leetcode.q1_99;

import java.util.ArrayList;
import java.util.List;

public class Question78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        chooseOrNotChooseSubset(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void chooseOrNotChooseSubset(List<List<Integer>> result, List<Integer> curr, int[] nums, int i) {
        if (i >= nums.length) {
            result.add(curr);
            return;
        }

        List<Integer> withNum = copy(curr);
        List<Integer> withoutNum = copy(curr);

        withNum.add(nums[i]);

        chooseOrNotChooseSubset(result, withNum, nums, i + 1);
        chooseOrNotChooseSubset(result, withoutNum, nums, i + 1);
    }

    public List<List<Integer>> subsetsMyClunkyWay(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return result;
        }
        /*
        algo
        start with empty list in result list
        have one "building" list. it starts empty, and we add each number one at a time and build off the previous list
        before adding a number, clone it and add it to result

        we only move forward through the nums array.
        so we build the result in this order (given [1,2,3])
        [], [1], [1,2], [1,2,3], [1,3] (reset to [] here), [2], [2,3], (reset here) [3]
         */

        for (int i = 0; i < nums.length; i++) {
            addAtI(result, new ArrayList<>(), nums, i);
        }

        return result;
    }

    private void addAtI(List<List<Integer>> result, List<Integer> curr, int[] nums, int startIdx) {
        if (startIdx == nums.length) {
            return;
        }

        List<Integer> newList = copy(curr);
        newList.add(nums[startIdx]);
        result.add(newList);

        for (int nextIdx = startIdx + 1; nextIdx < nums.length; nextIdx++) {
            addAtI(result, newList, nums, nextIdx);
        }
    }

    private List<Integer> copy(List<Integer> prevList) {
        ArrayList<Integer> newList = new ArrayList<>(prevList.size() + 1);
        newList.addAll(prevList);
        return newList;
    }
}
