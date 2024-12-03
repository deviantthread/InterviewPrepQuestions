package com.john.leetcode.template.q100_199;

public class Question125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !(Character.isAlphabetic(s.charAt(left)) || Character.isDigit(s.charAt(left)))) {
                left++;
            }

            while (left < right && !(Character.isAlphabetic(s.charAt(right)) || Character.isDigit(s.charAt(right)))) {
                right--;
            }

            if (!String.valueOf(s.charAt(left++)).equalsIgnoreCase(String.valueOf(s.charAt(right--)))) {
                return false;
            }
        }

        return true;
    }
}
