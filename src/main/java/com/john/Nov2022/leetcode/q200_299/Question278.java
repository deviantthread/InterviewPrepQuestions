package com.john.Nov2022.leetcode.q200_299;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Question278 {
    //shh doesn't exist
    private final int badVersion;

    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(int left, int right) {
        if (right - left <= 1) {
            return isBadVersion(left) ? left : right;
        }

        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            return isBadVersion(mid - 1) ? binarySearch(left, mid - 1) : mid;
        } else {
            return binarySearch(mid + 1, right);
        }
    }

    public boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}
