package com.john.datastructures;

import com.google.common.base.Splitter;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class ListUtils {

    /**
     * input in the format: "[1, null, 2, 3]"
     */
    public static List<Integer> create(String input) {
        return Splitter.on(",").omitEmptyStrings().splitToStream(StringUtils.strip(input, "[]"))
            .map(s -> s.equals("null") ? null : Integer.parseInt(s))
            .collect(Collectors.toList());
    }
}
