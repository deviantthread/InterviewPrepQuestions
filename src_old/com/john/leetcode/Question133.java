package com.john.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
			// 0 -> 1
			// 0 -> 2
			// 1 -> 2
			// 2 -> 2
		}

		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);

		for (UndirectedGraphNode n : node.neighbors) {
			UndirectedGraphNode copyneighber = new UndirectedGraphNode(n.label);
			copyneighber.neighbors.add(copy);
			copy.neighbors.add(copyneighber);
		}

		return node;
	}

	private static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

}
