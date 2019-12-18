package com.hupo.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //result 是以I结尾的最大值
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = result[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            if (result[i - 1] <= 0) {
                result[i] = nums[i];
            } else {
                result[i] = nums[i] + result[i - 1];
            }
            if (result[i] > max) {
                max = result[i];
            }
        }
        return max;
    }
}
