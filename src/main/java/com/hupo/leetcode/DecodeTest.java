package com.hupo.leetcode;

public class DecodeTest {

    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.startsWith("0")) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int[] result = new int[s.length()];
        result[0] = 1;

        if (s.charAt(1) == '0') {
            if (s.charAt(0) >= '3') {
                return 0;
            } else {
                result[1] = 1;
            }
        } else {
            if (Integer.parseInt(s.substring(0, 2)) <= 26) {
                result[1] = 2;
            } else {
                result[1] = 1;
            }
        }

        for (int i = 2; i <= s.length() - 1; i++) {

            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) >= '3' || s.charAt(i - 1) == '0') {
                    return 0;
                } else {
                    result[i] = result[i - 2];
                    continue;
                }
            }

            if (s.charAt(i - 1) == '0') {
                result[i] = result[i - 1];
                continue;
            }

            if (Integer.parseInt(Character.toString(s.charAt(i - 1)) + s.charAt(i)) <= 26) {
                result[i] = result[i - 1] + result[i - 2];
            } else {
                result[i] = result[i - 1];
            }
        }

        return result[s.length() - 1];
    }
}
