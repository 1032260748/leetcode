package com.hupo.leetcode;

import java.util.Stack;

public class DeleteDigitsClass {

    public static void main(String[] args) {
        DeleteDigitsClass digitsClass = new DeleteDigitsClass();
        String result = digitsClass.DeleteDigits("90249", 1);
        System.out.println(result);
    }

    /**
     * @param A: A positive integer which has N digits, A is a string
     * @param k: Remove k digits
     * @return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here

        if (A == null || A.length() == 0 || A.length() <= k) {
            return "";
        }

        Stack<Character> stack = new Stack<>();

        int deleteSize = 0;

        int index = 0;

        while (deleteSize < k && index <= A.length() - 1) {
            if (stack.isEmpty()) {
                stack.push(A.charAt(index));
                index++;
            } else {
                Character top = stack.peek();
                if (top.compareTo(A.charAt(index)) > 0) {
                    stack.pop();
                    deleteSize++;
                } else {
                    if (stack.size() < A.length() - k) {
                        stack.push(A.charAt(index));
                    }
                    index++;
                }
            }
        }


        String pre = "";

        while (!stack.isEmpty()) {
            pre = stack.pop() + pre;
        }

        if (pre.length() == A.length() - k) {
            return removeZero(pre);
        }

        String containsZero = pre + A.substring(index);

        return removeZero(containsZero);

    }


    private String removeZero(String containsZero) {
        for (int i = 0; i <= containsZero.length() - 1; i++) {
            if (containsZero.charAt(i) != '0') {
                return containsZero.substring(i);
            }
        }

        return "0";
    }


}
