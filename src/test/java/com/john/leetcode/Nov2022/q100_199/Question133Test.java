package com.john.leetcode.Nov2022.q100_199;

import com.john.Nov2022.leetcode.q100_199.Question133.Node;
import com.john.utils.CollectionCreator;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class Question133Test {
    private Question133 classUnderTest = new Question133();

    @Test
    public void testExample1() {

        int[][] adjList = CollectionCreator.create2DArrayInt("[[2,4],[1,3],[2,4],[1,3]]");

        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 1; i <= adjList.length; i++) {
            nodes.put(i, new Node(i));
        }

        for (int nodeIdx = 0; nodeIdx < adjList.length; nodeIdx++) {
            Node node = nodes.get(nodeIdx + 1);
            for (int neighborIdx = 0; neighborIdx < adjList[nodeIdx].length; neighborIdx++) {
                node.neighbors.add(nodes.get(adjList[nodeIdx][neighborIdx]));
            }
        }

        Node firstNode = nodes.get(1);
        Node clonedNode = classUnderTest.cloneGraph(firstNode);
        int x = 5;

        //    Output: [[2,4],[1,3],[2,4],[1,3]]
        //    Explanation: There are 4 nodes in the graph.
        //        1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
        //        2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
        //        3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
        //        4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
    }
}
