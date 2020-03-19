package com.hupo.leetcode.str;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharacters {

    public static void main(String[] args) {
        CountCharacters countCharacters = new CountCharacters();
        char c = countCharacters.firstUniqChar("lleet");
        System.out.println(c);
    }

    public char firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return ' ';
        }

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }

        return ' ';
    }

    public int countCharacters(String[] words, String chars) {

        int size = 0;
        if (words == null || words.length == 0 || chars == null || chars.length() == 0) {
            return size;
        }

        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            Character character = chars.charAt(i);
            if (charMap.containsKey(character)) {
                charMap.put(character, charMap.get(character) + 1);
            } else {
                charMap.put(character, 1);
            }
        }


        for (int i = 0; i < words.length; i++) {
            if (words[i] == null || words[i].length() == 0) {
                continue;
            }
            if (match(words[i], charMap)) {
                size = size + words[i].length();
            }
        }

        return size;

    }

    private boolean match(String word, Map<Character, Integer> charMap) {
        if (word == null || word.length() == 0) {
            return false;
        }

        Map<Character, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (!charMap.containsKey(character)) {
                return false;
            }
            if (!tempMap.containsKey(character)) {
                tempMap.put(character, 1);
            } else {
                int currentCount = tempMap.get(character);
                if (currentCount >= charMap.get(character)) {
                    return false;
                }
                tempMap.put(character, currentCount + 1);
            }
        }
        return true;
    }
}
