package com.john.leetcode.Dec2024.q1500_1599;

public class Question1518 {
    /*
        There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

        The operation of drinking a full water bottle turns it into an empty bottle.

        Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int numFull = numBottles;
        int numEmpty = 0;
        int result = 0;

        while(numFull + numEmpty >= numExchange) {
            result += numFull;
            numEmpty += numFull;
            numFull = numEmpty / numExchange;
            numEmpty = numEmpty % numExchange;
        }

        return result + numFull;
    }
}
