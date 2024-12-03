package com.john.leetcode.Nov2022.q800_899;

import java.util.stream.IntStream;

public class Question875 {
    public int minEatingSpeed(int[] piles, int h) {

        int maxBananas = findLargestPile(piles);

        return binarySearch(piles, h, 1, maxBananas);
    }

    private int binarySearch(int[] piles, int h, int minEaten, int maxEaten) {
        while (true) {
            int eatenGuess = minEaten + (maxEaten - minEaten) / 2;

            int hoursNeeded = calculateHoursNeededToEat(piles, eatenGuess);

            if (hoursNeeded == h) {
                return eatenGuess;
                //not exact, but close as we can get
            } else if (hoursNeeded < h && calculateHoursNeededToEat(piles, eatenGuess - 1) > h) {
                return eatenGuess;
            } else if (hoursNeeded > h) {
                minEaten = eatenGuess + 1;
            } else {
                maxEaten = eatenGuess - 1;
            }
        }
    }

    private int calculateHoursNeededToEat(int[] piles, int bananasEatenPerHour) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / bananasEatenPerHour;
            if (pile % bananasEatenPerHour != 0) {
                hours++;
            }
        }

        return hours;
    }

    private int findLargestPile(int[] piles) {
        return IntStream.of(piles).max().getAsInt();
    }
}
