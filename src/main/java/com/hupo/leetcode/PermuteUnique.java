package com.hupo.leetcode;

import java.util.*;

public class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        int[] array = new int[]{1, 2, 2};
        List<List<Integer>> result = permuteUnique.permuteUnique(array);
        System.out.println(result);
    }

    public void permuteUnique(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length - 1) {
            result.add(convertToList(nums));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, index, i);
                permuteUnique(nums, index + 1, result);
                swap(nums, index, i);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        permuteUnique(nums, 0, result);
        return result;
    }

    private List<Integer> convertToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= array.length - 1; i++) {
            list.add(array[i]);
        }
        return list;
    }

    private void swap(int[] array, int m, int n) {
        int temp = array[n];
        array[n] = array[m];
        array[m] = temp;
    }

}
