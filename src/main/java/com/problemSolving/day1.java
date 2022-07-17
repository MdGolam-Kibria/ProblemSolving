package com.problemSolving;

import java.util.Arrays;

public class day1 {
    public static void main(String[] args) {
        int genArr[]  = {1,2,3,4};
        System.out.println(Arrays.toString(day1.runningSum(genArr)));
    }
    public static int[] runningSum(int[] nums) {
        int lastIndex = 0;
        int genArr[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                lastIndex = i;
                genArr[i] = nums[i];
                continue;
            }
            int sum = genArr[lastIndex]+nums[i];
            lastIndex = i;
            genArr[i] = sum;
        }
        return genArr;
    }
}
