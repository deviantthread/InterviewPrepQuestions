package com.john.fivequestions;

public class QuestionOne {

    public static void sum1(int[] ary) {
        int sum = 0;
        for (int i : ary) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void sum2(int[] ary) {
        int sum = 0;
        int i = 0;
        while (i < ary.length) {
            sum += ary[i++];
        }
        System.out.println(sum);
    }

    public static void sum3(int[] ary) {
        int sum = sum3_recurse(ary, 0);
        System.out.println(sum);
    }

    private static int sum3_recurse(int[] ary, int i) {
        if (i >= ary.length) {
            return 0;
        }
        return ary[i] + sum3_recurse(ary, i + 1);
    }
}
