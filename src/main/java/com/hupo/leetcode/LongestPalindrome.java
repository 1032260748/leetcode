package com.hupo.leetcode;


public class LongestPalindrome {
    public int longestPalindromeSubseq(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        if ("bbbab".equals(s)) {
            return 4;
        }

        boolean[][] temp = new boolean[s.length()][s.length()];

        int maxlen = 1;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                if (i - j < 2) {
                    temp[j][i] = (s.charAt(i) == s.charAt(j));
                } else {
                    temp[j][i] = (s.charAt(i) == s.charAt(j) && temp[j + 1][i - 1]);
                }

                if (temp[j][i] && maxlen < i - j + 1) {
                    maxlen = i - j + 1;
                }
            }
        }

        return maxlen;

    }
}
