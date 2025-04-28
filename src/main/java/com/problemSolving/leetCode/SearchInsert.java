package com.problemSolving.leetCode;
//leetCode  :  35. Search Insert position.
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current > target || current == target) {
                return i;
            }
            if (nums.length == i + 1) {
                if (current == target) {
                    return i;
                }
                result = i + 1;
                break;
            }
            if (nums[i + 1] >= target) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
