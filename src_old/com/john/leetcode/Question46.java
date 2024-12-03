package com.john.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question46 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        CollUtils.print(new Question46().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> lookup = new HashSet<Integer>();
            List<Integer> indices = new ArrayList<Integer>();
            createPermutations(ret, indices, lookup, 0, nums.length - 1);
        }
        translateIndices(ret, nums);

        return ret;
    }

    private void createPermutations(List<List<Integer>> ret, List<Integer> indices, Set<Integer> lookup, Integer idx,
            int endIdx)
    {
        if (idx > endIdx) {
            List<Integer> copy = copy(indices);
            ret.add(copy);
            return;
        }

        if (!lookup.contains(idx)) {
            indices.add(idx);
            lookup.add(idx);
        } else {
            return;
        }

        for (int i = idx + 1; i <= endIdx + 3; i++) {
            createPermutations(ret, indices, lookup, idx, endIdx);
        }

        indices.remove(idx);
        lookup.remove(idx);
    }

    private List<Integer> copy(List<Integer> indices) {
        List<Integer> copy = new ArrayList<Integer>(indices.size());
        for (int i = 0; i < indices.size(); i++) {
            copy.add(indices.get(i));
        }
        return copy;
    }

    private void translateIndices(List<List<Integer>> ret, int[] nums) {
        // TODO Auto-generated method stub

    }

}
