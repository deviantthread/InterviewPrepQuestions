package com.john.leetcode;

public class Question165 {

    public static void main(String[] args) {
        String version1 = "0.9";
        String version2 = "0.11.1";
        System.out.println(new Question165().compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {

        String[] ary1 = version1.split("\\.");
        String[] ary2 = version2.split("\\.");
        int max = Math.max(ary1.length, ary2.length);
        ary1 = pad(ary1, max);
        ary2 = pad(ary2, max);

        for (int i = 0; i < ary1.length; i++) {
            int comparison = compare(ary1[i], ary2[i]);
            if (comparison != 0) {
                return comparison;
            }
        }

        return 0;
    }

    private String[] pad(String[] ary2, int max) {
        if (ary2.length == max) {
            return ary2;
        }

        String[] ret = new String[max];
        for (int i = 0; i < max; i++) {
            if (i < ary2.length) {
                ret[i] = ary2[i];
            } else {
                ret[i] = "0";
            }
        }

        return ret;
    }

    private int compare(String str1, String str2) {
        if (str1.length() != str2.length()) {
            int max = Math.max(str1.length(), str2.length());
            str1 = pad(str1, max);
            str2 = pad(str2, max);
        }

        for (int i = 0; i < str1.length(); i++) {
            int comparison = str1.charAt(i) - str2.charAt(i);
            if (comparison > 0) {
                return 1;
            } else if (comparison < 0) {
                return -1;
            }
        }

        return 0;
    }

    private String pad(String str, int max) {
        String ret = str;
        while (ret.length() < max) {
            ret = "0" + ret;
        }
        return ret;
    }
}
