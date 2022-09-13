package com.hupo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        LetterCombinationsSolution solution = new LetterCombinationsSolution();
        List<String> result = solution.letterCombinations("2");
        System.out.println(result);
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
