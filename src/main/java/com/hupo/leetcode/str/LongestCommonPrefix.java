package com.hupo.leetcode.str;


public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        String str = commonPrefix.longestCommonPrefix(new String[]{"acc", "aaa", "aaba"});
        System.out.println(str);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return commonPrefix(strs, 0, strs.length - 1);
    }

    private String commonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }

        int mid = (left + right) / 2;
        String leftPrefix = commonPrefix(strs, left, mid);
        String rightPrefix = commonPrefix(strs, mid + 1, right);
        return commonPrefix(leftPrefix, rightPrefix);
    }

    private String commonPrefix(String m, String n) {
        if (m == "" || n == "" || m == null || n == null) {
            return "";
        }
        int count = 0;
        for (int i = 0; i <= Math.min(m.length(), n.length()) - 1; i++) {
            if (m.charAt(i) == n.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        if (count == 0) {
            return "";
        }
        return m.substring(0, count);
    }
}
