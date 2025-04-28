package com.problemSolving.leetCode;

import java.util.Arrays;

public class RemoveElementInPlace {
    public static void main(String[] args) {
        RemoveElementInPlace place = new RemoveElementInPlace();
        int[] arr = {3, 2, 2, 3};
        System.out.println(place.removeElement(arr, 3));
        System.out.println(Arrays.toString(arr));
    }

    public int removeElement(int[] nums, int val) {
        int indicator = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[indicator] = nums[i];
                indicator++;
            }
        }
        return indicator;
    }
}
