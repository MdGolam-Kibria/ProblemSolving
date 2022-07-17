package com.problemSolving.leetCode;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(main());
    }

    public static String main() {
        String[] strs = {"cir", "car"};
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder ab = new StringBuilder();
        String first = strs[0];
        int match = 0;
        for (int i = 0; i < first.length(); i++) {
            match = 0;
            char current = 0;
            for (int i1 = 0; i1 < strs.length; i1++) {
                if (i1 == 0) {
                    continue;
                }
                if (strs[i1].length() - 1 < i) {
                    break;
                }
                if (first.charAt(i) == strs[i1].charAt(i)) {
                    current = first.charAt(i);
                    match += 1;

                }
            }
            if (match == strs.length - 1) {
                ab.append(current);
            }else {
                return ab.toString();
            }
        }

        return ab.toString();
    }
}
