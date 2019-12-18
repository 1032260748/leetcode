package com.hupo.leetcode;

public class MakeSquare {
    public boolean makesquare(int[] nums) {

        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            sum = sum + nums[i];
        }


        //如果和不是4的倍数
        if (sum % 4 != 0) {
            return false;
        }


        return false;
    }
}
