package com.john.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question230 {

	public static void main(String[] args) {
		OldTreeNode root = OldTreeNode.generateTree("1|0,");
		OldTreeNode.printNodes(root);
		int k = 3;
		System.out.println(new Question230().kthSmallest(root, k));

	}

	public int kthSmallest(OldTreeNode root, int k) {

		Comparator<? super Integer> maxCompare = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2) {
					return 1;
				} else if (o1 > o2) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, maxCompare);
		findKthSmallest(root, k, heap);
		return heap.remove();
	}

	private void findKthSmallest(OldTreeNode node, int k, PriorityQueue<Integer> heap) {
		if (heap.size() == k || node == null) {
			return;
		}

		findKthSmallest(node.left, k, heap);
		if (heap.size() < k) {
			heap.add(node.val);
		}
		findKthSmallest(node.right, k, heap);
	}

}
