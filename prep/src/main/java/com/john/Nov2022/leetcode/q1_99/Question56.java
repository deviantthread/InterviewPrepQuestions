package com.john.Nov2022.leetcode.q1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(ary -> ary[0]));

        List<int[]> merged = new ArrayList<>();

        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (!areOverlapping(prev, intervals[i])) {
                merged.add(prev);
                prev = intervals[i];
            } else {
                prev = merge(prev, intervals[i]);
            }
        }

        merged.add(prev);

        return merged.toArray(new int[0][]);
    }

    private boolean areOverlapping(int[] prev, int[] next) {
        // overlapping
        // p = [1,3]
        // n = [2,6]

        // p = [1,3]
        // n = [3,6]

        // p = [1,3]
        // n = [1,3]

        // p = [1,6]
        // n = [3,5]

        // p = [1,6]
        // n = [1,5]

        // p = [1,5]
        // n = [1,6]

        // not overlapping

        // p = [1,3]
        // n = [5,6]

        // one value is overlapping
        if (isInside(prev[0], next) ||
            isInside(prev[1], next) ||
            isInside(next[0], prev) ||
            isInside(next[1], prev)) {
            return true;
        } else if (encompasses(prev, next) || encompasses(next, prev)) {
            return true;
        }

        return false;
    }

    private boolean isInside(int val, int[] interval) {
        return interval[0] <= val && val <= interval[1];
    }

    private boolean encompasses(int[] outer, int[] inner) {
        return outer[0] <= inner[0] && inner[1] <= outer[1];
    }

    private int[] merge(int[] prev, int[] next) {
        int left = Math.min(prev[0], next[0]);
        int right = Math.max(prev[1], next[1]);

        return new int[] { left, right };
    }
}
