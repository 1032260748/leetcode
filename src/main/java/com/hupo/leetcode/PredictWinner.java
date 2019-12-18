package com.hupo.leetcode;


public class PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        int maxChoose = maxChoose(nums, 0, nums.length - 1);

        int total = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            total = total + nums[i];
        }

        return maxChoose > total - maxChoose;
    }

    public int maxChoose(int[] nums, int start, int end) {

        if (start == end) {
            return nums[end];
        }
        if (start > end) {
            return 0;
        } else {
            int startMax = nums[start] + Math.min(maxChoose(nums, start + 2, end),
                    maxChoose(nums, start + 1, end - 1));

            int endMax = nums[end] + Math.min(maxChoose(nums, start + 1, end - 1),
                    maxChoose(nums, start, end - 2));

            return Math.max(startMax, endMax);

        }
    }

//    public int dynamicChoose(int[] nums) {
//        int n = nums.length;
//        int[][] dynamicArray = new int[nums.length][nums.length];
//
//        int[][]summary=new int
//        for (int i = 0; i <= nums.length - 1; i++) {
//            for (int j = 0; j + i < nums.length; j++) {
//                if (j == 0) {
//                    dynamicArray[i][i + j] = nums[i];
//                } else {
//                    dynamicArray[i][i + j] = nums[i]+   dynamicArray[i+1][j]
//                }
//            }
//        }
//    }


    public static void main(String[] args) {

        //int[] nums = new int[]{1, 5, 2};
        int[] nums = new int[]{1, 5, 233, 7};

        boolean predictResult = new PredictWinner().PredictTheWinner(nums);
        System.out.println(predictResult);
    }

}
