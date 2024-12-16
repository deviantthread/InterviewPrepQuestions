package com.john.leetcode.Dec2024.q1_99;

import java.util.LinkedHashMap;

public class Question12 {

    private static LinkedHashMap<Integer, String> valueToSymbols = new LinkedHashMap<>();

    static {
        valueToSymbols.put(1000, "M");
        valueToSymbols.put(900, "CM");
        valueToSymbols.put(500, "D");
        valueToSymbols.put(400, "CD");
        valueToSymbols.put(100, "C");
        valueToSymbols.put(90, "XC");
        valueToSymbols.put(50, "L");
        valueToSymbols.put(40, "XL");
        valueToSymbols.put(10, "X");
        valueToSymbols.put(9, "IX");
        valueToSymbols.put(5, "V");
        valueToSymbols.put(4, "IV");
        valueToSymbols.put(1, "I");
    }

    public String intToRoman(int num) {

        StringBuilder result = new StringBuilder();

        while (num > 0) {
            for (Integer value : valueToSymbols.keySet()) {
                if (value <= num) {
                    result.append(valueToSymbols.get(value));
                    num -= value;
                    break;
                }
            }
        }

        return result.toString();
    }
}