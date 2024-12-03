package com.john.leetcode.Nov2022.q900_999;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparing((Point p) -> p.distance));

        for (int[] point : points) {
            queue.offer(new Point(point, calculateDistanceToOrigin(point)));
        }

        int[][] closest = new int[k][2];

        for (int i = 0; i < k; i++) {
            closest[i] = queue.poll().point;
        }

        return closest;
    }

    private double calculateDistanceToOrigin(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

    private static class Point {
        int[] point;
        double distance;

        public Point(int[] point, double distance) {
            this.point = point;
            this.distance = distance;
        }
    }
}
