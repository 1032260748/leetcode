package com.hupo.leetcode.str;

public class PatternMatch {

    public boolean isMatch(String s, String p) {

        if (s == "" || s == null) {
            if (p == null) {
                return false;
            }
            if (p == "" || p == "*") {
                return true;
            }
            return false;
        }
        if (p == "" || p == null) {
            return false;
        }

        int[][] array = new int[s.length()][p.length()];

        if (p.charAt(0) == '*') {
            for (int i = 0; i < s.length(); i++) {
                array[i][0] = 1;
            }
        } else if (p.charAt(0) == '?') {
            array[0][0] = 1;
        } else if (p.charAt(0) != s.charAt(0)) {
            return false;
        } else {
            array[0][0] = 1;
        }

        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                array[0][i] = array[0][i - 1];
            } else if (p.charAt(i) == s.charAt(0) || p.charAt(i) == '?') {
                if (p.charAt(i - 1) == '*') {
                    array[0][i] = array[0][i - 1];
                }
            }
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    if (array[i - 1][j - 1] == 1) {
                        array[i][j] = 1;
                    }
                }
                if (p.charAt(j) == '*') {
                    if (array[i - 1][j - 1] == 1 || array[i][j - 1] == 1 || array[i - 1][j] == 1) {
                        array[i][j] = 1;
                    }
                }

            }
        }

        return array[s.length() - 1][p.length() - 1] == 1;
    }

    public static void main(String[] args) {
        PatternMatch match = new PatternMatch();
        //System.out.println(match.isMatch("aa", "*"));
        System.out.println(match.isMatch("", ""));
    }


}
