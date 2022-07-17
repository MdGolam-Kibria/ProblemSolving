package com.problemSolving.leetCode;

/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the
signed 32-bit integer range [-231, 231 - 1], then return 0.


Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

-231 <= x <= 231 - 1
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(getReverseInteger());
    }

    public static int getReverseInteger() {
        int a = 1534236469;
        StringBuilder builder = new StringBuilder(String.valueOf(a));
        try {
            if (builder.toString().charAt(0) == '-') {
                return Integer.parseInt("-" + builder.reverse().substring(0, builder.length() - 1));
            }
            return Integer.parseInt(builder.reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
