package com.john.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Question229 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<Integer> ret = new Question229().majorityElement(nums);

        CollUtils.print(ret);

    }

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                Integer j = map.get(num);
                j++;
                map.put(num, j);
            } else {
                map.put(num, 1);
            }
        }

        NumCount holder = new NumCount();
        holder.count = Integer.MAX_VALUE;
        NumCount highest = getHighest(map, holder);
        NumCount second = getHighest(map, highest);

        List<Integer> ret = new ArrayList<Integer>();

        if (highest != null && highest.count > (nums.length / 3)) {
            ret.add(highest.num);
        }
        if (second != null && second.count > (nums.length / 3)) {
            ret.add(second.num);
        }

        return ret;
    }

    private NumCount getHighest(Map<Integer, Integer> map, NumCount under) {
        int num = -1;
        int count = -1;
        int max = under.count;

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= count && entry.getValue() <= max) {
                num = entry.getKey();
                count = entry.getValue();
            }
        }

        map.remove(num);
        NumCount nc = new NumCount();
        nc.num = num;
        nc.count = count;

        return nc;
    }

    private static class NumCount {
        Integer num;
        Integer count = 0;
    }

}
