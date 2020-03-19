package com.hupo.leetcode.array;

public class SingleData {

    public static void main(String[] args) {
        SingleData singleData = new SingleData();
        int[] result = singleData.singleNumbers(new int[]{4, 1, 4, 6});
        System.out.println(result);
    }

    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            temp = temp ^ nums[i];
        }

        int i = 0;
        while (i <= 32) {
            if ((temp & (1 << i)) != 0) {
                break;
            }
            i++;
        }

        int result1 = 0;
        int result2 = 0;

        for (int j = 0; j <= nums.length - 1; j++) {
            if ((nums[j] & 1 << i) != 0) {
                result1 = result1 ^ nums[j];
            } else {
                result2 = result2 ^ nums[j];
            }
        }

        return new int[]{result1, result2};

    }
}
