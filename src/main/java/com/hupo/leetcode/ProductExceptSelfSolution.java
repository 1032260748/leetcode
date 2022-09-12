package com.hupo.leetcode;

public class ProductExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {

        int left[] = new int[nums.length];
        int right[] = new int[nums.length];

        int result[] = new int[nums.length];

        int leftTemp = 1;
        int rightTemp = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = leftTemp;
            leftTemp = leftTemp * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = rightTemp;
            rightTemp = rightTemp * nums[i];
        }

        for (int i = 0; i <= nums.length - 1; i++) {
            result[i] = left[i] * right[i];
        }

        return result;

    }
}
