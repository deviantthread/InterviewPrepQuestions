package com.john.leetcode;

public class Question134 {

	public static void main(String[] args) {
		int[] gas = { 0, 7, 1, 2, 3, 4, 0 };
		int[] cost = { 10, 1, 0, 0, 0, 0, 1 };
		System.out.println(new Question134().canCompleteCircuit(gas, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sum = 0;
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
		}

		if (sum < 0) {
			return -1;
		}

		int[][] start2endCost = new int[gas.length][gas.length];

		// build matrix
		int endStartAt = 0;
		for (int start = 0; start < gas.length; start++) {
			for (int end = endStartAt; end < gas.length; end++) {
				int prevEnd = end - 1;
				if (prevEnd < 0) {
					prevEnd = gas.length - 1;
				}

				start2endCost[start][end] = start2endCost[start][prevEnd]
						+ gas[end] - cost[end];

				if (start != end) {
					start2endCost[end][start] = sum - start2endCost[start][end];
				}
			}
			endStartAt++;
		}

		// find valid starting location
		for (int start = 0; start < start2endCost.length; start++) {
			int end = 0;
			for (; end < start2endCost[start].length; end++) {
				if (start2endCost[start][end] < 0) {
					break;
				}
			}
			if (end == start2endCost[start].length) {
				return start;
			}
		}

		return -1;
	}

	public int canCompleteCircuitIter(int[] gas, int[] cost) {
		if (gas.length == 1) {
			return 0;
		}

		int[] delta = createDelta(gas, cost);

		for (int i = 0; i < gas.length; i++) {
			int endIdx = i - 1;
			if (endIdx == -1) {
				endIdx = gas.length - 1;
			}

			if (canCompleteFromIIter(delta, i, endIdx)) {
				return i;
			}
		}
		return -1;
	}

	private int[] createDelta(int[] gas, int[] cost) {
		int[] delta = new int[gas.length];

		for (int i = 0; i < gas.length; i++) {
			delta[i] = gas[i] - cost[i];
		}

		return delta;
	}

	private boolean canCompleteFromIIter(int[] delta, int startIdx, int endIdx) {
		int currGas = 0;
		int i = startIdx;
		for (; i != endIdx; i++) {
			if (i == delta.length) {
				i = -1;
				continue;
			}

			currGas += delta[i];

			if (currGas < 0) {
				return false;
			}
		}

		currGas += delta[i];

		return currGas >= 0;
	}
}
