package com.john.Nov2022.leetcode.q51_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();

        LinkedList<Integer> curr = new LinkedList<>();
        dfs(1, n, k, ret, curr);
        return ret;
    }

    private void dfs(int i, int n, int k, List<List<Integer>> ret, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            ret.add(copy(curr));
            return;
        }

        for (int j = i; j <= n; j++) {
            curr.add(j);
            dfs(j + 1, n, k, ret, curr);
            curr.removeLast();
        }
    }

    private List<Integer> copy(List<Integer> list) {
        return new ArrayList<>(list);
    }
}
