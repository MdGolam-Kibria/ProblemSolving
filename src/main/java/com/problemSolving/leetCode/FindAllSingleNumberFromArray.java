package com.problemSolving.leetCode;

import java.util.HashMap;
import java.util.Map;

public class FindAllSingleNumberFromArray {
    public static void main(String[] args) {
        Map<Integer, Integer> singleItems = new HashMap<>();
        int[] arr = {1, 2, 3, 4, 5, 1,3, 2};
        for (int currentItem : arr) {
            if (!singleItems.containsKey(currentItem)) {
                singleItems.put(currentItem, currentItem);
            } else {
                singleItems.remove(currentItem);
            }
        }
        singleItems.forEach((integer, integer2) -> System.out.println(integer2));
    }
}
