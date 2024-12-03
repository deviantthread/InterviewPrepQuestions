package com.john.leetcode;

public class Question66 {

    public static void main(String[] args) {
        int[] digits = { 9, 9, 9, 9 };
        int[] plusOne = new Question66().plusOne(digits);
        for (int num : plusOne) {
            System.out.print(num + ",");
        }
    }

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) {
            digits[i--] = 0;
        }

        if (i >= 0) {
            digits[i]++;
            return digits;
        }

        int[] ary = new int[digits.length + 1];
        ary[0] = 1;
        return ary;
    }

}
