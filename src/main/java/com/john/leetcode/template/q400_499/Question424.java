package com.john.leetcode.template.q400_499;

import java.util.HashMap;
import java.util.Map;

public class Question424 {
    public int characterReplacement(String s, int k) {
        if (s.length() <= k) {
            return k;
        }

        int left = 0;
        int right = -1;
        int maxLen = 0;

        Map<Character, Integer> charCounts = new HashMap<>();

        while (true) {
            int currLen = charCounts.values().stream().reduce(0, Integer::sum);
            int maxSingleChar = charCounts.values().stream().mapToInt(i -> i).max().orElse(0);

            // we've only used one type of letter plus k or less others.
            // keep expanding if possible
            if (maxSingleChar + k >= currLen) {
                maxLen = Math.max(maxLen, currLen);
                // still have room to grow
                if (right < s.length() - 1) {
                    right++;
                    charCounts.compute(s.charAt(right), (key, val) -> val == null ? 1 : val + 1);
                } else {
                    break;
                }
            } else if (left < s.length() - 1) {
                // we've used too many letters, lets kill one and try again
                charCounts.compute(s.charAt(left), (key, val) -> val - 1);
                left++;
            } else {
                break;
            }
        }

        return maxLen;
    }
}
