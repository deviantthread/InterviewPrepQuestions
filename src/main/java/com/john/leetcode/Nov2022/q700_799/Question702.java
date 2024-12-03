package com.john.leetcode.Nov2022.q700_799;

public class Question702 {
    public int search(ArrayReader reader, int target) {
        return binarySearch(reader, target, 0, Integer.MAX_VALUE);
    }

    private int binarySearch(ArrayReader reader, int target, int left, int right) {
        if (right - left <= 1) {
            if (reader.get(left) == target) {
                return left;
            } else if (reader.get(right) == target) {
                return right;
            } else {
                return -1;
            }
        }

        int mid = left + (right - left) / 2;

        if (reader.get(mid) == target) {
            return mid;
        } else if (reader.get(mid) > target) {
            return binarySearch(reader, target, left, mid - 1);
        } else {
            return binarySearch(reader, target, mid + 1, right);
        }
    }

    public static class ArrayReader {
        int[] ary;

        public ArrayReader(int[] ary) {
            this.ary = ary;
        }

        public int get(int index) {
            if (index < ary.length) {
                return ary[index];
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}
