package com.john.Nov2022.leetcode.q1_50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new LinkedList<>();

        comboSum(result, curr, 0, 0, candidates, target);
        return result;
    }

    private void comboSum(List<List<Integer>> result, List<Integer> curr, int currIdx, int currSum, int[] candidates, int target) {
        if (currSum > target) {
            return;
        } else if (currSum == target) {
            result.add(cloneList(curr));
            return;
        }

        for (int i = currIdx; i < candidates.length; i++) {
            curr.add(candidates[i]);
            comboSum(result, curr, i, currSum + candidates[i], candidates, target);
            curr.remove(curr.size() - 1);
        }
    }

    private List<Integer> cloneList(List<Integer> curr) {
        List<Integer> clone = new ArrayList<>(curr.size());
        clone.addAll(curr);
        return clone;
    }
}
