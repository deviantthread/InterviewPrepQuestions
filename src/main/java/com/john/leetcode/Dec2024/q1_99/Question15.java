package com.john.leetcode.Dec2024.q1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<String> resultWithoutDuplicates = new HashSet<>();
        for (int a = 0; a < nums.length; a++) {
            addTwoSums(nums, a, resultWithoutDuplicates);
        }

        return convertToList(resultWithoutDuplicates);
    }

    private List<List<Integer>> convertToList(Set<String> resultWithoutDuplicates) {
        List<List<Integer>> result = new ArrayList<>(resultWithoutDuplicates.size());

        for (String resultWithoutDuplicate : resultWithoutDuplicates) {
            String[] split = resultWithoutDuplicate.split(",");
            List<Integer> solution = new ArrayList<>();
            for (String s : split) {
                solution.add(Integer.parseInt(s));
            }
            result.add(solution);
        }

        return result;
    }

    private void addTwoSums(int[] nums, int fixedIdx, Set<String> result) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (left == fixedIdx) {
                left++;
                continue;
            }
            if (right == fixedIdx) {
                right--;
                continue;
            }

            int sum = nums[left] + nums[right] + nums[fixedIdx];
            if (sum == 0) {
                List<Integer> solution = new ArrayList<>();
                solution.add(nums[left]);
                solution.add(nums[right]);
                solution.add(nums[fixedIdx]);
                solution.sort(Integer::compare);

                result.add(solution.get(0) + "," + solution.get(1) + "," + solution.get(2));
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}