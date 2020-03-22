package com.hupo.leetcode.array;


import java.util.concurrent.Semaphore;

public class StoneGame {

    public static void main(String[] args) {
        int[] piles = new int[]{1, 5, 2, 1};
        StoneGame stoneGame = new StoneGame();
        boolean result = stoneGame.stoneGame(piles);
        System.out.println(result);
    }

    public boolean stoneGame(int[] piles) {
        int[][][] result = new int[piles.length][piles.length][2];
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            result[i][i][1] = piles[i];
            result[i][i][0] = 0;
            sum = sum + piles[i];
        }
        for (int length = 1; length < piles.length; length++) {
            for (int i = 0; i < piles.length; i++) {
                if (i + length < piles.length) {
                    result[i][i + length][1] = Math.max(piles[i] + result[i + 1][i + length][0],
                            piles[i + length] + result[i][i + length - 1][0]);
                    result[i][i + length][0] = Math.min(result[i + 1][i + length][1],
                            result[i][i + length - 1][1]);
                }
            }
        }
        return result[0][piles.length - 1][1] >= sum / 2;
    }
}
