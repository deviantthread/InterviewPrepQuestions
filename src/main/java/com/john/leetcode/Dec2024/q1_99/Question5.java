package com.john.leetcode.Dec2024.q1_99;

public class Question5 {
    public String longestPalindrome(String s) {
        String max = "";

        for (int i = 0; i < s.length(); i++) {
            String longest = longestPalindrome(s, i);
            max = longest.length() > max.length() ? longest : max;
        }

        return max;
    }

    private String longestPalindrome(String s, int idx) {
        int oddLeft = idx;
        int oddRight = idx;

        while (oddLeft >= 0 && oddRight < s.length()) {
            if (s.charAt(oddLeft) != s.charAt(oddRight)) {
                break;
            }
            oddLeft--;
            oddRight++;
        }
        oddLeft++;

        int evenLeft = idx;
        int evenRight = idx + 1;

        while (evenLeft >= 0 && evenRight < s.length()) {
            if (s.charAt(evenLeft) != s.charAt(evenRight)) {
                break;
            }
            evenLeft--;
            evenRight++;
        }
        evenLeft++;

        return oddRight - oddLeft > evenRight - evenLeft ? s.substring(oddLeft,oddRight) : s.substring(evenLeft, evenRight);
    }
}