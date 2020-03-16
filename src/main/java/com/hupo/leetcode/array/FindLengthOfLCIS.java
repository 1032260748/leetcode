package com.hupo.leetcode.array;

public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {

        int maxLength = 0;
        if (nums == null || nums.length == 0) {
            return maxLength;
        }

        maxLength = 1;

        int currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                currentLength = currentLength + 1;
                maxLength = Math.max(currentLength, maxLength);
            } else {
                currentLength = 1;
            }
        }

        return maxLength;
    }
}
