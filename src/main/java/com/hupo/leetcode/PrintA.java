package com.hupo.leetcode;


public class PrintA {


    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }

        if (n % 2 == 0) {
            return minSteps(n / 2) + 2;
        }
        for (int i = 3; i <= n / 2 + 1; i++) {
            if (n % i == 0) {
                return minSteps(n / i) + i;
            }
        }

        return minSteps(1) + n;
    }


}
