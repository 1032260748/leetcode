package com.hupo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class LetterCombinationsSolution {

    private static Map<Integer, List<String>> map;

    static {
        map = new HashMap<>();
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        trans(0, digits, "", result);
        return result;
    }

    private void trans(int index, String digits, String prefix, List<String> result) {
        if (index >= digits.length()) {
            result.add(prefix);
            return;
        }
        List<String> currentList = map.get(digits.charAt(index) - '0');
        for (int i = 0; i <= currentList.size() - 1; i++) {
            trans(index + 1, digits, prefix + currentList.get(i), result);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                System.out.print(getSectionNumber(i, j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public Set<String> minSet(String min, Set<String> set) {

        Set<String> oneStep = new HashSet<>();
        for (String item : set) {
            if (diff(item, min) == 1) {
                oneStep.add(item);
            }
        }

        for (String item : oneStep) {
            set.remove(item);
        }
        return oneStep;
    }

    public int diff(String m, String n) {
        int diff = 0;
        for (int i = 0; i <= m.length() - 1; i++) {
            if (n.charAt(i) != m.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> lineSetList = new HashMap(9);
        Map<Integer, Set<Character>> columnSetList = new HashMap(9);
        Map<Integer, Set<Character>> sectionSetList = new HashMap(9);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Character character = board[i][j];
                if (character == '.') {
                    continue;
                }
                if (!lineSetList.containsKey(i)) {
                    lineSetList.put(i, new HashSet<>());
                }
                if (lineSetList.get(i).contains(character)) {
                    return false;
                }
                lineSetList.get(i).add(character);
                if (!columnSetList.containsKey(j)) {
                    columnSetList.put(j, new HashSet<>());
                }
                if (columnSetList.get(j).contains(character)) {
                    return false;
                }
                columnSetList.get(j).add(character);

                int sectionNum = getSectionNumber(i, j);
                if (!sectionSetList.containsKey(sectionNum)) {
                    sectionSetList.put(sectionNum, new HashSet<>());
                }
                if (sectionSetList.get(sectionNum).contains(character)) {
                    return false;
                }
                sectionSetList.get(sectionNum).add(character);
            }
        }
        return true;
    }

    public static int getSectionNumber(int i, int j) {
        return i / 3 * 3 + (j / 3);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            if (map.containsKey(nums[i])) {
                Integer preIndex = map.get(nums[i]);
                if (Math.abs(i - preIndex) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
