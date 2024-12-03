package com.john.leetcode.template.q1_99;

import java.util.ArrayList;
import java.util.List;

public class Question90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        chooseOrNotChoose(nums, 0, ret, curr);

        return ret;
    }

    private void chooseOrNotChoose(int[] nums, int idx, List<List<Integer>> ret, List<Integer> curr) {
        if (idx >= nums.length) {
            ret.add(cloneList(curr));
            return;
        }

        // skip it, we don't want it
        chooseOrNotChoose(nums, idx + 1, ret, curr);

        // also try keeping it, it seems nice
        curr.add(nums[idx]);
        chooseOrNotChoose(nums, idx + 1, ret, curr);
        curr.remove(curr.size() - 1);
    }

    private List<Integer> cloneList(List<Integer> list) {
        return new ArrayList<>(list);
    }
}
