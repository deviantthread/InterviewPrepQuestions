package com.john.leetcode.Dec2024.q1_99;

import com.john.utils.PrettyPrinter;

public class Question6 {
    public String convert(String s, int numRows) {
//        int numCols = s.length() / numRows;

        char[][] zigzag = new char[numRows][s.length()];

        int row = 0;
        int col = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            zigzag[row][col] = s.charAt(i);
            if(down) {
                row++;
                if(row == zigzag.length) {
                    down = false;
                    row -= 2;
                    col += 1;
                }
            } else {
                row -= 1;
                col += 1;
                if(row == -1) {
                    row += 2;
                    col--;
                    down = true;
                }
            }
        }

        PrettyPrinter.print(zigzag);

        StringBuilder result = new StringBuilder();
        for (int rowIdx = 0; rowIdx < zigzag.length; rowIdx++) {
            for (int colIdx = 0; colIdx < zigzag[rowIdx].length; colIdx++) {
                if(zigzag[rowIdx][colIdx] != '\u0000'){
                    result.append(zigzag[rowIdx][colIdx]);
                }
            }
        }

        return result.toString();
    }
}