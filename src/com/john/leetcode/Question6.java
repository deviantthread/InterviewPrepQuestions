package com.john.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 1;
        String result = new Question6().convert(s, numRows);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<StringBuilder>(numRows);

        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        boolean increasing = true;
        int row = 0;
        for (char c : s.toCharArray()) {
            rows.get(row).append(c);
            if (increasing) {
                row++;
            } else {
                row--;
            }

            if (row == rows.size()) {
                row = rows.size() - 2;
                increasing = !increasing;
            } else if (row == -1) {
                row = 1;
                increasing = !increasing;
            }
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : rows) {
            ret.append(sb);
        }

        return ret.toString();
    }

}
