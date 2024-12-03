package com.john.leetcode;

public class Question62 {

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        System.out.print(new Question62().uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        return findPaths(m, n, 1, 1);
    }

    private int findPaths(int m, int n, int x, int y) {
        if (x == m && y == n) {
            return 1;
        }

        int count = 0;
        if (x < m) {
            count += findPaths(m, n, x + 1, y);
        }
        if (y < n) {
            count += findPaths(m, n, x, y + 1);
        }
        return count;
    }
}
