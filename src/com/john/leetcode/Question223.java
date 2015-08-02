package com.john.leetcode;

import java.awt.Point;

public class Question223 {

	public static void main(String[] args) {
		int[] i = { -5, -2, 5, 1, -3, -3, 3, 3 };

		int A = i[0];
		int B = i[1];
		int C = i[2];
		int D = i[3];
		int E = i[4];
		int F = i[5];
		int G = i[6];
		int H = i[7];
		System.out.println(new Question223().computeArea(A, B, C, D, E, F, G, H));
	}

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		Point box1Lower = new Point(A, B);
		Point box1Upper = new Point(C, D);
		Point box2Lower = new Point(E, F);
		Point box2Upper = new Point(G, H);
		Box box1 = new Box(box1Lower, box1Upper);
		Box box2 = new Box(box2Lower, box2Upper);

		int box1Area = calcArea(box1);
		int box2Area = calcArea(box2);

		int totalArea = box1Area + box2Area;

		boolean hasOverlap = hasOverlap(box1, box2);
		if (hasOverlap) {
			int lowerX = Math.max(A, E);
			int lowerY = Math.max(B, F);
			int upperX = Math.min(C, G);
			int upperY = Math.min(D, H);
			int width = upperX - lowerX;
			int height = upperY - lowerY;
			int overlapArea = width * height;

			totalArea -= overlapArea;
		}

		return totalArea;
	}

	private boolean hasOverlap(Box box1, Box box2) {
		Point box1Lower = box1.lower;
		Point box1Upper = box1.upper;
		Point box2Lower = box2.lower;
		Point box2Upper = box2.upper;

		if (box1Lower.x <= box2Lower.x && box2Lower.x <= box1Upper.x && box1Lower.y <= box2Upper.y
				&& box2Upper.y <= box1Upper.y) {
			return true;
		} else if (box2Lower.x <= box1Lower.x && box1Lower.x <= box2Upper.x && box2Lower.y <= box1Upper.y
				&& box1Upper.y <= box2Upper.y) {
			return true;
		} else if (isInBox(box1Lower, box2) || isInBox(box1Upper, box2) || isInBox(box2Lower, box1)
				|| isInBox(box2Upper, box1)) {
			return true;
		}
		return false;
	}

	private boolean isInBox(Point point, Box box) {
		return box.lower.x <= point.x && point.x <= box.upper.x && box.lower.y <= point.y && point.y <= box.upper.y;
	}

	private int calcArea(Box box) {
		Point upper = box.upper;
		Point lower = box.lower;
		int width = upper.x - lower.x;
		int height = upper.y - lower.y;

		return width * height;
	}

	private static class Box {
		Point lower;
		Point upper;

		public Box(Point lower, Point upper) {
			this.lower = lower;
			this.upper = upper;
		}
	}
}
