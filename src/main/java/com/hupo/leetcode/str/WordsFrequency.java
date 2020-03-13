package com.hupo.leetcode.str;

import java.util.*;

public class WordsFrequency {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();//存放最后的结果

        //先对数组进行排序
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length && candidates[i] <= remain; i++) {
                list.add(candidates[i]);
                backtrack(res, list, candidates, remain - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 2, 7, 6, 1, 5};
        WordsFrequency wordsFrequency = new WordsFrequency(new String[]{});
        System.out.println(wordsFrequency.combinationSum2(arr, 8));
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();//存放最后的结果

        //先对数组进行排序
        Arrays.sort(candidates);
        backtrack2(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private static void backtrack2(List<List<Integer>> res, List<Integer> list, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                backtrack(res, list, candidates, remain - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public int majorityElement(int[] nums) {

        int count = 1;
        int pre = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            if (count == 0) {
                pre = nums[i];
                count++;
                continue;
            }
            if (nums[i] == pre) {
                count++;
            } else {
                count--;
            }
        }
        return pre;
    }

    private Map<String, Integer> map = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (int i = 0; i < book.length; i++) {
            Integer count = map.get(book[i]);
            if (count == null) {
                map.put(book[i], 1);
            } else {
                map.put(book[i], count + 1);
            }
        }
    }

    public int get(String word) {
        Integer count = map.get(word);
        if (count == null) {
            return 0;
        }
        return count;
    }


    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        List<Integer> array = new ArrayList<>();
        int temp = x;
        while (temp > 0) {
            array.add(temp % 10);
            temp = temp / 10;
        }

        for (int i = 0; i <= array.size() / 2; i++) {
            if (!array.get(i).equals(array.get(array.size() - 1 - i))) {
                return false;
            }
        }
        return true;


    }
}
