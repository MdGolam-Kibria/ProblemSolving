package com.problemSolving.leetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
PB = Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
//        String value = "aab";
        String value = "dvdf";
        int lengthOfLongestSubString = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = value.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (!map.containsKey(current)) {
                map.put(current, i);
            } else {
                i = map.get(current);
                map.clear();
            }
            if (map.size() > lengthOfLongestSubString) {
                lengthOfLongestSubString = map.size();
            }
        }
        System.out.println(lengthOfLongestSubString);
    }


    public int lengthOfLongestSubstring(String s) {
        int lengthOfLongestSubString = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char currentChar = arr[i];
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, i);
            } else {
                i = map.get(currentChar);
                map.clear();
            }
            if (map.size() > lengthOfLongestSubString) {
                lengthOfLongestSubString = map.size();
            }
        }
        return lengthOfLongestSubString;
    }
}
