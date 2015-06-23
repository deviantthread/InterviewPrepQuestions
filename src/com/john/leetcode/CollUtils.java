package com.john.leetcode;

public class CollUtils {
    public static <T> void print(T[] ary) {
        System.out.print("{ ");
        for (T t : ary) {
            System.out.print(String.valueOf(t) + ", ");
        }
        System.out.print("}");
        System.out.println("\n");
    }

    public static <T> void print(T[] ary, String msg) {
        System.out.println(msg);
        print(ary);
    }

    public static <T> void print(int[] ary) {
        System.out.print("{ ");
        for (int t : ary) {
            System.out.print(String.valueOf(t) + ", ");
        }
        System.out.print("}");
        System.out.println("\n");
    }

    public static <T> void print(int[] ary, String msg) {
        System.out.println(msg);
        print(ary);
    }

}
