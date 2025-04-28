package com.problemSolving.leetCode;

import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        //plusOne(new int[]{1,2,3});
       /* int[] digits = {
                9, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7,
                7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 9
        };*/
        int[] digits = {
                0, 9, 9
        };
/*
        int[] digits = {
               90,100
        };
*/

       // System.out.println(Arrays.toString(plusOne(digits)));
        System.out.println(Arrays.toString(plusOne2(digits)));
    }

    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static int[] plusOne(int[] digits) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            builder.append(String.valueOf(digits[i]));
        }
        BigInteger value = new BigInteger(builder.toString());
        value = value.add(BigInteger.ONE);
        int[] split = new int[String.valueOf(value).length()];
        for (int i = 0; i < String.valueOf(value).split("").length; i++) {
            split[i] = Integer.parseInt(String.valueOf(value).split("")[i]);
        }
        return split;
    }


}
