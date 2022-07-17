package com.problemSolving.leetCode;

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


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
       // System.out.printf("" + getMedianofTwoSortedArrays());
        int a = 2^3;
        System.out.println(a);
    }

    public static double getMedianofTwoSortedArrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};
        int shortedArray[] = margedShortedArray(nums1, nums2);
        int midPosition = shortedArray.length % 2;
        double actualMidVal = 0;
        int quationt = shortedArray.length / 2;
        if (midPosition == 0) {
            actualMidVal = shortedArray[quationt] + shortedArray[quationt - 1];
            actualMidVal = actualMidVal/2;
            return actualMidVal;
        }
        return shortedArray[quationt];
    }

    private static int[] margedShortedArray(int[] nums1, int[] nums2) {
        int[] concatedArray = new int[nums1.length + nums2.length];
        int fastArrLen = nums1.length;
        for (int i = 0; i < nums1.length; i++) {
            concatedArray[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            fastArrLen += 1;
            concatedArray[fastArrLen - 1] = nums2[i];
        }
        for (int i = 0; i < concatedArray.length; i++) {
            for (int j = 0; j < concatedArray.length; j++) {
                if (concatedArray[i] < concatedArray[j]) {
                    int temp = concatedArray[i];
                    concatedArray[i] = concatedArray[j];
                    concatedArray[j] = temp;
                }
            }
        }
        return concatedArray;
    }
}


