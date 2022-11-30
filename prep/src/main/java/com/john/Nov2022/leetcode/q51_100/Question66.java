package com.john.Nov2022.leetcode.q51_100;

public class Question66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) {
                break;
            }

            digits[i] += carry;

            if (digits[i] <= 9) {
                carry = 0;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }

        // if we carried all the way through to new digits
        if (carry == 1) {
            int[] longer = new int[digits.length + 1];
            longer[0] = 1;
            return longer;
        }

        return digits;
    }
}
