package com.john.utils;

public class PrettyPrinter {

    public static void print(char[][] ary) {
        String[][] strAry = new String[ary.length][ary[0].length];
        for (int row = 0; row < ary.length; row++) {
            for (int col = 0; col < ary[row].length; col++) {
                if (ary[row][col] == '\u0000') {
                    strAry[row][col] = " ";
                } else {
                    strAry[row][col] = String.valueOf(ary[row][col]);
                }
            }
        }

        print(strAry);
    }

    public static void print(int[][] ary) {
        String[][] strAry = new String[ary.length][ary[0].length];
        for (int row = 0; row < ary.length; row++) {
            for (int col = 0; col < ary[row].length; col++) {
                strAry[row][col] = String.valueOf(ary[row][col]);
            }
        }

        print(strAry);
    }

    public static void print(String[][] ary) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ary.length; i++) {
            sb.append("\n\t").append("[");

            for (int j = 0; j < ary[i].length; j++) {
                sb.append(ary[i][j]);
                if (j + 1 < ary[i].length) {
                    sb.append(",");
                }
            }

            sb.append("]");
            if (i + 1 < ary.length) {
                sb.append(",");
            }
        }

        sb.append("\n").append("]");

        System.out.println(sb);
    }
}
