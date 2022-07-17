package com.problemSolving;

import java.util.StringTokenizer;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String a = "Hello World";
        System.out.println(lengthOfLastWord(a));
    }
    public static int lengthOfLastWord(String abc) {
         StringTokenizer stringTokenizer = new StringTokenizer(abc);
        int a = stringTokenizer.countTokens();
        String last = "";
        for (int i = 0; i < a; i++) {
            if (!stringTokenizer.hasMoreElements()) {
                break;
            }
            last = stringTokenizer.nextToken();
        }
       return last.length();
    }

}
