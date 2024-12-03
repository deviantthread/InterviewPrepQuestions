package com.john.leetcode;

public class Question8 {

    public static void main(String[] args) {
        // char c = '9';
        // int i = c - 48;
        // System.out.println(i);
        String str = null;
        int myAtoi = new Question8().myAtoi(str);
        System.out.println(myAtoi);
    }

    // basically works, but they have dumb requirements
    public int myAtoi(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        boolean isNeg = str.charAt(0) == '-';

        int start = isNeg ? 1 : 0;
        int num = 0;
        while (start < str.length()) {
            num *= 10;
            num += str.charAt(start++) - 48;
        }
        num = isNeg ? -num : num;

        return num;
    }
}
