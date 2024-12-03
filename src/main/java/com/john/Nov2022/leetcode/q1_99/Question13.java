package com.john.Nov2022.leetcode.q1_99;

import java.util.LinkedHashMap;

public class Question13 {
    /*
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
     */
    private static LinkedHashMap<String, Integer> symbolToValue = new LinkedHashMap<>();

    static {
        symbolToValue.put("M", 1000);
        symbolToValue.put("CM", 900);
        symbolToValue.put("D", 500);
        symbolToValue.put("CD", 400);
        symbolToValue.put("C", 100);
        symbolToValue.put("XC", 90);
        symbolToValue.put("L", 50);
        symbolToValue.put("XL", 40);
        symbolToValue.put("X", 10);
        symbolToValue.put("IX", 9);
        symbolToValue.put("V", 5);
        symbolToValue.put("IV", 4);
        symbolToValue.put("I", 1);
    }

    public int romanToInt(String s) {
        int sum = 0;

        int idx = 0;

        while (idx < s.length()) {
            for (String symbol : symbolToValue.keySet()) {
                if (s.substring(idx).startsWith(symbol)) {
                    sum += symbolToValue.get(symbol);
                    idx += symbol.length();
                    break;
                }
            }
        }

        return sum;
    }
}
