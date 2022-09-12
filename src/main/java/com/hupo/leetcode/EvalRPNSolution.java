package com.hupo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class EvalRPNSolution {

    private static Set<String> FLAG_SET = new HashSet<>();

    static {
        FLAG_SET.addAll(Arrays.asList("+", "-", "*", "/"));
    }

    public static void main(String[] args) {
        int result = new EvalRPNSolution().evalRPN(
                new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" });
        System.out.println(result);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (isFlag(tokens[i])) {
                int right = stack.pop();
                int left = stack.pop();
                int result = cal(left, right, tokens[i]);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    private boolean isFlag(String token) {
        return FLAG_SET.contains(token);
    }

    private int cal(int left, int right, String token) {
        if ("+".equals(token)) {
            return left + right;
        } else if ("-".equals(token)) {
            return left - right;
        } else if ("*".equals(token)) {
            return left * right;
        } else if ("/".equals(token)) {
            return left / right;
        }
        throw new IllegalArgumentException("token");
    }

}
