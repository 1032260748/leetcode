package com.hupo.leetcode;

import java.util.Stack;


public class CalculateSolution {

    public static void main(String[] args) {
        int result = new CalculateSolution().calculate("3+2*2");
        System.out.println(result);
    }

    public int calculate(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        Stack<Character> flagStack = new Stack<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            Character current = s.charAt(i);
            if (Character.isDigit(current)) {
                stringBuffer.append(current);
            } else if (isFlag(current)) {
                Integer integer = Integer.parseInt(stringBuffer.toString());
                stringBuffer = new StringBuffer();
                stack.push(integer);
                if (isAdd(current)) {
                    while (!flagStack.isEmpty()) {
                        Character flag = flagStack.pop();
                        Integer right = stack.pop();
                        Integer left = stack.pop();
                        Integer result = cal(left, right, flag);
                        stack.push(result);
                    }
                } else if (isMulti(current)) {
                    while (!flagStack.isEmpty() && (isMulti(flagStack.peek()))) {
                        Character flag = flagStack.pop();
                        Integer right = stack.pop();
                        Integer left = stack.pop();
                        Integer result = cal(left, right, flag);
                        stack.push(result);
                    }
                }
                flagStack.push(current);
            }
        }
        if (stringBuffer.length() > 0) {
            stack.push(Integer.parseInt(stringBuffer.toString()));
        }
        while (!flagStack.isEmpty()) {
            Character flag = flagStack.pop();
            Integer right = stack.pop();
            Integer left = stack.pop();
            Integer result = cal(left, right, flag);
            stack.push(result);
        }
        return stack.pop();
    }

    private boolean isFlag(Character token) {
        return isAdd(token) || isMulti(token);
    }

    private boolean isAdd(Character token) {
        return '+' == token || '-' == token;
    }

    private boolean isMulti(Character token) {
        return '*' == token || '/' == token;
    }

    private int cal(int left, int right, Character token) {
        if ('+' == token) {
            return left + right;
        } else if ('-' == token) {
            return left - right;
        } else if ('*' == token) {
            return left * right;
        } else if ('/' == token) {
            return left / right;
        }
        throw new IllegalArgumentException("token");
    }

}
