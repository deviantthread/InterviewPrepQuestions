package com.john.leetcode;

public class Question7 {
    public static void main(String[] args) {
        int x = 10;
        int reverse = new Question7().reverse(x);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        boolean isNeg = x < 0;
        try {
            return Integer.parseInt(new StringBuilder().append(String.valueOf(Math.abs(x)).toCharArray())
                    .append(isNeg ? "-" : "").reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
