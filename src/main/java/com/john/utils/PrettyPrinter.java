package com.john.utils;

public class PrettyPrinter {

    public static void print(int[][] ary) {
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
