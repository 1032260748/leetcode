package com.hupo.leetcode.array;

import java.util.Map;

public class SmallestRangeI {

    public int smallestRangeI(int[] A, int K) {

        int max = A[0];
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(A[i], max);
            min = Math.min(A[i], min);
        }
        if (max - K <= min + K) {
            return 0;
        } else {
            return max - K - (min + K);
        }

    }
}
