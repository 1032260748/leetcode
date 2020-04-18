package com.hupo.leetcode.str;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {

    public int titleToNumber(String s) {
        int sum = 0;
        if (s == null || s.length() == 0) {
            return sum;
        }
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 26 + (s.charAt(i) - 'A' + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean result = isIsomorphic("ab", "aa");
        System.out.println(result);
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            Character target = t.charAt(i);
            if (map.containsKey(character)) {
                if (!map.get(character).equals(target)) {
                    return false;
                }
            } else if (map.containsKey(target)) {
                if (!map.get(target).equals(character)) {
                    return false;
                }
            } else {
                map.put(character, target);
            }
        }
        return true;
    }
}
