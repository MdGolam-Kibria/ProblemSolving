package com.problemSolving.leetCode;

import java.util.*;

public class SumClosest {
    public static boolean main(int n ) {
        int i = n / 2;
        if (Math.pow(2,i)==n) return true;
        return false;
    }

    public int strStr(String haystack, String needle) {
        if(Objects.equals(needle, "")) return 0;
        if (!haystack.contains(needle)) return -1;
        return needle.length();
    }
}
