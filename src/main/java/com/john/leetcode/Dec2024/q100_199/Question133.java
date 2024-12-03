package com.john.leetcode.Dec2024.q100_199;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question133 {
    public Node cloneGraph(Node node) {
        return null;
    }

    public static class Node {
        public final int val;
        public final List<Node> neighbors;

        public Node(int val) {
            this(val, new ArrayList<>());
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

        @Override
        public String toString() {
            String neighbors = this.neighbors.stream().map(n -> String.valueOf(n.val)).collect(Collectors.joining(","));
            return String.format("%d -> [%s]", val, neighbors);
        }
    }
}