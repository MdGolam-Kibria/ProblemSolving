package com.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfTwoSortedArraysUpdated {
    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2};
        // [1,2,3,4,5]

        System.out.println(getMid(nums1,nums2));
    }



    public static double getMid(int[] nums1, int[] nums2){
        List<Integer> mergedArray = new ArrayList<>();
        mergedArray.addAll(getAsList(nums1));
        mergedArray.addAll(getAsList(nums2));
        Collections.sort(mergedArray);

        int mergedArraySize = mergedArray.size();

        int mid = mergedArraySize/2;

        int temp = mergedArraySize % 2;

        double finalMId = 0.0;
        if (temp == 0) {
            Integer midLast = mergedArray.get(mid);
            Integer midFirst = mergedArray.get(mid-1);
            finalMId = (midFirst+midLast)/2.0;
        }else {
            finalMId = Double.parseDouble(String.valueOf(mergedArray.get(mid)));
        }
        return finalMId;
    }

    public static List<Integer> getAsList(int [] currentArr){
        List<Integer> list = Arrays.asList(Arrays.stream(currentArr).boxed().toArray(Integer[]::new));
        return list;
    }
}
