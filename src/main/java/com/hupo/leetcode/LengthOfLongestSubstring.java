package com.hupo.leetcode;

import java.util.HashSet;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring example = new LengthOfLongestSubstring();
        int max = example.lengthOfLongestSubstring("pwwkew");
        System.out.println(max);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        while (right <= s.length() - 1) {
            if (!set.contains(s.charAt(right))) {
                int tempMax = right - left + 1;
                if (tempMax > max) {
                    max = tempMax;
                }
                set.add(s.charAt(right));
                right = right + 1;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }

}
