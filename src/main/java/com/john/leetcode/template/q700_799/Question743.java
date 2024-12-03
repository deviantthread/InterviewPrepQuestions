package com.john.leetcode.template.q700_799;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Question743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // if theres zero or one node, we get it for free
        if (n < 2) {
            return 0;
        }

        NetworkNode startingNode = buildGraph(times, n, k);
        Queue<NetworkEdge> currentQueue = new LinkedList<>();
        Set<NetworkNode> visitedNodes = new HashSet<>();
        visitedNodes.add(startingNode);
        for (NetworkEdge edge : startingNode.edges) {
            currentQueue.offer(edge);
        }

        int time = 0;
        while (!currentQueue.isEmpty()) {
            Queue<NetworkEdge> nextQueue = new LinkedList<>();
            time++;

            while (!currentQueue.isEmpty()) {
                NetworkEdge currentEdge = currentQueue.poll();

                currentEdge.travelTime--;
                if (currentEdge.travelTime > 0) {
                    // haven't reached the node yet, and we haven't visited the node yet, put it back on the queue
                    if (!visitedNodes.contains(currentEdge.node)) {
                        nextQueue.offer(currentEdge);
                    }
                } else {
                    // yay we got there
                    if (!visitedNodes.contains(currentEdge.node)) {
                        // we haven't been here before
                        visitedNodes.add(currentEdge.node);
                        for (NetworkEdge nextEdge : currentEdge.node.edges) {
                            if (!visitedNodes.contains(nextEdge.node)) {
                                // we haven't been to this node yet, lets go here
                                // another edge might already be in flight to this node, but this one might be faster
                                nextQueue.offer(nextEdge);
                            }
                        }
                    }
                }
            }

            // we got to all of em!
            if (visitedNodes.size() == n) {
                return time;
            } else {
                currentQueue = nextQueue;
            }
        }

        return -1;
    }

    private NetworkNode buildGraph(int[][] times, int n, int k) {
        NetworkNode[] nodes = new NetworkNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new NetworkNode(i);
        }

        for (int[] time : times) {
            int src = time[0];
            int dst = time[1];
            int travelTime = time[2];

            nodes[src - 1].edges.add(new NetworkEdge(nodes[dst - 1], travelTime));
        }

        return nodes[k - 1];
    }

    private static class NetworkNode {
        List<NetworkEdge> edges;
        int id;

        public NetworkNode(int id) {
            this.id = id;
            this.edges = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "NetworkNode{" + id + "}";
        }
    }

    private static class NetworkEdge {
        int travelTime;
        NetworkNode node;

        public NetworkEdge(NetworkNode node, int travelTime) {
            this.travelTime = travelTime;
            this.node = node;
        }
    }

    public int networkDelayTimeFirstAttemptWrong(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> srcToDstToDist = mapify(times);

        PriorityQueue<Node> nodes = new PriorityQueue<>(Comparator.comparing(Node::getDist));
        nodes.offer(new Node(k, 0));
        Set<Integer> visited = new HashSet<>();
        visited.add(k);
        int distSoFar = 0;

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            visited.add(node.node);
            distSoFar += node.dist;

            if (visited.size() == n) {
                return distSoFar;
            }

            Map<Integer, Integer> dstToDists = srcToDstToDist.get(node.node);
            if (dstToDists != null) {
                for (Entry<Integer, Integer> dstToDist : dstToDists.entrySet()) {
                    nodes.offer(new Node(dstToDist.getKey(), dstToDist.getValue()));
                }
            }
        }

        return -1;
    }

    private Map<Integer, Map<Integer, Integer>> mapify(int[][] times) {
        Map<Integer, Map<Integer, Integer>> srcToDstToDist = new HashMap<>();

        for (int[] time : times) {
            int src = time[0];
            int dst = time[1];
            int dist = time[2];

            srcToDstToDist.computeIfAbsent(src, unused -> new HashMap<>());
            srcToDstToDist.get(src).put(dst, dist);
        }

        return srcToDstToDist;
    }

    private static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int getDist() {
            return dist;
        }
    }
}
