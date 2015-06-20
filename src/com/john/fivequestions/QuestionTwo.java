package com.john.fivequestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

public class QuestionTwo {

    public static void main(String[] args) {
        Object[] ary1 = { 'a', 'b', 'c' };
        Object[] ary2 = { 1, 2, 3 };
        Object[] combined = combineArrays(ary1, ary2);
        for (Object o : combined) {
            System.out.print(o + ", ");
        }
        System.out.println();
        List<Object> combinedList = combineLists(Arrays.asList(ary1), Arrays.asList(ary2));
        for (Object o : combinedList) {
            System.out.print(o + ", ");
        }
    }

    public static Object[] combineArrays(Object[] ary1, Object[] ary2) {
        Object[] result = new Object[ary1.length * 2];
        int resultIndex = 0;
        for (int i = 0; i < ary1.length; i++) {
            result[resultIndex++] = ary1[i];
            result[resultIndex++] = ary2[i];
        }
        return result;
    }

    public static List<Object> combineLists(List<Object> list1, List<Object> list2) {
        ArrayList<Object> result = Lists.newArrayListWithCapacity(list1.size() + list2.size());

        for (int i = 0; i < list1.size(); i++) {
            result.add(list1.get(i));
            result.add(list2.get(i));
        }

        return result;
    }
}
