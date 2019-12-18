package com.hupo.leetcode;


public class MaxArea {
    public int maxArea(int[] height) {

        if (height == null || height.length == 1) {
            return 0;
        }

        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int min = Math.min(height[left], height[right]);
            int tempArea = (right - left) * min;
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{7, 7, 7, 7};
        int maxArea = new MaxArea().maxArea(height);
        System.out.println(maxArea);
    }

}
