package com.hupo.leetcode.array;

public class MinArray {

    public static void main(String[] args) {
        MinArray array = new MinArray();
        int[] nums = new int[]{3, 3, 1, 3};
        int min = array.minArray(nums);
        System.out.println(min);
    }

    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
