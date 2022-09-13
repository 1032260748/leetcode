package com.hupo.leetcode.str;

public class ConvertToTitle {

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = (left + right) / 2;
            long ping = (long) mid * mid;
            if (ping == x) {
                return mid;
            } else if (ping > x) {
                right = mid - 1;
            } else if (ping < x) {
                left = mid + 1;
            }
        }
        if (left * left <= x) {
            return left;
        } else {
            return left - 1;
        }
    }

    public int lengthOfLastWord(String s) {
        int result = 0;
        char lastChar = ' ';
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) != ' ') {
                if (lastChar == ' ') {
                    result = 1;
                } else {
                    result++;
                }
            }
            lastChar = s.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertToTitle solution = new ConvertToTitle();
        int count = solution.mySqrt(2147395599);
        System.out.println(count);
    }

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return null;
        }
        int re;
        int temp = columnNumber;
        StringBuffer resultBuffer = new StringBuffer();
        while (temp > 26) {
            re = temp % 26;
            temp = temp / 26;
            resultBuffer.insert(0, (char) (re + 'A' - 1));
        }
        return resultBuffer.toString();

    }
}
