package com.john.Nov2022.leetcode.q1_99;

import java.util.ArrayList;
import java.util.List;

public class Question57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();

        List<int[]> toCombine = new ArrayList<>();
        boolean haveInsertedCombined = false;
        for (int[] interval : intervals) {
            if (areOverlapping(interval, newInterval)) {
                toCombine.add(interval);
            } else {
                if (toCombine.size() > 0 && !haveInsertedCombined) {
                    toCombine.add(newInterval);
                    haveInsertedCombined = true;
                    merged.add(combine(toCombine));
                }
                merged.add(interval);
            }
        }

        // it was the last interval, didn't get a chance to add it yet
        if (toCombine.size() > 0 && !haveInsertedCombined) {
            toCombine.add(newInterval);
            merged.add(combine(toCombine));
        } else if (toCombine.isEmpty()) {
            //didn't find any overlaps, just add the new interval in the right spot
            addInOrder(merged, newInterval);
        }

        return merged.toArray(new int[0][]);
    }

    private void addInOrder(List<int[]> merged, int[] newInterval) {
        // todo binary search this

        int index = 0;

        for (int[] intervals : merged) {
            if (intervals[0] < newInterval[0]) {
                index++;
            } else {
                break;
            }
        }

        merged.add(index, newInterval);
    }

    private int[] combine(List<int[]> toCombine) {
        int left = toCombine.get(0)[0];
        int right = toCombine.get(0)[1];
        for (int i = 1; i < toCombine.size(); i++) {
            left = Math.min(left, toCombine.get(i)[0]);
            right = Math.max(right, toCombine.get(i)[1]);
        }
        return new int[] { left, right };
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
}
