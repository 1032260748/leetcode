package com.hupo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CombinationSum2 {

    Map<Integer, Integer> countSet = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();
    private Integer target = 0;

    public static class Item {
        public Integer number;
        public Integer count;

        public Item(Integer number, Integer count) {
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] arrays = new int[] { 14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30,
                12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10,
                32, 22, 13, 34, 18, 12 };
        List<List<Integer>> ans = combinationSum2.combinationSum2(arrays, 27);
        System.out.println(ans);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        List<Integer> integers = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            int currentNumber = candidates[i];
            if (countSet.containsKey(currentNumber)) {
                countSet.put(currentNumber, countSet.get(currentNumber) + 1);
            } else {
                countSet.put(currentNumber, 1);
                integers.add(currentNumber);
            }
        }
        trans(integers, 0, 0, new ArrayList<>());
        return this.ans;
    }

    public void trans(List<Integer> numbers, int con, int preNum, List<Item> pres) {
        Integer currentNumber = numbers.get(con);
        Integer numberCount = countSet.get(currentNumber);
        for (int i = 0; i <= numberCount; i++) {
            pres.add(new Item(currentNumber, i));
            preNum += currentNumber * i;
            if (preNum < this.target) {
                if (con < numbers.size() - 1) {
                    trans(numbers, con + 1, preNum, pres);
                } else {
                    if (preNum == this.target) {
                        ans.add(getAnswer(pres));
                    }
                }
            } else if (preNum == this.target) {
                ans.add(getAnswer(pres));
            }
            pres.remove(pres.size() - 1);
            preNum -= currentNumber * i;
        }
    }

    private List<Integer> getAnswer(List<Item> pres) {
        List<Integer> result = new ArrayList<>();
        for (Item item : pres) {
            for (int i = 1; i <= item.count; i++) {
                result.add(item.number);
            }
        }
        return result;
    }

}
