package com.hupo.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        subsetsWithDup(nums, 0, temp, result);

        return result;
    }

    public static void main(String[] args) {
        SubSet subSet = new SubSet();

        int[] nums = new int[]{1, 2, 2};

        List<List<Integer>> result = subSet.subsetsWithDup(nums);
        System.out.println(result);
    }


    public void subsetsWithDup(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        subsetsWithDup(nums, index + 1, temp, result);
        temp.remove(temp.size() - 1);

        int next = nums.length;
        for (int j = index + 1; j <= nums.length - 1; j++) {
            if (nums[j] != nums[index]) {
                next = j;
                break;
            }
        }
        subsetsWithDup(nums, next, temp, result);

    }


    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int[] temp = new int[nums.length];


        List<List<Integer>> result = new ArrayList<>();

        do {
            result.add(convertToList(temp, nums));
        }
        while (next(temp));


        return result;
    }


    private List<Integer> convertToList(int[] temp, int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= temp.length - 1; i++) {
            if (temp[i] == 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }


    public boolean next(int[] temp) {

        boolean find = false;
        int index = temp.length;

        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] == 0) {
                find = true;
                index = i;
                temp[i] = 1;
                break;
            }
        }

        if (find) {
            for (int i = temp.length - 1; i > index; i--) {
                temp[i] = 0;
            }
        }

        return find;
    }

}
