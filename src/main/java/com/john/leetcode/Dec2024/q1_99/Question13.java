package com.john.leetcode.Dec2024.q1_99;

import java.util.LinkedHashMap;

public class Question13 {

    private static final LinkedHashMap<String, Integer> romanToInt = new LinkedHashMap<>();

    static {
        romanToInt.put("M", 1000);
        romanToInt.put("CM", 900);
        romanToInt.put("D", 500);
        romanToInt.put("CD", 400);
        romanToInt.put("C", 100);
        romanToInt.put("XC", 90);
        romanToInt.put("L", 50);
        romanToInt.put("XL", 40);
        romanToInt.put("X", 10);
        romanToInt.put("IX", 9);
        romanToInt.put("V", 5);
        romanToInt.put("IV", 4);
        romanToInt.put("I", 1);
    }

    public int romanToInt(String s) {
        int result = 0;

        while (!s.isEmpty()) {
            for (String roman : romanToInt.keySet()) {
                if (s.startsWith(roman)) {
                    result += romanToInt.get(roman);
                    s = s.substring(roman.length());
                    break;
                }
            }
        }

        return result;
    }
}