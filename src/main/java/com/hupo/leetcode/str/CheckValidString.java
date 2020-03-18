package com.hupo.leetcode.str;


public class CheckValidString {

    public static void main(String[] args) {
        CheckValidString checkValidString = new CheckValidString();
        boolean result = checkValidString.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
        System.out.println(result);
    }

    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        return checkValidString(s, 0, 0, 0);
    }

    private boolean checkValidString(String s, int start, int left, int right) {
        if (right > left) {
            return false;
        }
        if (start > s.length() - 1) {
            return left == right;
        }

        switch (s.charAt(start)) {
            case '(':
                left++;
                return checkValidString(s, start + 1, left, right);
            case ')':
                if (right + 1 > left) {
                    return false;
                }
                right++;
                return checkValidString(s, start + 1, left, right);
            case '*':
                return checkValidString(s, start + 1, left, right) ||
                        checkValidString(s, start + 1, left + 1, right) ||
                        checkValidString(s, start + 1, left, right + 1);
            default:
                return false;
        }
    }
}
