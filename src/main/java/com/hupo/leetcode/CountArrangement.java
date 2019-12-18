package com.hupo.leetcode;

public class CountArrangement {

    public int countArrangement(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 2) {
            return 2;
        }
        if (N == 3) {
            return 3;
        }

        int[] result = new int[N + 1];
        result[1] = 0;
        result[2] = 2;
        result[3] = 3;

        for (int i = 4; i <= N; i++) {
            if (i % 2 == 0) {
                result[i] = result[i % 2] + 2;
            } else {
                int temp = getMax(i);
                result[i] = result[temp] + i / temp;
            }
        }

        return result[N];
    }

    private int getMax(int m) {
        for (int i = 3; i <= m / 2 + 1; i++) {
            if (m % i == 0) {
                return m / i;
            }
        }
        return 1;
    }

}
