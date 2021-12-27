package com.hupo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = twoSum.groupAnagrams(strs);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        int count = n > 0 ? n : (n) * -1;
        double result = 1;
        for (int i = 1; i <= count; i++) {
            result = result * x;
        }
        return n > 0 ? result : 1 / result;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String item : strs) {
            if (item == null) {
                continue;
            }
            String sortedStr = sort(item);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(item);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(item);
                map.put(sortedStr, tempList);
            }
        }
        return new ArrayList<>(map.values());
    }

    public String sort(String str) {
        char chars[] = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public int[] twoSum(int[] numbers, int target) {

        int result[] = new int[2];

        int left = 0;
        int right = numbers.length - 1;

        boolean find = false;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                find = true;
                break;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }
        }
        if (find) {
            result[0] = left + 1;
            result[1] = right + 1;
        }
        return result;
    }

}
