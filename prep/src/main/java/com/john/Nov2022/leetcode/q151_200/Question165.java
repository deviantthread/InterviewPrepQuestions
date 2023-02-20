package com.john.Nov2022.leetcode.q151_200;

public class Question165 {
    public int compareVersion(String version1, String version2) {
        String[] version1List = split(version1);
        String[] version2List = split(version2);

        for (int i = 0; i < Math.max(version1List.length, version2List.length); i++) {
            String version1Str = i < version1List.length ? version1List[i] : "0";
            String version2Str = i < version2List.length ? version2List[i] : "0";

            int compareTo = Integer.compare(Integer.parseInt(version1Str), Integer.parseInt(version2Str));
            if (compareTo != 0) {
                return compareTo;
            }
        }

        return 0;
    }

    private String[] split(String version) {
        return version.split("\\.");
    }
}
