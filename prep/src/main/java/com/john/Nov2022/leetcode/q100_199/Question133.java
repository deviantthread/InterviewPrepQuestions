package com.john.Nov2022.leetcode.q100_199;

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
        if (node == null) {
            return null;
        } else if (node.neighbors == null || node.neighbors.isEmpty()) {
            return new Node(node.val);
        }

        Map<Integer, Node> newNodes = new HashMap<>();
        Set<Integer> processed = new HashSet<>();
        Queue<Node> originalNodeQueue = new LinkedList<>();
        originalNodeQueue.offer(node);
        processed.add(node.val);
        newNodes.put(node.val, new Node(node.val));

        while (!originalNodeQueue.isEmpty()) {
            Node curr = originalNodeQueue.poll();
            Node newNode = newNodes.get(curr.val);

            for (Node neighbor : curr.neighbors) {
                if (!processed.contains(neighbor.val)) {
                    originalNodeQueue.offer(neighbor);
                    processed.add(neighbor.val);
                }

                if (!newNodes.containsKey(neighbor.val)) {
                    newNodes.put(neighbor.val, new Node(neighbor.val));
                }

                newNode.neighbors.add(newNodes.get(neighbor.val));
            }
        }

        return newNodes.get(node.val);
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
