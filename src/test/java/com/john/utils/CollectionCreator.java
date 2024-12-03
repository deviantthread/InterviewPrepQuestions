package com.john.utils;

import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

public class CollectionCreator {

    /**
     * Input format "[-1,0,1,2,-1,-4]"
     */
    public static int[] createArrayInt(String input) {
        if (input.equals("[]")) {
            return new int[0];
        }
        return createListInt(input).stream().mapToInt(i -> i).toArray();
    }

    /**
     * Input format "[-1,0,1,2,-1,-4]"
     */
    public static List<Integer> createListInt(String input) {
        if (input.equals("[]")) {
            return new ArrayList<>();
        }
        String trimmed = StringUtils.removeEnd(StringUtils.removeStart(input, "["), "]");
        return Splitter.on(",").splitToStream(trimmed)
            .map(StringUtils::trim)
            .map(Integer::parseInt).collect(Collectors.toList());
    }

    /**
     * Input format "[[-1,-1,2],[-1,0,1]]"
     */
    public static List<List<Integer>> createListListInt(String input) {
        if (input.equals("[]")) {
            return new ArrayList<>();
        }

        String trimmed = StringUtils.removeEnd(StringUtils.removeStart(input, "["), "]");

        return Splitter.on("[").omitEmptyStrings().splitToStream(trimmed)
            .map(listStr -> StringUtils.removeEnd(listStr, "]"))
            .map(listStr -> StringUtils.removeEnd(listStr, "],"))
            .map(listStr -> Splitter.on(",").omitEmptyStrings().splitToStream(listStr)
                .map(Integer::parseInt)
                .collect(Collectors.toList()))
            .collect(Collectors.toList());
    }

    /**
     * Input format "[[1,3],[2,6],[8,10],[15,18]]"
     */
    public static int[][] create2DArrayInt(String input) {
        List<List<Integer>> listListInt = createListListInt(input);

        return listListInt.stream()
            .map(list -> list.stream().mapToInt(i -> i).toArray())
            .toArray(int[][]::new);
    }

    /**
     * Input format "[[A,B,C,E],[S,F,C,S],[A,D,E,E]]"
     */
    public static char[][] create2DArrayChar(String input) {
        String trimmed = StringUtils.removeEnd(StringUtils.removeStart(input, "["), "]");

        Character[][] characters = Splitter.on("[").omitEmptyStrings().splitToStream(trimmed)
            .map(listStr -> StringUtils.removeEnd(listStr, "]"))
            .map(listStr -> StringUtils.removeEnd(listStr, "],"))
            .map(listStr -> Splitter.on(",").omitEmptyStrings().splitToStream(listStr)
                .map(str -> str.charAt(0))
                .collect(Collectors.toList())
                .toArray(new Character[0]))
            .collect(Collectors.toList())
            .toArray(new Character[0][]);

        char[][] ret = new char[characters.length][];
        for (int row = 0; row < characters.length; row++) {
            ret[row] = new char[characters[row].length];
            for (int col = 0; col < characters[row].length; col++) {
                ret[row][col] = characters[row][col];
            }
        }

        return ret;
    }

    /**
     * Input format "[ThisDEL is anDEL example, DEL ofDEL some inputDEL text.]"
     * DEL for delimiter
     */
    public static String[] createArrayString(String input) {
        return createListString(input).toArray(new String[0]);
    }

    /**
     * Input format "[ThisDEL is anDEL example, DEL ofDEL some inputDEL text.]"
     * DEL for delimiter
     */
    public static List<String> createListString(String input) {
        String trimmed = StringUtils.removeEnd(StringUtils.removeStart(input, "["), "]");

        return Splitter.on("DEL").omitEmptyStrings()
            .splitToStream(trimmed)
            .collect(Collectors.toList());
    }
}
