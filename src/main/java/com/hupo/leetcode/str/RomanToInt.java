package com.hupo.leetcode.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt solution = new RomanToInt();
        boolean result = solution.isHappy(2);
        System.out.println(result);
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int temp = n;
        while (temp != 1) {
            if (set.contains(temp)) {
                return false;
            }
            set.add(temp);
            int sum = 0;
            while (temp != 0) {
                int yu = temp % 10;
                sum = sum + yu * yu;
                temp = temp / 10;
            }
            temp = sum;
        }
        return true;
    }

    private Map<String, Integer> initMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        return map;
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = initMap();
        int sum = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            char current = s.charAt(i);
            if (current == 'V' || current == 'X') {
                if (!stack.isEmpty() && stack.peek() == 'I') {
                    char pre = stack.pop();
                    sum = sum + map.get("" + pre + current);
                } else {
                    stack.push(current);
                }
            } else if (current == 'L' || current == 'C') {
                if (!stack.isEmpty() && stack.peek() == 'X') {
                    char pre = stack.pop();
                    sum = sum + map.get("" + pre + current);
                } else {
                    stack.push(current);
                }
            } else if (current == 'D' || current == 'M') {
                if (!stack.isEmpty() && stack.peek() == 'C') {
                    char pre = stack.pop();
                    sum = sum + map.get("" + pre + current);
                } else {
                    stack.push(current);
                }
            } else {
                stack.push(current);
            }
        }
        while (!stack.isEmpty()) {
            sum = sum + map.get(stack.pop() + "");
        }
        return sum;
    }
}
