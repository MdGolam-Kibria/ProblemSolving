package com.problemSolving.leetCode;

public class BinarySum {
    /**
     Common tricks to convert char to int (ASCII value of char).
     char-0 = int value like value
     '1' -0;
     */
    public static void main(String[] args) {
        System.out.println('0' - '0');
        System.out.println('1' - '0');

        System.out.println(new BinarySum().addBinary("0", "0")); // Should output "10101"
    }

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += (int) a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += (int) b.charAt(j--) - '0';
            }
            result.insert(0, sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            result.insert(0, 1);
        }
        return result.toString();
    }

}