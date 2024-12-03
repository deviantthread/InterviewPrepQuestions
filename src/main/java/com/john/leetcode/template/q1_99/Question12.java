package com.john.leetcode.template.q1_99;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

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
        String result = "";

        while (num > 0) {
            for (Entry<Integer, String> valueToSymbol : valueToSymbols.entrySet()) {
                if (valueToSymbol.getKey() <= num) {
                    result += valueToSymbol.getValue();
                    num -= valueToSymbol.getKey();
                    break;
                }
            }
        }

        return result;
    }
}
