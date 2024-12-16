package com.john.leetcode.Dec2024.q1_99;

import java.util.function.BinaryOperator;

public class Question8 {
    public int myAtoi(String s) {
        int idx = 0;
        while (idx < s.length() && Character.isWhitespace(s.charAt(idx))) {
            idx++;
        }
        boolean isPositive = true;
        if (idx < s.length() && s.charAt(idx) == '+') {
            idx++;
        } else if (idx < s.length() && s.charAt(idx) == '-') {
            isPositive = false;
            idx++;
        }

        BinaryOperator<Integer> operation = isPositive ? Integer::sum : (a, b) -> a - b;

        // ok the rest should be ints now
        int result = 0;
        int prev = 0;

        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';
            result = result * 10;
            result = operation.apply(result, digit);


            // overflow detected
            if (result / 10 != prev) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            prev = result;
            idx++;
        }

        return result;
    }
}