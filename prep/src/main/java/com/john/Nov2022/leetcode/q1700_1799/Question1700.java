package com.john.Nov2022.leetcode.q1700_1799;

import java.util.LinkedList;
import java.util.Queue;

public class Question1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsInLine = new LinkedList<>();
        for (int student : students) {
            studentsInLine.add(student);
        }
        Queue<Integer> studentsWhoPassed = new LinkedList<>();
        int sandwichIdx = 0;

        boolean atLeastOneStudentTookASandwich = true;
        while (atLeastOneStudentTookASandwich && !studentsInLine.isEmpty()) {
            atLeastOneStudentTookASandwich = false;

            while (!studentsInLine.isEmpty()) {
                int student = studentsInLine.poll();

                // let the student eat cake
                if (sandwiches[sandwichIdx] == student) {
                    atLeastOneStudentTookASandwich = true;
                    sandwichIdx++;
                } else {
                    studentsWhoPassed.add(student);
                }
            }

            studentsInLine = studentsWhoPassed;
            studentsWhoPassed = new LinkedList<>();
        }

        return studentsInLine.size();
    }
}
