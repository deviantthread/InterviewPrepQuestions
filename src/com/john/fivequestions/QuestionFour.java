package com.john.fivequestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

public class QuestionFour {

    public static void main1(String[] args) {
        List<Integer> numbers = Lists.newArrayList(5000, 49, 49);

        String number = arrangeLargestNumber(numbers);
        System.out.print(number);
    }

    private static String arrangeLargestNumber(List<Integer> numbers) {
        Collections.sort(numbers, new comparer());

        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }

    private static class comparer implements Comparator<Integer> {

        @Override
        public int compare(Integer num1, Integer num2) {
            // 6 == 6
            if (num1.equals(num2)) {
                return 0;
            }

            int[] ary1 = toIntArray(num1);
            int[] ary2 = toIntArray(num2);

            // 34 > 33
            // 7 > 4
            // 556 > 54
            int i;
            for (i = 0; i < ary1.length && i < ary2.length; i++) {
                if (ary1[i] > ary2[i]) {
                    return -1;
                } else if (ary1[i] < ary2[i]) {
                    return 1;
                }
            }

            // 55 > 551
            // 55 < 556
            // 61 > 612

            if (ary1.length > ary2.length) {
                return compareUnevenLengths1(ary1, ary2, i);
            } else {
                return compareUnevenLengths2(ary2, ary1, i);
            }
        }

        private int compareUnevenLengths1(int[] longer, int[] shorter, int i) {
            for (int num : shorter) {
                if (longer[i] > num) {
                    return -1;
                } else if (longer[i] < num) {
                    return 1;
                }
            }

            return compareUnevenLengths1(longer, shorter, i + 1);
        }

        private int compareUnevenLengths2(int[] longer, int[] shorter, int i) {
            for (int num : shorter) {
                if (longer[i] > num) {
                    return 1;
                } else if (longer[i] < num) {
                    return -1;
                }
            }

            return compareUnevenLengths2(longer, shorter, i + 1);
        }

        private int[] toIntArray(Integer num) {
            String s = num.toString();
            int[] ary = new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                ary[i] = Integer.parseInt(s.substring(i, i + 1));
            }

            return ary;
        }

    }
}
