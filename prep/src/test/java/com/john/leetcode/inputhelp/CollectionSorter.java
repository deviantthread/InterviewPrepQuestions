package com.john.leetcode.inputhelp;

import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CollectionSorter {

    public static void sortListListInt(List<List<Integer>> collection) {

        Map<Integer, Integer> hashCodeToSum = Maps.newHashMap();

        // sort by sum of values first, then just left to right
        Comparator<List<Integer>> intListComparor = (a, b) -> {
            if (!hashCodeToSum.containsKey(a.hashCode())) {
                hashCodeToSum.put(a.hashCode(), a.stream().reduce(0, Integer::sum));
            }

            if (!hashCodeToSum.containsKey(b.hashCode())) {
                hashCodeToSum.put(b.hashCode(), b.stream().reduce(0, Integer::sum));
            }

            int sumComparison = Integer.compare(hashCodeToSum.get(a.hashCode()), hashCodeToSum.get(b.hashCode()));
            if (sumComparison != 0) {
                return sumComparison;
            } else {
                return Integer.compare(a.stream().max(Integer::compareTo).orElse(0), b.stream().max(Integer::compareTo).orElse(0));
            }
        };
        // each inner list sorted
        collection.forEach(listInt -> listInt.sort(Integer::compareTo));

        // outer list sorted
        collection.sort(intListComparor);
    }
}
