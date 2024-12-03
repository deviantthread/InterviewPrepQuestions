package com.john.leetcode.template.q1_99;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Question71 {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");

        LinkedList<String> absPath = new LinkedList<>();
        for (String part : parts) {
            if (part == null || part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!absPath.isEmpty()) {
                    absPath.removeLast();
                }
            } else {
                absPath.add(part);
            }
        }

        return absPath.stream()
            .collect(Collectors.joining("/", "/", ""));
    }
}
