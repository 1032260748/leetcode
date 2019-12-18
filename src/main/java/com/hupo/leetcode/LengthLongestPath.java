package com.hupo.leetcode;


import java.util.*;

public class LengthLongestPath {


    public int lengthLongestPath(String input) {
        return 0;
    }


    public String originalDigits(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character character : s.toCharArray()) {
            if (charMap.containsKey(character)) {
                charMap.put(character, charMap.get(character) + 1);
            } else {
                charMap.put(character, 1);
            }
        }

        Map<Integer, Integer> integerMap = new HashMap<>();

        Map<Character, Set<String>> tempMap = new HashMap<>();

        return null;
    }


}
