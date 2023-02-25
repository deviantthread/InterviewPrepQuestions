package com.john.Nov2022.leetcode.q51_100;

import java.util.ArrayList;
import java.util.List;

public class Question68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();

        // first pass, group words together into correct lines
        List<String> curr = new ArrayList<>();
        int currLen = 0;
        for (String word : words) {
            if (curr.isEmpty() && word.length() >= maxWidth) {
                curr.add(word);
                lines.add(curr);
                curr = new ArrayList<>();
            } else if (currLen + word.length() + 1 <= maxWidth) {
                curr.add(word);
                currLen += word.length() + 1;
            } else {
                lines.add(curr);
                curr = new ArrayList<>();
                curr.add(word);
                currLen = word.length();
            }
        }

        if (!curr.isEmpty()) {
            lines.add(curr);
        }

        // then pad each line to be the correct length
        List<String> result = new ArrayList<>(lines.size());

        for (int lineIdx = 0; lineIdx < lines.size() - 1; lineIdx++) {
            List<String> lineList = lines.get(lineIdx);
            int wordsLen = lineList.stream().map(String::length).mapToInt(n -> n).sum();

            int spacesToAdd = maxWidth - wordsLen;

            int spaceLocations = Math.max(lineList.size() - 1, 1);

            int spacesPerLocation = spacesToAdd / spaceLocations;
            int remainderSpaces = spacesToAdd % spaceLocations;

            StringBuilder lineSb = new StringBuilder(lineList.get(0));

            for (int wordIdx = 1; wordIdx < lineList.size(); wordIdx++) {
                for (int i = 0; i < spacesPerLocation; i++) {
                    lineSb.append(" ");
                }
                if (remainderSpaces > 0) {
                    lineSb.append(" ");
                    remainderSpaces--;
                }
                lineSb.append(lineList.get(wordIdx));
            }

            if (lineList.size() == 1) {
                for (int i = 0; i < spacesPerLocation; i++) {
                    lineSb.append(" ");
                }
            }

            result.add(lineSb.toString());
        }

        // last line only pad on the right side
        List<String> lastLine = lines.get(lines.size() - 1);
        int wordsLen = lastLine.stream().map(String::length).mapToInt(n -> n).sum();
        wordsLen += lastLine.size() - 1; // add the normal spaces

        int spacesToAdd = maxWidth - wordsLen;

        String lastLineWords = String.join(" ", lastLine);
        StringBuilder lastLineSB = new StringBuilder(lastLineWords);

        for (int i = 0; i < spacesToAdd; i++) {
            lastLineSB.append(" ");
        }
        result.add(lastLineSB.toString());

        return result;
    }
}
