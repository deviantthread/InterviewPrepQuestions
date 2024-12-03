package com.john.leetcode.Nov2022.q900_999;

public class Question978 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        } else if (arr.length == 2) {
            return arr[0] == arr[1] ? 1 : 2;
        }

        int maxLen = 1;
        int currLen = 1;
        Boolean prevGreater = null;

        for (int i = 1; i < arr.length; i++) {
            boolean currGreater = arr[i] > arr[i - 1];
            if (prevGreater == null || currGreater != prevGreater) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 1;
            }

            prevGreater = currGreater;
        }

        return maxLen;
    }
}
