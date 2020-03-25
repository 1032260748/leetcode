package com.hupo.leetcode.array;


public class MinDistance {

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance("123dgg", "123fd"));
    }

    public int minDistance(String word1, String word2) {

        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            result[0][i] = i;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = Math.min(result[i - 1][j - 1],
                            Math.min(result[i - 1][j], result[i][j - 1]) + 1);
                } else {
                    result[i][j] = Math.min(result[i - 1][j - 1] + 1,
                            Math.min(result[i - 1][j], result[i][j - 1]) + 1);
                }

            }
        }

        return result[word1.length()][word2.length()];

    }
}
