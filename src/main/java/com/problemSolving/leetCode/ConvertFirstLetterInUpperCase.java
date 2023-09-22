package com.problemSolving.leetCode;

public class ConvertFirstLetterInUpperCase {
    public static void main(String[] args) {
        StringBuilder val  = new StringBuilder();
        val.append("golam kibria java developer ");
        String[] s = val.toString().split(" ");
        val = new StringBuilder();
        for (String string : s) {
            String firstLettr = string.substring(0, 1);
            String restWrord = string.substring(1);
            val.append(firstLettr.toUpperCase()).append(restWrord).append(" ");
        }
        System.out.println(val.toString());
    }
}
