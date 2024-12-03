package com.john.leetcode.template.q100_199;

import com.john.leetcode.Nov2022.q100_199.Question133.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
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