package com.hupo.leetcode.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightDialer {

    public static void main(String[] args) {
        KnightDialer knightDialer = new KnightDialer();
        System.out.println(knightDialer.knightDialer(3131));
    }

    public int knightDialer(int n) {
        int mod = ((int) (Math.pow(10, 9)) + 7);
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(4, 6));
        map.put(1, Arrays.asList(8, 6));
        map.put(2, Arrays.asList(7, 9));
        map.put(3, Arrays.asList(8, 4));
        map.put(4, Arrays.asList(0, 3, 9));
        map.put(6, Arrays.asList(0, 7, 1));
        map.put(7, Arrays.asList(2, 6));
        map.put(8, Arrays.asList(1, 3));
        map.put(9, Arrays.asList(2, 4));
        int[][] result = new int[10][n + 1];
        for (int i = 0; i <= 9; i++) {
            result[i][1] = 1;
        }

        for (int j = 2; j <= n; j++) {

            for (int i = 0; i <= 9; i++) {
                if (!map.containsKey(i)) {
                    result[i][j] = 0;
                    continue;
                }
                List<Integer> to = map.get(i);
                int sum = 0;
                for (Integer integer : to) {
                    sum = (sum + result[integer][j - 1]) % mod;
                }
                result[i][j] = sum;
            }
        }


        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + result[i][n]) % mod;
        }
        return sum;
    }
}
