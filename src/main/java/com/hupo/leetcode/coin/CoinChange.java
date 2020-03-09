package com.hupo.leetcode.coin;


public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{1};
        System.out.println(coinChange.coinChange(coins, 1));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] result = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j <= coins.length - 1; j++) {
                int temp = i - coins[j];
                if (temp == 0) {
                    result[i] = 1;
                } else if (temp > 0 && result[temp] > 0) {
                    if (result[i] == 0) {
                        result[i] = result[temp] + 1;
                    } else {
                        if (result[i] > result[temp] + 1) {
                            result[i] = result[temp] + 1;
                        }
                    }
                }
            }
        }

        if (result[amount] > 0) {
            return result[amount];
        } else {
            return -1;
        }
    }
}
