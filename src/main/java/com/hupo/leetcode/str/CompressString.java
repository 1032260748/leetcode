package com.hupo.leetcode.str;

public class CompressString {

    public static void main(String[] args) {
        CompressString compressString = new CompressString();
        compressString.compressString("");
    }

    public String compressString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char pre = s.charAt(0);
        int count = 1;

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < s.length() - 1; i++) {

            if (s.charAt(i) == pre) {
                count++;
            } else {
                builder.append(pre);
                builder.append(count);

                count = 1;
                pre = s.charAt(i);
            }
        }

        builder.append(pre);
        builder.append(count);

        if (builder.length() < s.length()) {
            return builder.toString();
        }
        return s;
    }
}
