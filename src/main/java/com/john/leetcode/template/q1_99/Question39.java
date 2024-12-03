package com.john.leetcode.template.q1_99;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        chooseOrNot(result, new ArrayList<>(), candidates, target, 0, 0);

        return result;
    }

    private void chooseOrNot(List<List<Integer>> result, List<Integer> curr, int[] candidates, int target, int currSum, int i) {
        if (currSum == target) {
            result.add(curr);
            return;
        } else if (currSum > target || i >= candidates.length) {
            return;
        }

        List<Integer> withNum = cloneList(curr);
        withNum.add(candidates[i]);
        List<Integer> withoutNum = cloneList(curr);

        chooseOrNot(result, withNum, candidates, target, currSum + candidates[i], i);
        chooseOrNot(result, withoutNum, candidates, target, currSum, i + 1);
    }

    public List<List<Integer>> combinationSumMyFunkyWay(int[] candidates, int target) {
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
