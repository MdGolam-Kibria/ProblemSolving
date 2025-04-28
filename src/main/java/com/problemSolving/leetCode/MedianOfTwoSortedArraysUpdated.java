package com.problemSolving.leetCode;

import java.util.Arrays;

public class MedianOfTwoSortedArraysUpdated {
    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        MedianOfTwoSortedArraysUpdated c = new MedianOfTwoSortedArraysUpdated();
        System.out.println(c.findMedianSortedArrays(nums1, nums2));
        ;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);
        Arrays.sort(mergedArray);
        int mid = mergedArray.length / 2;
        int reminder = mergedArray.length % 2;
        System.out.println(Arrays.toString(mergedArray));
        if (reminder == 0) {
            int midMinusVal = mergedArray[mid - 1];
            int midVal = mergedArray[mid];
            double calculatedMedian = (midMinusVal + midVal) / 2.0;
            return calculatedMedian;
        } else
            return mergedArray[mid];
    }
}
