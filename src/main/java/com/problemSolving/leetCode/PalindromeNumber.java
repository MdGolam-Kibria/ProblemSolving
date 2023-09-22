package com.problemSolving.leetCode;

public class PalindromeNumber {
    public static void main(String[] args) {
        int  val = 121;
        StringBuilder builder = new StringBuilder();
        builder.append(val);
        if (builder.toString().equals(builder.reverse().toString())){
            System.out.println("Palindrome Number");
        }else {
            System.out.println("Not Palindrome Number");
        }
    }
}
