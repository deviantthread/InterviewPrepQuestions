package com.john.fivequestions;

import java.util.List;

import com.google.common.collect.Lists;

public class QuestionThree {
    public static void main(String[] args) {
        List<Long> fibNums = Lists.newArrayList();
        fibNums.add(0L);
        fibNums.add(1L);
        calculateFibNumbersRecursive(0L, 1L, 100, fibNums);
        System.out.println(fibNums);
        List<Long> calculateFibNumbersIterative = calculateFibNumbersIterative(100);
        System.out.println(calculateFibNumbersIterative);
    }

    private static void calculateFibNumbersRecursive(Long prev, Long curr, int target, List<Long> fibNums) {
        if (target == 0) {
            return;
        }

        Long next = prev + curr;
        fibNums.add(next);
        calculateFibNumbersRecursive(curr, next, target - 1, fibNums);
    }

    private static List<Long> calculateFibNumbersIterative(int target) {
        Long prev = 0L;
        Long curr = 1L;
        List<Long> fibNums = Lists.newArrayList();
        fibNums.add(prev);
        fibNums.add(curr);
        for (int i = 2; i < target; i++) {
            Long next = prev + curr;
            fibNums.add(next);
            prev = curr;
            curr = next;
        }

        return fibNums;
    }
}
