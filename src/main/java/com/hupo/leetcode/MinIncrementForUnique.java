package com.hupo.leetcode;

import java.util.Arrays;

/**
 * 最小变动能使数组唯一
 */
public class MinIncrementForUnique {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int start = A[0];
        int total = 0;
        int target = start + 1;
        for (int i = 1; i <= A.length - 1; i++) {
            if (A[i] < target) {
                total = target - A[i];
                target = target + 1;
            } else {
                target = A[i] + 1;
            }
        }
        return total;
    }
}
