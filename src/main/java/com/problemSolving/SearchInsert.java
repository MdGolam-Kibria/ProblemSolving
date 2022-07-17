package com.problemSolving;

public class SearchInsert {
    public static void main(String[] args) {
        int genArr[] = {1,3,5,6};
        System.out.println(SearchInsert.searchInsert(genArr,7));
    }
    public static int searchInsert(int[] nums, int target) {
        int current;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            if (current>target){
                return 0;
            }
            if (current==target) return i;
            if (i==nums.length-1){
                return i+1;
            }
            if (current<target&& target<nums[i+1]){
                return i+1;
            }
            continue;
        }
        return 0;
    }
}
