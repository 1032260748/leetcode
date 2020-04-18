package com.hupo.leetcode.str;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        int matchCount = 0;
        for (int i = 0; i <= t.length() - 1; i++) {
            if (t.charAt(i) == s.charAt(matchCount)) {
                matchCount++;
                if (matchCount == s.length()) {
                    break;
                }
            }
        }
        return matchCount == s.length();
    }
}
