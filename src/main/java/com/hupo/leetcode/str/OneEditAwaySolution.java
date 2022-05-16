package com.hupo.leetcode.str;

public class OneEditAwaySolution {

    /**
     * "teacher"
     * "taches"
     *
     * @param args
     */
    public static void main(String[] args) {
        OneEditAwaySolution solution = new OneEditAwaySolution();
        boolean result = solution.oneEditAway("teacher", "teacer");
        System.out.println(result);
    }

    public boolean oneEditAway(String first, String second) {
        if (first == null || first.length() == 0) {
            return (second == null || second.length() <= 1);
        }
        if (second == null || second.length() == 0) {
            return (first == null || first.length() <= 1);
        }

        int firstLength = first.length();
        int secondLength = second.length();

        if (Math.abs(firstLength - secondLength) >= 2) {
            return false;
        }

        if (firstLength == secondLength) {
            return diff(first, second) <= 1;
        } else {
            if (firstLength > secondLength) {
                return oneChar(first, second);
            } else {
                return oneChar(second, first);
            }
        }
    }

    public int diff(String first, String second) {
        int diff = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

    public boolean oneChar(String first, String second) {
        int differ = 0;
        int secondStart = 0;
        for (int i = 0; i < first.length(); i++) {
            if (secondStart >= second.length()) {
                break;
            }
            if (first.charAt(i) == second.charAt(secondStart)) {
                secondStart++;
            } else {
                differ++;
            }
        }
        return differ == 1;
    }

}
