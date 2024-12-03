package com.john.Nov2022.leetcode.q100_199;

import com.john.leetcode.inputhelp.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question134Test {
    private Question134 classUnderTest = new Question134();

    @Test
    public void testExample1() {
        int[] gas = CollectionCreator.createArrayInt("[1,2,3,4,5]");
        int[] cost = CollectionCreator.createArrayInt("[3,4,5,1,2]");
        int expected = 3;

        Assert.assertEquals(expected, classUnderTest.canCompleteCircuit(gas, cost));
        //    Explanation:
        //    Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
        //    Travel to station 4. Your tank = 4 - 1 + 5 = 8
        //    Travel to station 0. Your tank = 8 - 2 + 1 = 7
        //    Travel to station 1. Your tank = 7 - 3 + 2 = 6
        //    Travel to station 2. Your tank = 6 - 4 + 3 = 5
        //    Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
        //    Therefore, return 3 as the starting index.
    }

    @Test
    public void testExample2() {

        int[] gas = CollectionCreator.createArrayInt("[2,3,4]");
        int[] cost = CollectionCreator.createArrayInt("[3,4,3]");
        int expected = -1;

        Assert.assertEquals(expected, classUnderTest.canCompleteCircuit(gas, cost));
        //    Explanation:
        //    You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
        //    Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
        //    Travel to station 0. Your tank = 4 - 3 + 2 = 3
        //    Travel to station 1. Your tank = 3 - 3 + 3 = 3
        //    You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
        //    Therefore, you can't travel around the circuit once no matter where you start.
    }
}
