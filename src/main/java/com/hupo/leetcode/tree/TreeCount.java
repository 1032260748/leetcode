package com.hupo.leetcode.tree;

public class TreeCount {

    public int numTrees(int n) {

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int result[] = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            result[i] = 0;
            for (int j = 1; j <= i; j++) {
                result[i] = result[i] + result[j - 1] * result[i - j];
            }
        }
        return result[n];
    }
}
