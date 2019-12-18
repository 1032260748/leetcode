package com.hupo.leetcode;

public class SecondBigInt {

    public static int find(int[] nums) {
        int first = nums[0];
        int second = nums[1];
        if (second > first) {
            int temp = first;
            first = second;
            second = temp;
        }

        for (int i = 2; i <= nums.length - 1; i++) {
            if (nums[i] >= first) {
                int temp = first;
                first = nums[i];
                second = temp;
            } else if (nums[i] <= second) {
                continue;
            } else if (nums[i] < first && nums[i] > second) {
                second = nums[i];
            }
        }

        return second;
    }
}
