package com.john.Nov2022.leetcode.q300_399;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Question374 {

    // shhh im not here
    private final int pick;

    public int guessNumber(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(int left, int right) {

        int mid = left + (right - left) / 2;

        int guess = guess(mid);
        if (guess == 0) {
            return mid;
        } else if (guess > 0) {
            return binarySearch(mid + 1, right);
        } else {
            return binarySearch(left, mid - 1);
        }
    }

    private int guess(int num) {
        if (num == pick) {
            return 0;
        } else if (num > pick) {
            return -1;
        } else {
            return 1;
        }
    }
}
